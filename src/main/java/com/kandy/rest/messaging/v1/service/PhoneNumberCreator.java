/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Messaging
 * This is the public Twilio REST API.
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
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class PhoneNumberCreator extends Creator<PhoneNumber> {
    private String pathServiceSid;
    private String phoneNumberSid;

    public PhoneNumberCreator(final String pathServiceSid, final String phoneNumberSid) {
        this.pathServiceSid = pathServiceSid;
        this.phoneNumberSid = phoneNumberSid;
    }

    public PhoneNumberCreator setPhoneNumberSid(final String phoneNumberSid) {
        this.phoneNumberSid = phoneNumberSid;
        return this;
    }

    @Override
    public PhoneNumber create(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/PhoneNumbers";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "PhoneNumberSid" + "}", this.phoneNumberSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.MESSAGING.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("PhoneNumber creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return PhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (phoneNumberSid != null) {
            request.addPostParam("PhoneNumberSid", phoneNumberSid);

        }
    }
}
