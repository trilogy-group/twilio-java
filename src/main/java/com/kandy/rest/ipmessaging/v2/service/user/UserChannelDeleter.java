/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Ip_messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.ipmessaging.v2.service.user;

import com.kandy.base.Deleter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class UserChannelDeleter extends Deleter<UserChannel> {
    private String pathServiceSid;
    private String pathUserSid;
    private String pathChannelSid;

    public UserChannelDeleter(final String pathServiceSid, final String pathUserSid, final String pathChannelSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathUserSid = pathUserSid;
        this.pathChannelSid = pathChannelSid;
    }

    @Override
    public boolean delete(final TwilioRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Users/{UserSid}/Channels/{ChannelSid}";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "UserSid" + "}", this.pathUserSid.toString());
        path = path.replace("{" + "ChannelSid" + "}", this.pathChannelSid.toString());

        Request request = new Request(
                HttpMethod.DELETE,
                Domains.IPMESSAGING.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("UserChannel delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
}
