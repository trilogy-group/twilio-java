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

package com.kandy.rest.conversations.v1.service.conversation;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

import java.time.ZonedDateTime;

public class ParticipantUpdater extends Updater<Participant> {
    private String pathChatServiceSid;
    private String pathConversationSid;
    private String pathSid;
    private Participant.WebhookEnabledType xKandyWebhookEnabled;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateUpdated;
    private String identity;
    private String attributes;
    private String roleSid;
    private String messagingBindingProxyAddress;
    private String messagingBindingProjectedAddress;
    private Integer lastReadMessageIndex;
    private String lastReadTimestamp;

    public ParticipantUpdater(final String pathChatServiceSid, final String pathConversationSid, final String pathSid) {
        this.pathChatServiceSid = pathChatServiceSid;
        this.pathConversationSid = pathConversationSid;
        this.pathSid = pathSid;
    }

    public ParticipantUpdater setXKandyWebhookEnabled(final Participant.WebhookEnabledType xKandyWebhookEnabled) {
        this.xKandyWebhookEnabled = xKandyWebhookEnabled;
        return this;
    }

    public ParticipantUpdater setDateCreated(final ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public ParticipantUpdater setDateUpdated(final ZonedDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    public ParticipantUpdater setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    public ParticipantUpdater setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    public ParticipantUpdater setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    public ParticipantUpdater setMessagingBindingProxyAddress(final String messagingBindingProxyAddress) {
        this.messagingBindingProxyAddress = messagingBindingProxyAddress;
        return this;
    }

    public ParticipantUpdater setMessagingBindingProjectedAddress(final String messagingBindingProjectedAddress) {
        this.messagingBindingProjectedAddress = messagingBindingProjectedAddress;
        return this;
    }

    public ParticipantUpdater setLastReadMessageIndex(final Integer lastReadMessageIndex) {
        this.lastReadMessageIndex = lastReadMessageIndex;
        return this;
    }

    public ParticipantUpdater setLastReadTimestamp(final String lastReadTimestamp) {
        this.lastReadTimestamp = lastReadTimestamp;
        return this;
    }

    @Override
    public Participant update(final KandyRestClient client) {
        String path = "/v1/Services/{ChatServiceSid}/Conversations/{ConversationSid}/Participants/{Sid}";

        path = path.replace("{" + "ChatServiceSid" + "}", this.pathChatServiceSid.toString());
        path = path.replace("{" + "ConversationSid" + "}", this.pathConversationSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Participant update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Participant.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toInstant().toString());

        }
        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toInstant().toString());

        }
        if (identity != null) {
            request.addPostParam("Identity", identity);

        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);

        }
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);

        }
        if (messagingBindingProxyAddress != null) {
            request.addPostParam("MessagingBinding.ProxyAddress", messagingBindingProxyAddress);

        }
        if (messagingBindingProjectedAddress != null) {
            request.addPostParam("MessagingBinding.ProjectedAddress", messagingBindingProjectedAddress);

        }
        if (lastReadMessageIndex != null) {
            request.addPostParam("LastReadMessageIndex", lastReadMessageIndex.toString());

        }
        if (lastReadTimestamp != null) {
            request.addPostParam("LastReadTimestamp", lastReadTimestamp);

        }
    }

    private void addHeaderParams(final Request request) {
        if (xKandyWebhookEnabled != null) {
            request.addHeaderParam("X-Kandy-Webhook-Enabled", xKandyWebhookEnabled.toString());

        }
    }
}
