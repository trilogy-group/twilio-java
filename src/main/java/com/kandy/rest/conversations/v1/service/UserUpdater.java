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

package com.kandy.rest.conversations.v1.service;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class UserUpdater extends Updater<User> {
    private String pathChatServiceSid;
    private String pathSid;
    private User.WebhookEnabledType xKandyWebhookEnabled;
    private String friendlyName;
    private String attributes;
    private String roleSid;

    public UserUpdater(final String pathChatServiceSid, final String pathSid) {
        this.pathChatServiceSid = pathChatServiceSid;
        this.pathSid = pathSid;
    }

    public UserUpdater setXKandyWebhookEnabled(final User.WebhookEnabledType xKandyWebhookEnabled) {
        this.xKandyWebhookEnabled = xKandyWebhookEnabled;
        return this;
    }

    public UserUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public UserUpdater setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    public UserUpdater setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    @Override
    public User update(final KandyRestClient client) {
        String path = "/v1/Services/{ChatServiceSid}/Users/{Sid}";

        path = path.replace("{" + "ChatServiceSid" + "}", this.pathChatServiceSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CONVERSATIONS.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("User update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return User.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);

        }
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);

        }
    }

    private void addHeaderParams(final Request request) {
        if (xKandyWebhookEnabled != null) {
            request.addHeaderParam("X-Kandy-Webhook-Enabled", xKandyWebhookEnabled.toString());

        }
    }
}
