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

package com.kandy.rest.messaging.v1.service;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class ShortCodeCreator extends Creator<ShortCode> {
    private String pathServiceSid;
    private String shortCodeSid;

    public ShortCodeCreator(final String pathServiceSid, final String shortCodeSid) {
        this.pathServiceSid = pathServiceSid;
        this.shortCodeSid = shortCodeSid;
    }

    public ShortCodeCreator setShortCodeSid(final String shortCodeSid) {
        this.shortCodeSid = shortCodeSid;
        return this;
    }

    @Override
    public ShortCode create(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/ShortCodes";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "ShortCodeSid" + "}", this.shortCodeSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.MESSAGING.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("ShortCode creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ShortCode.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (shortCodeSid != null) {
            request.addPostParam("ShortCodeSid", shortCodeSid);

        }
    }
}
