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

public class AddressConfigurationUpdater extends Updater<AddressConfiguration> {
    private String pathSid;
    private String friendlyName;
    private Boolean autoCreationEnabled;
    private AddressConfiguration.AutoCreationType autoCreationType;
    private String autoCreationConversationServiceSid;
    private String autoCreationWebhookUrl;
    private AddressConfiguration.Method autoCreationWebhookMethod;
    private List<String> autoCreationWebhookFilters;
    private String autoCreationStudioFlowSid;
    private Integer autoCreationStudioRetryCount;

    public AddressConfigurationUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public AddressConfigurationUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationEnabled(final Boolean autoCreationEnabled) {
        this.autoCreationEnabled = autoCreationEnabled;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationType(
            final AddressConfiguration.AutoCreationType autoCreationType) {
        this.autoCreationType = autoCreationType;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationConversationServiceSid(
            final String autoCreationConversationServiceSid) {
        this.autoCreationConversationServiceSid = autoCreationConversationServiceSid;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationWebhookUrl(final String autoCreationWebhookUrl) {
        this.autoCreationWebhookUrl = autoCreationWebhookUrl;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationWebhookMethod(
            final AddressConfiguration.Method autoCreationWebhookMethod) {
        this.autoCreationWebhookMethod = autoCreationWebhookMethod;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationWebhookFilters(final List<String> autoCreationWebhookFilters) {
        this.autoCreationWebhookFilters = autoCreationWebhookFilters;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationWebhookFilters(final String autoCreationWebhookFilters) {
        return setAutoCreationWebhookFilters(Promoter.listOfOne(autoCreationWebhookFilters));
    }

    public AddressConfigurationUpdater setAutoCreationStudioFlowSid(final String autoCreationStudioFlowSid) {
        this.autoCreationStudioFlowSid = autoCreationStudioFlowSid;
        return this;
    }

    public AddressConfigurationUpdater setAutoCreationStudioRetryCount(final Integer autoCreationStudioRetryCount) {
        this.autoCreationStudioRetryCount = autoCreationStudioRetryCount;
        return this;
    }

    @Override
    public AddressConfiguration update(final KandyRestClient client) {
        String path = "/v1/Configuration/Addresses/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("AddressConfiguration update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AddressConfiguration.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (autoCreationEnabled != null) {
            request.addPostParam("AutoCreation.Enabled", autoCreationEnabled.toString());

        }
        if (autoCreationType != null) {
            request.addPostParam("AutoCreation.Type", autoCreationType.toString());

        }
        if (autoCreationConversationServiceSid != null) {
            request.addPostParam("AutoCreation.ConversationServiceSid", autoCreationConversationServiceSid);

        }
        if (autoCreationWebhookUrl != null) {
            request.addPostParam("AutoCreation.WebhookUrl", autoCreationWebhookUrl);

        }
        if (autoCreationWebhookMethod != null) {
            request.addPostParam("AutoCreation.WebhookMethod", autoCreationWebhookMethod.toString());

        }
        if (autoCreationWebhookFilters != null) {
            for (String prop : autoCreationWebhookFilters) {
                request.addPostParam("AutoCreation.WebhookFilters", prop);
            }

        }
        if (autoCreationStudioFlowSid != null) {
            request.addPostParam("AutoCreation.StudioFlowSid", autoCreationStudioFlowSid);

        }
        if (autoCreationStudioRetryCount != null) {
            request.addPostParam("AutoCreation.StudioRetryCount", autoCreationStudioRetryCount.toString());

        }
    }
}
