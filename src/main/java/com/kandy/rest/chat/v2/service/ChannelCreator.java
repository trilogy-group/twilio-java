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

package com.kandy.rest.chat.v2.service;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.time.ZonedDateTime;

public class ChannelCreator extends Creator<Channel> {
    private String pathServiceSid;
    private Channel.WebhookEnabledType xKandyWebhookEnabled;
    private String friendlyName;
    private String uniqueName;
    private String attributes;
    private Channel.ChannelType type;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateUpdated;
    private String createdBy;

    public ChannelCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    public ChannelCreator setXKandyWebhookEnabled(final Channel.WebhookEnabledType xKandyWebhookEnabled) {
        this.xKandyWebhookEnabled = xKandyWebhookEnabled;
        return this;
    }

    public ChannelCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ChannelCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    public ChannelCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    public ChannelCreator setType(final Channel.ChannelType type) {
        this.type = type;
        return this;
    }

    public ChannelCreator setDateCreated(final ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public ChannelCreator setDateUpdated(final ZonedDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    public ChannelCreator setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @Override
    public Channel create(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Channels";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CHAT.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Channel creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Channel.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);

        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);

        }
        if (type != null) {
            request.addPostParam("Type", type.toString());

        }
        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toInstant().toString());

        }
        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toInstant().toString());

        }
        if (createdBy != null) {
            request.addPostParam("CreatedBy", createdBy);

        }
    }

    private void addHeaderParams(final Request request) {
        if (xKandyWebhookEnabled != null) {
            request.addHeaderParam("X-Kandy-Webhook-Enabled", xKandyWebhookEnabled.toString());

        }
    }
}
