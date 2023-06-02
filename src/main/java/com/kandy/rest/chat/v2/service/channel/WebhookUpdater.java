/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Chat
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.chat.v2.service.channel;

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

import java.util.List;

public class WebhookUpdater extends Updater<Webhook> {
    private String pathServiceSid;
    private String pathChannelSid;
    private String pathSid;
    private String configurationUrl;
    private Webhook.Method configurationMethod;
    private List<String> configurationFilters;
    private List<String> configurationTriggers;
    private String configurationFlowSid;
    private Integer configurationRetryCount;

    public WebhookUpdater(final String pathServiceSid, final String pathChannelSid, final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
        this.pathSid = pathSid;
    }

    public WebhookUpdater setConfigurationUrl(final String configurationUrl) {
        this.configurationUrl = configurationUrl;
        return this;
    }

    public WebhookUpdater setConfigurationMethod(final Webhook.Method configurationMethod) {
        this.configurationMethod = configurationMethod;
        return this;
    }

    public WebhookUpdater setConfigurationFilters(final List<String> configurationFilters) {
        this.configurationFilters = configurationFilters;
        return this;
    }

    public WebhookUpdater setConfigurationFilters(final String configurationFilters) {
        return setConfigurationFilters(Promoter.listOfOne(configurationFilters));
    }

    public WebhookUpdater setConfigurationTriggers(final List<String> configurationTriggers) {
        this.configurationTriggers = configurationTriggers;
        return this;
    }

    public WebhookUpdater setConfigurationTriggers(final String configurationTriggers) {
        return setConfigurationTriggers(Promoter.listOfOne(configurationTriggers));
    }

    public WebhookUpdater setConfigurationFlowSid(final String configurationFlowSid) {
        this.configurationFlowSid = configurationFlowSid;
        return this;
    }

    public WebhookUpdater setConfigurationRetryCount(final Integer configurationRetryCount) {
        this.configurationRetryCount = configurationRetryCount;
        return this;
    }

    @Override
    public Webhook update(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Channels/{ChannelSid}/Webhooks/{Sid}";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "ChannelSid" + "}", this.pathChannelSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CHAT.toString(),
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
        if (configurationUrl != null) {
            request.addPostParam("Configuration.Url", configurationUrl);

        }
        if (configurationMethod != null) {
            request.addPostParam("Configuration.Method", configurationMethod.toString());

        }
        if (configurationFilters != null) {
            for (String prop : configurationFilters) {
                request.addPostParam("Configuration.Filters", prop);
            }

        }
        if (configurationTriggers != null) {
            for (String prop : configurationTriggers) {
                request.addPostParam("Configuration.Triggers", prop);
            }

        }
        if (configurationFlowSid != null) {
            request.addPostParam("Configuration.FlowSid", configurationFlowSid);

        }
        if (configurationRetryCount != null) {
            request.addPostParam("Configuration.RetryCount", configurationRetryCount.toString());

        }
    }
}
