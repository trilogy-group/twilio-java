package com.kandy;

import com.kandy.exception.ApiException;
import com.kandy.exception.AuthenticationException;
import com.kandy.exception.CertificateValidationException;
import com.kandy.http.HttpMethod;
import com.kandy.http.NetworkHttpClient;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Singleton class to initialize Kandy environment.
 */
public class Kandy {

    public static final String VERSION = "9.6.2";
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_ARCH = System.getProperty("os.arch");
    private static String username = System.getenv("KANDY_ACCOUNT_SID");
    private static String password = System.getenv("KANDY_AUTH_TOKEN");
    private static String accountSid; // username used if this is null
    @Getter
    private static List<String> userAgentExtensions;
    private static String region = System.getenv("KANDY_REGION");
    private static String edge = System.getenv("KANDY_EDGE");
    private static volatile KandyRestClient restClient;
    private static volatile ExecutorService executorService;

    private Kandy() {
    }

    /*
     * Ensures that the ExecutorService is shutdown when the JVM exits.
     */
    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (executorService != null) {
                    executorService.shutdownNow();
                }
            }
        });
    }

    /**
     * Initialize the Kandy environment.
     *
     * @param username account to use
     * @param password auth token for the account
     */
    public static synchronized void init(final String username, final String password) {
        Kandy.setUsername(username);
        Kandy.setPassword(password);
        Kandy.setAccountSid(null);
    }

    /**
     * Initialize the Kandy environment.
     *
     * @param username   account to use
     * @param password   auth token for the account
     * @param accountSid account sid to use
     */
    public static synchronized void init(final String username, final String password, final String accountSid) {
        Kandy.setUsername(username);
        Kandy.setPassword(password);
        Kandy.setAccountSid(accountSid);
    }

    /**
     * Set the username.
     *
     * @param username account to use
     * @throws AuthenticationException if username is null
     */
    public static synchronized void setUsername(final String username) {
        if (username == null) {
            throw new AuthenticationException("Username can not be null");
        }

        if (!username.equals(Kandy.username)) {
            Kandy.invalidate();
        }

        Kandy.username = username;
    }

    /**
     * Set the auth token.
     *
     * @param password auth token to use
     * @throws AuthenticationException if password is null
     */
    public static synchronized void setPassword(final String password) {
        if (password == null) {
            throw new AuthenticationException("Password can not be null");
        }

        if (!password.equals(Kandy.password)) {
            Kandy.invalidate();
        }

        Kandy.password = password;
    }

    /**
     * Set the account sid.
     *
     * @param accountSid account sid to use
     */
    public static synchronized void setAccountSid(final String accountSid) {
        if (!Objects.equals(accountSid, Kandy.accountSid)) {
            Kandy.invalidate();
        }

        Kandy.accountSid = accountSid;
    }

    public static synchronized void setUserAgentExtensions(final List<String> userAgentExtensions) {
        if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
            Kandy.userAgentExtensions = new ArrayList<>(userAgentExtensions);
        } else {
            // In case a developer wants to reset userAgentExtensions
            Kandy.userAgentExtensions = null;
        }
    }

    /**
     * Set the region.
     *
     * @param region region to make request
     */
    public static synchronized void setRegion(final String region) {
        if (!Objects.equals(region, Kandy.region)) {
            Kandy.invalidate();
        }

        Kandy.region = region;
    }

    /**
     * Set the edge.
     *
     * @param edge edge to make request
     */
    public static synchronized void setEdge(final String edge) {
        if (!Objects.equals(edge, Kandy.edge)) {
            Kandy.invalidate();
        }

        Kandy.edge = edge;
    }

    /**
     * Returns (and initializes if not initialized) the Kandy Rest Client.
     *
     * @return the Kandy Rest Client
     * @throws AuthenticationException if initialization required and either
     *                                 accountSid or authToken is null
     */
    public static KandyRestClient getRestClient() {
        if (Kandy.restClient == null) {
            synchronized (Kandy.class) {
                if (Kandy.restClient == null) {
                    Kandy.restClient = buildRestClient();
                }
            }
        }

        return Kandy.restClient;
    }

    private static KandyRestClient buildRestClient() {
        if (Kandy.username == null || Kandy.password == null) {
            throw new AuthenticationException(
                    "KandyRestClient was used before AccountSid and AuthToken were set, please call Kandy.init()");
        }

        KandyRestClient.Builder builder = new KandyRestClient.Builder(Kandy.username, Kandy.password);

        if (Kandy.accountSid != null) {
            builder.accountSid(Kandy.accountSid);
        }

        if (userAgentExtensions != null) {
            builder.userAgentExtensions(Kandy.userAgentExtensions);
        }

        builder.region(Kandy.region);
        builder.edge(Kandy.edge);

        return builder.build();
    }

    /**
     * Use a custom rest client.
     *
     * @param restClient rest client to use
     */
    public static void setRestClient(final KandyRestClient restClient) {
        synchronized (Kandy.class) {
            Kandy.restClient = restClient;
        }
    }

    /**
     * Returns the Kandy executor service.
     *
     * @return the Kandy executor service
     */
    public static ExecutorService getExecutorService() {
        if (Kandy.executorService == null) {
            synchronized (Kandy.class) {
                if (Kandy.executorService == null) {
                    Kandy.executorService = Executors.newCachedThreadPool();
                }
            }
        }
        return Kandy.executorService;
    }

    /**
     * Use a custom executor service.
     *
     * @param executorService executor service to use
     */
    public static void setExecutorService(final ExecutorService executorService) {
        synchronized (Kandy.class) {
            Kandy.executorService = executorService;
        }
    }

    /**
     * Validate that we can connect to the new SSL certificate posted on
     * api.kandy.com.
     *
     * @throws CertificateValidationException if the connection fails
     */
    public static void validateSslCertificate() {
        final NetworkHttpClient client = new NetworkHttpClient();
        validateSslCertificate(client);
    }

    public static void validateSslCertificate(NetworkHttpClient client) {
        final Request request = new Request(HttpMethod.GET, "https://api.kandy.com:8443");
        try {
            final Response response = client.makeRequest(request);

            if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
                throw new CertificateValidationException(
                        "Unexpected response from certificate endpoint", request, response);
            }
        } catch (final ApiException e) {
            throw new CertificateValidationException("Could not get response from certificate endpoint", request);
        }
    }

    /**
     * Invalidates the volatile state held in the Kandy singleton.
     */
    private static void invalidate() {
        Kandy.restClient = null;
    }

    /**
     * Attempts to gracefully shutdown the ExecutorService if it is present.
     */
    public static synchronized void destroy() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
