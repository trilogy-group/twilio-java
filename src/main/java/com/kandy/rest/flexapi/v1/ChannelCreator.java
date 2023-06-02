/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Flex
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.flexapi.v1;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class ChannelCreator extends Creator<Channel> {
    private String flexFlowSid;
    private String identity;
    private String chatUserFriendlyName;
    private String chatFriendlyName;
    private String target;
    private String chatUniqueName;
    private String preEngagementData;
    private String taskSid;
    private String taskAttributes;
    private Boolean longLived;

    public ChannelCreator(final String flexFlowSid, final String identity, final String chatUserFriendlyName,
            final String chatFriendlyName) {
        this.flexFlowSid = flexFlowSid;
        this.identity = identity;
        this.chatUserFriendlyName = chatUserFriendlyName;
        this.chatFriendlyName = chatFriendlyName;
    }

    public ChannelCreator setFlexFlowSid(final String flexFlowSid) {
        this.flexFlowSid = flexFlowSid;
        return this;
    }

    public ChannelCreator setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    public ChannelCreator setChatUserFriendlyName(final String chatUserFriendlyName) {
        this.chatUserFriendlyName = chatUserFriendlyName;
        return this;
    }

    public ChannelCreator setChatFriendlyName(final String chatFriendlyName) {
        this.chatFriendlyName = chatFriendlyName;
        return this;
    }

    public ChannelCreator setTarget(final String target) {
        this.target = target;
        return this;
    }

    public ChannelCreator setChatUniqueName(final String chatUniqueName) {
        this.chatUniqueName = chatUniqueName;
        return this;
    }

    public ChannelCreator setPreEngagementData(final String preEngagementData) {
        this.preEngagementData = preEngagementData;
        return this;
    }

    public ChannelCreator setTaskSid(final String taskSid) {
        this.taskSid = taskSid;
        return this;
    }

    public ChannelCreator setTaskAttributes(final String taskAttributes) {
        this.taskAttributes = taskAttributes;
        return this;
    }

    public ChannelCreator setLongLived(final Boolean longLived) {
        this.longLived = longLived;
        return this;
    }

    @Override
    public Channel create(final KandyRestClient client) {
        String path = "/v1/Channels";

        path = path.replace("{" + "FlexFlowSid" + "}", this.flexFlowSid.toString());
        path = path.replace("{" + "Identity" + "}", this.identity.toString());
        path = path.replace("{" + "ChatUserFriendlyName" + "}", this.chatUserFriendlyName.toString());
        path = path.replace("{" + "ChatFriendlyName" + "}", this.chatFriendlyName.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
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
        if (flexFlowSid != null) {
            request.addPostParam("FlexFlowSid", flexFlowSid);

        }
        if (identity != null) {
            request.addPostParam("Identity", identity);

        }
        if (chatUserFriendlyName != null) {
            request.addPostParam("ChatUserFriendlyName", chatUserFriendlyName);

        }
        if (chatFriendlyName != null) {
            request.addPostParam("ChatFriendlyName", chatFriendlyName);

        }
        if (target != null) {
            request.addPostParam("Target", target);

        }
        if (chatUniqueName != null) {
            request.addPostParam("ChatUniqueName", chatUniqueName);

        }
        if (preEngagementData != null) {
            request.addPostParam("PreEngagementData", preEngagementData);

        }
        if (taskSid != null) {
            request.addPostParam("TaskSid", taskSid);

        }
        if (taskAttributes != null) {
            request.addPostParam("TaskAttributes", taskAttributes);

        }
        if (longLived != null) {
            request.addPostParam("LongLived", longLived.toString());

        }
    }
}
