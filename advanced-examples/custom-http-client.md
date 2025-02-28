# Custom HTTP Clients for the Kandy Java Helper Library

If you are working with the Kandy Java Helper Library, and you need to be able to modify the HTTP requests that the library makes to the Kandy servers, you’re in the right place. The most common need to alter the HTTP request is to connect and authenticate with an enterprise’s proxy server. We’ll provide sample code that you can drop right into your app to handle this use case.

## Connect and authenticate with a proxy server

To connect and provide credentials to a proxy server that may be between your app and Kandy, you need a way to modify the HTTP requests that the Kandy helper library makes on your behalf to invoke the Kandy REST API.

The Kandy Java helper library uses the HttpClient interface (in the org.apache.http.client package) under the hood to make the HTTP requests. With this in mind, the following two facts should help us arrive at the solution:

1. Connecting to a proxy server with HttpClient is a [solved problem](https://hc.apache.org/httpcomponents-client-ga/examples.html).
1. The Kandy Helper Library allows you to provide your own `HttpClient` for making API requests.

So the question becomes: how do we apply this to a typical Kandy REST API example?

```java
Kandy.init(ACCOUNT_SID, AUTH_TOKEN);

Message message = Message.creator(new PhoneNumber("+15558675310"),
        new PhoneNumber("+15017122661"), "Hey there!").create();
```

Where is `KandyRestClient` created and used? Out of the box, the helper library creates a default `KandyRestClient` for you, using the Kandy credentials you pass to the `init` method. However, nothing is stopping you from creating your own and using that.

Once you have your own `KandyRestClient`, you can pass it to any Kandy REST API resource action you want. Here’s an example of sending an SMS message with a custom client:

```java
// Install the Java helper library from kandy.com/docs/java/install
import com.kandy.Kandy;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.api.v2010.account.Message;
import com.kandy.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;

public class Example {

  public static void main(String args[]) {
    Dotenv dotenv = Dotenv.configure().directory(".").load();
    String ACCOUNT_SID = dotenv.get("ACCOUNT_SID");
    String AUTH_TOKEN = dotenv.get("AUTH_TOKEN");
    String PROXY_HOST = dotenv.get("PROXY_HOST");
    int PROXY_PORT = Integer.parseInt(dotenv.get("PROXY_PORT"));

    Kandy.init(ACCOUNT_SID, AUTH_TOKEN);

    ProxiedKandyClientCreator clientCreator = new ProxiedKandyClientCreator(
      ACCOUNT_SID,
      AUTH_TOKEN,
      PROXY_HOST,
      PROXY_PORT
    );
    KandyRestClient kandyRestClient = clientCreator.getClient();
    Kandy.setRestClient(kandyRestClient);

    Message message = Message
      .creator(
        new PhoneNumber("+15558675310"),
        new PhoneNumber("+15017122661"),
        "Hey there!"
      )
      .create();

    System.out.println(message.getSid());
  }
}
```

## Create your custom KandyRestClient

When you take a closer look at the constructor for `KandyRestClient`, you see that the `httpClient` parameter is actually of type `com.kandy.http.HttpClient`.

`HttpClient` is an abstraction that allows plugging in any implementation of an HTTP client you want (or even creating a mocking layer for unit testing).

However, within the helper library, there is an implementation of `com.kandy.http.HttpClient` called `NetworkHttpClient`. This class wraps the `org.apache.http.client.HttpClient` and provides it to the Kandy helper library to make the necessary HTTP requests.

## Call Kandy through the proxy server

Now that we understand how all the components fit together, we can create our own `KandyRestClient` that can connect through a proxy server. To make this reusable, here’s a class that you can use to create this `KandyRestClient` whenever you need one:

```java
import com.kandy.http.HttpClient;
import com.kandy.http.NetworkHttpClient;
import com.kandy.http.KandyRestClient;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class ProxiedKandyClientCreator {

  private String username;
  private String password;
  private String proxyHost;
  private int proxyPort;
  private HttpClient httpClient;

  /**
   * Constructor for ProxiedKandyClientCreator
   * @param username
   * @param password
   * @param proxyHost
   * @param proxyPort
   */
  public ProxiedKandyClientCreator(
    String username,
    String password,
    String proxyHost,
    int proxyPort
  ) {
    this.username = username;
    this.password = password;
    this.proxyHost = proxyHost;
    this.proxyPort = proxyPort;
  }

  /**
   * Creates a custom HttpClient based on default config as seen on:
   * {@link com.kandy.http.NetworkHttpClient#NetworkHttpClient() constructor}
   */
  private void createHttpClient() {
    RequestConfig config = RequestConfig
      .custom()
      .setConnectTimeout(10000)
      .setSocketTimeout(30500)
      .build();

    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    connectionManager.setDefaultMaxPerRoute(10);
    connectionManager.setMaxTotal(10 * 2);

    HttpHost proxy = new HttpHost(proxyHost, proxyPort);

    HttpClientBuilder clientBuilder = HttpClientBuilder.create();
    clientBuilder
      .setConnectionManager(connectionManager)
      .setProxy(proxy)
      .setDefaultRequestConfig(config);

    // Inclusion of Kandy headers and build() is executed under this constructor
    this.httpClient = new NetworkHttpClient(clientBuilder);
  }

  /**
   * Get the custom client or builds a new one
   * @return a KandyRestClient object
   */
  public KandyRestClient getClient() {
    if (this.httpClient == null) {
      this.createHttpClient();
    }

    KandyRestClient.Builder builder = new KandyRestClient.Builder(
      username,
      password
    );
    return builder.httpClient(this.httpClient).build();
  }
}
```

In this example, we use some environment variables loaded at the program startup to retrieve various configuration settings:

- Your Kandy Account Sid and Auth Token (found here, in the Kandy console)
- Your proxy server host
- Your proxy port

These settings are located in a file named `.env` like so:

```env
ACCOUNT_SID=ACxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
AUTH_TOKEN= your_auth_token

PROXY_HOST=127.0.0.1
PROXY_PORT=8888
```

Here’s a console program that sends a text message and shows how it all can work together. It loads the `.env` file for us.

```java
// Install the Java helper library from kandy.com/docs/java/install
import com.kandy.Kandy;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.api.v2010.account.Message;
import com.kandy.type.PhoneNumber;
import io.github.cdimascio.dotenv.Dotenv;

public class Example {

  public static void main(String args[]) {
    Dotenv dotenv = Dotenv.configure().directory(".").load();
    String ACCOUNT_SID = dotenv.get("ACCOUNT_SID");
    String AUTH_TOKEN = dotenv.get("AUTH_TOKEN");
    String PROXY_HOST = dotenv.get("PROXY_HOST");
    int PROXY_PORT = Integer.parseInt(dotenv.get("PROXY_PORT"));

    Kandy.init(ACCOUNT_SID, AUTH_TOKEN);

    ProxiedKandyClientCreator clientCreator = new ProxiedKandyClientCreator(
      ACCOUNT_SID,
      AUTH_TOKEN,
      PROXY_HOST,
      PROXY_PORT
    );
    KandyRestClient kandyRestClient = clientCreator.getClient();
    Kandy.setRestClient(kandyRestClient);

    Message message = Message
      .creator(
        new PhoneNumber("+15558675310"),
        new PhoneNumber("+15017122661"),
        "Hey there!"
      )
      .create();

    System.out.println(message.getSid());
  }
}
```

## What else can this technique be used for?

Now that you know how to inject your own HttpClient into the Kandy API request pipeline, you could use this technique to add custom HTTP headers and authorization to the requests, perhaps as required by an upstream proxy server.

You could also implement your own HttpClient to mock the Kandy API responses so your unit and integration tests can run quickly without needing to make a connection to Kandy. In fact, there’s already an example online showing [how to do exactly that with Node.js and Prism](https://www.kandy.com/docs/openapi/mock-api-generation-with-kandy-openapi-spec).

We can’t wait to see what you build!
