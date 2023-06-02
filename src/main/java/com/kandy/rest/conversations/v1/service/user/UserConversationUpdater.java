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

package com.kandy.rest.conversations.v1.service.user;

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

public class UserConversationUpdater extends Updater<UserConversation> {
    private String pathChatServiceSid;
    private String pathUserSid;
    private String pathConversationSid;
    private UserConversation.NotificationLevel notificationLevel;
    private ZonedDateTime lastReadTimestamp;
    private Integer lastReadMessageIndex;

    public UserConversationUpdater(final String pathChatServiceSid, final String pathUserSid,
            final String pathConversationSid) {
        this.pathChatServiceSid = pathChatServiceSid;
        this.pathUserSid = pathUserSid;
        this.pathConversationSid = pathConversationSid;
    }

    public UserConversationUpdater setNotificationLevel(final UserConversation.NotificationLevel notificationLevel) {
        this.notificationLevel = notificationLevel;
        return this;
    }

    public UserConversationUpdater setLastReadTimestamp(final ZonedDateTime lastReadTimestamp) {
        this.lastReadTimestamp = lastReadTimestamp;
        return this;
    }

    public UserConversationUpdater setLastReadMessageIndex(final Integer lastReadMessageIndex) {
        this.lastReadMessageIndex = lastReadMessageIndex;
        return this;
    }

    @Override
    public UserConversation update(final KandyRestClient client) {
        String path = "/v1/Services/{ChatServiceSid}/Users/{UserSid}/Conversations/{ConversationSid}";

        path = path.replace("{" + "ChatServiceSid" + "}", this.pathChatServiceSid.toString());
        path = path.replace("{" + "UserSid" + "}", this.pathUserSid.toString());
        path = path.replace("{" + "ConversationSid" + "}", this.pathConversationSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("UserConversation update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return UserConversation.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (notificationLevel != null) {
            request.addPostParam("NotificationLevel", notificationLevel.toString());

        }
        if (lastReadTimestamp != null) {
            request.addPostParam("LastReadTimestamp", lastReadTimestamp.toInstant().toString());

        }
        if (lastReadMessageIndex != null) {
            request.addPostParam("LastReadMessageIndex", lastReadMessageIndex.toString());

        }
    }
}
