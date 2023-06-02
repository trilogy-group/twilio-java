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

public class AlphaSenderCreator extends Creator<AlphaSender> {
    private String pathServiceSid;
    private String alphaSender;

    public AlphaSenderCreator(final String pathServiceSid, final String alphaSender) {
        this.pathServiceSid = pathServiceSid;
        this.alphaSender = alphaSender;
    }

    public AlphaSenderCreator setAlphaSender(final String alphaSender) {
        this.alphaSender = alphaSender;
        return this;
    }

    @Override
    public AlphaSender create(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/AlphaSenders";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "AlphaSender" + "}", this.alphaSender.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.MESSAGING.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("AlphaSender creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AlphaSender.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (alphaSender != null) {
            request.addPostParam("AlphaSender", alphaSender);

        }
    }
}
