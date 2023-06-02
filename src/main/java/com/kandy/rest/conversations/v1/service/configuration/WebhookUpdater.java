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

package com.kandy.rest.conversations.v1.service.configuration;

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

import java.util.List;

public class WebhookUpdater extends Updater<Webhook> {
    private String pathChatServiceSid;
    private URI preWebhookUrl;
    private URI postWebhookUrl;
    private List<String> filters;
    private String method;

    public WebhookUpdater(final String pathChatServiceSid) {
        this.pathChatServiceSid = pathChatServiceSid;
    }

    public WebhookUpdater setPreWebhookUrl(final URI preWebhookUrl) {
        this.preWebhookUrl = preWebhookUrl;
        return this;
    }

    public WebhookUpdater setPreWebhookUrl(final String preWebhookUrl) {
        return setPreWebhookUrl(Promoter.uriFromString(preWebhookUrl));
    }

    public WebhookUpdater setPostWebhookUrl(final URI postWebhookUrl) {
        this.postWebhookUrl = postWebhookUrl;
        return this;
    }

    public WebhookUpdater setPostWebhookUrl(final String postWebhookUrl) {
        return setPostWebhookUrl(Promoter.uriFromString(postWebhookUrl));
    }

    public WebhookUpdater setFilters(final List<String> filters) {
        this.filters = filters;
        return this;
    }

    public WebhookUpdater setFilters(final String filters) {
        return setFilters(Promoter.listOfOne(filters));
    }

    public WebhookUpdater setMethod(final String method) {
        this.method = method;
        return this;
    }

    @Override
    public Webhook update(final KandyRestClient client) {
        String path = "/v1/Services/{ChatServiceSid}/Configuration/Webhooks";

        path = path.replace("{" + "ChatServiceSid" + "}", this.pathChatServiceSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Webhook update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (preWebhookUrl != null) {
            request.addPostParam("PreWebhookUrl", preWebhookUrl.toString());

        }
        if (postWebhookUrl != null) {
            request.addPostParam("PostWebhookUrl", postWebhookUrl.toString());

        }
        if (filters != null) {
            for (String prop : filters) {
                request.addPostParam("Filters", prop);
            }

        }
        if (method != null) {
            request.addPostParam("Method", method);

        }
    }
}
