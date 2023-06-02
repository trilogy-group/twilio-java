/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Autopilot
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.autopilot.v1.assistant;

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

import java.net.URI;

public class WebhookUpdater extends Updater<Webhook> {
    private String pathAssistantSid;
    private String pathSid;
    private String uniqueName;
    private String events;
    private URI webhookUrl;
    private String webhookMethod;

    public WebhookUpdater(final String pathAssistantSid, final String pathSid) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathSid = pathSid;
    }

    public WebhookUpdater setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    public WebhookUpdater setEvents(final String events) {
        this.events = events;
        return this;
    }

    public WebhookUpdater setWebhookUrl(final URI webhookUrl) {
        this.webhookUrl = webhookUrl;
        return this;
    }

    public WebhookUpdater setWebhookUrl(final String webhookUrl) {
        return setWebhookUrl(Promoter.uriFromString(webhookUrl));
    }

    public WebhookUpdater setWebhookMethod(final String webhookMethod) {
        this.webhookMethod = webhookMethod;
        return this;
    }

    @Override
    public Webhook update(final TwilioRestClient client) {
        String path = "/v1/Assistants/{AssistantSid}/Webhooks/{Sid}";

        path = path.replace("{" + "AssistantSid" + "}", this.pathAssistantSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.AUTOPILOT.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Webhook update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);

        }
        if (events != null) {
            request.addPostParam("Events", events);

        }
        if (webhookUrl != null) {
            request.addPostParam("WebhookUrl", webhookUrl.toString());

        }
        if (webhookMethod != null) {
            request.addPostParam("WebhookMethod", webhookMethod);

        }
    }
}
