/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Messaging
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.messaging.v1;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class ExternalCampaignCreator extends Creator<ExternalCampaign> {
    private String campaignId;
    private String messagingServiceSid;

    public ExternalCampaignCreator(final String campaignId, final String messagingServiceSid) {
        this.campaignId = campaignId;
        this.messagingServiceSid = messagingServiceSid;
    }

    public ExternalCampaignCreator setCampaignId(final String campaignId) {
        this.campaignId = campaignId;
        return this;
    }

    public ExternalCampaignCreator setMessagingServiceSid(final String messagingServiceSid) {
        this.messagingServiceSid = messagingServiceSid;
        return this;
    }

    @Override
    public ExternalCampaign create(final KandyRestClient client) {
        String path = "/v1/Services/PreregisteredUsa2p";

        path = path.replace("{" + "CampaignId" + "}", this.campaignId.toString());
        path = path.replace("{" + "MessagingServiceSid" + "}", this.messagingServiceSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.MESSAGING.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("ExternalCampaign creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ExternalCampaign.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (campaignId != null) {
            request.addPostParam("CampaignId", campaignId);

        }
        if (messagingServiceSid != null) {
            request.addPostParam("MessagingServiceSid", messagingServiceSid);

        }
    }
}
