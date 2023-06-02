/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Conversations
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.conversations.v1;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class CredentialUpdater extends Updater<Credential> {
    private String pathSid;
    private Credential.PushType type;
    private String friendlyName;
    private String certificate;
    private String privateKey;
    private Boolean sandbox;
    private String apiKey;
    private String secret;

    public CredentialUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public CredentialUpdater setType(final Credential.PushType type) {
        this.type = type;
        return this;
    }

    public CredentialUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public CredentialUpdater setCertificate(final String certificate) {
        this.certificate = certificate;
        return this;
    }

    public CredentialUpdater setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public CredentialUpdater setSandbox(final Boolean sandbox) {
        this.sandbox = sandbox;
        return this;
    }

    public CredentialUpdater setApiKey(final String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public CredentialUpdater setSecret(final String secret) {
        this.secret = secret;
        return this;
    }

    @Override
    public Credential update(final KandyRestClient client) {
        String path = "/v1/Credentials/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Credential update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Credential.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (type != null) {
            request.addPostParam("Type", type.toString());

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (certificate != null) {
            request.addPostParam("Certificate", certificate);

        }
        if (privateKey != null) {
            request.addPostParam("PrivateKey", privateKey);

        }
        if (sandbox != null) {
            request.addPostParam("Sandbox", sandbox.toString());

        }
        if (apiKey != null) {
            request.addPostParam("ApiKey", apiKey);

        }
        if (secret != null) {
            request.addPostParam("Secret", secret);

        }
    }
}
