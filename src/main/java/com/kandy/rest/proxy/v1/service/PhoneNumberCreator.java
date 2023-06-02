/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Proxy
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.proxy.v1.service;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class PhoneNumberCreator extends Creator<PhoneNumber> {
    private String pathServiceSid;
    private String sid;
    private com.kandy.type.PhoneNumber phoneNumber;
    private Boolean isReserved;

    public PhoneNumberCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    public PhoneNumberCreator setSid(final String sid) {
        this.sid = sid;
        return this;
    }

    public PhoneNumberCreator setPhoneNumber(final com.kandy.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PhoneNumberCreator setPhoneNumber(final String phoneNumber) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    public PhoneNumberCreator setIsReserved(final Boolean isReserved) {
        this.isReserved = isReserved;
        return this;
    }

    @Override
    public PhoneNumber create(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/PhoneNumbers";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PROXY.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("PhoneNumber creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return PhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (sid != null) {
            request.addPostParam("Sid", sid);

        }
        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());

        }
        if (isReserved != null) {
            request.addPostParam("IsReserved", isReserved.toString());

        }
    }
}
