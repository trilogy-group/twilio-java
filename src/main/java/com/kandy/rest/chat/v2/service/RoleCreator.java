/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Chat
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.chat.v2.service;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;
import java.util.List;

import java.util.List;

public class RoleCreator extends Creator<Role> {
    private String pathServiceSid;
    private String friendlyName;
    private Role.RoleType type;
    private List<String> permission;

    public RoleCreator(final String pathServiceSid, final String friendlyName, final Role.RoleType type,
            final List<String> permission) {
        this.pathServiceSid = pathServiceSid;
        this.friendlyName = friendlyName;
        this.type = type;
        this.permission = permission;
    }

    public RoleCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public RoleCreator setType(final Role.RoleType type) {
        this.type = type;
        return this;
    }

    public RoleCreator setPermission(final List<String> permission) {
        this.permission = permission;
        return this;
    }

    public RoleCreator setPermission(final String permission) {
        return setPermission(Promoter.listOfOne(permission));
    }

    @Override
    public Role create(final TwilioRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Roles";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "FriendlyName" + "}", this.friendlyName.toString());
        path = path.replace("{" + "Type" + "}", this.type.toString());
        path = path.replace("{" + "Permission" + "}", this.permission.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.CHAT.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Role creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Role.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (type != null) {
            request.addPostParam("Type", type.toString());

        }
        if (permission != null) {
            for (String prop : permission) {
                request.addPostParam("Permission", prop);
            }

        }
    }
}
