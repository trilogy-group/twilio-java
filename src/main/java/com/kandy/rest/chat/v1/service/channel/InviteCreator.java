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

package com.kandy.rest.chat.v1.service.channel;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class InviteCreator extends Creator<Invite> {
    private String pathServiceSid;
    private String pathChannelSid;
    private String identity;
    private String roleSid;

    public InviteCreator(final String pathServiceSid, final String pathChannelSid, final String identity) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
        this.identity = identity;
    }

    public InviteCreator setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    public InviteCreator setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    @Override
    public Invite create(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Channels/{ChannelSid}/Invites";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "ChannelSid" + "}", this.pathChannelSid.toString());
        path = path.replace("{" + "Identity" + "}", this.identity.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CHAT.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Invite creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Invite.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);

        }
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);

        }
    }
}
