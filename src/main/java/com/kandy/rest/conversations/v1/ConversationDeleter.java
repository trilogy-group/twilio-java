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

import com.kandy.base.Deleter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class ConversationDeleter extends Deleter<Conversation> {
    private String pathSid;
    private Conversation.WebhookEnabledType xKandyWebhookEnabled;

    public ConversationDeleter(final String pathSid) {
        this.pathSid = pathSid;
    }

    public ConversationDeleter setXKandyWebhookEnabled(final Conversation.WebhookEnabledType xKandyWebhookEnabled) {
        this.xKandyWebhookEnabled = xKandyWebhookEnabled;
        return this;
    }

    @Override
    public boolean delete(final KandyRestClient client) {
        String path = "/v1/Conversations/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.DELETE,
                Domains.CONVERSATIONS.toString(),
                path);
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Conversation delete failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }

    private void addHeaderParams(final Request request) {
        if (xKandyWebhookEnabled != null) {
            request.addHeaderParam("X-Kandy-Webhook-Enabled", xKandyWebhookEnabled.toString());

        }
    }
}
