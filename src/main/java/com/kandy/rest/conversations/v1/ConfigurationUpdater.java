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
import com.kandy.rest.Domains;

public class ConfigurationUpdater extends Updater<Configuration> {
    private String defaultChatServiceSid;
    private String defaultMessagingServiceSid;
    private String defaultInactiveTimer;
    private String defaultClosedTimer;

    public ConfigurationUpdater() {
    }

    public ConfigurationUpdater setDefaultChatServiceSid(final String defaultChatServiceSid) {
        this.defaultChatServiceSid = defaultChatServiceSid;
        return this;
    }

    public ConfigurationUpdater setDefaultMessagingServiceSid(final String defaultMessagingServiceSid) {
        this.defaultMessagingServiceSid = defaultMessagingServiceSid;
        return this;
    }

    public ConfigurationUpdater setDefaultInactiveTimer(final String defaultInactiveTimer) {
        this.defaultInactiveTimer = defaultInactiveTimer;
        return this;
    }

    public ConfigurationUpdater setDefaultClosedTimer(final String defaultClosedTimer) {
        this.defaultClosedTimer = defaultClosedTimer;
        return this;
    }

    @Override
    public Configuration update(final KandyRestClient client) {
        String path = "/v1/Configuration";

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Configuration update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Configuration.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (defaultChatServiceSid != null) {
            request.addPostParam("DefaultChatServiceSid", defaultChatServiceSid);

        }
        if (defaultMessagingServiceSid != null) {
            request.addPostParam("DefaultMessagingServiceSid", defaultMessagingServiceSid);

        }
        if (defaultInactiveTimer != null) {
            request.addPostParam("DefaultInactiveTimer", defaultInactiveTimer);

        }
        if (defaultClosedTimer != null) {
            request.addPostParam("DefaultClosedTimer", defaultClosedTimer);

        }
    }
}
