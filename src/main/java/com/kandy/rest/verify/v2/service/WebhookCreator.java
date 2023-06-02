/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Verify
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.verify.v2.service;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.util.List;

import java.util.List;

public class WebhookCreator extends Creator<Webhook> {
    private String pathServiceSid;
    private String friendlyName;
    private List<String> eventTypes;
    private String webhookUrl;
    private Webhook.Status status;
    private Webhook.Version version;

    public WebhookCreator(final String pathServiceSid, final String friendlyName, final List<String> eventTypes,
            final String webhookUrl) {
        this.pathServiceSid = pathServiceSid;
        this.friendlyName = friendlyName;
        this.eventTypes = eventTypes;
        this.webhookUrl = webhookUrl;
    }

    public WebhookCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public WebhookCreator setEventTypes(final List<String> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }

    public WebhookCreator setEventTypes(final String eventTypes) {
        return setEventTypes(Promoter.listOfOne(eventTypes));
    }

    public WebhookCreator setWebhookUrl(final String webhookUrl) {
        this.webhookUrl = webhookUrl;
        return this;
    }

    public WebhookCreator setStatus(final Webhook.Status status) {
        this.status = status;
        return this;
    }

    public WebhookCreator setVersion(final Webhook.Version version) {
        this.version = version;
        return this;
    }

    @Override
    public Webhook create(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Webhooks";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "FriendlyName" + "}", this.friendlyName.toString());
        path = path.replace("{" + "EventTypes" + "}", this.eventTypes.toString());
        path = path.replace("{" + "WebhookUrl" + "}", this.webhookUrl.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VERIFY.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Webhook creation failed: Unable to connect to server");
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
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (eventTypes != null) {
            for (String prop : eventTypes) {
                request.addPostParam("EventTypes", prop);
            }

        }
        if (webhookUrl != null) {
            request.addPostParam("WebhookUrl", webhookUrl);

        }
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
        if (version != null) {
            request.addPostParam("Version", version.toString());

        }
    }
}
