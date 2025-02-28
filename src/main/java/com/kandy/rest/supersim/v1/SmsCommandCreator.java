/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Supersim
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.supersim.v1;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.net.URI;

import java.net.URI;

public class SmsCommandCreator extends Creator<SmsCommand> {
    private String sim;
    private String payload;
    private HttpMethod callbackMethod;
    private URI callbackUrl;

    public SmsCommandCreator(final String sim, final String payload) {
        this.sim = sim;
        this.payload = payload;
    }

    public SmsCommandCreator setSim(final String sim) {
        this.sim = sim;
        return this;
    }

    public SmsCommandCreator setPayload(final String payload) {
        this.payload = payload;
        return this;
    }

    public SmsCommandCreator setCallbackMethod(final HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    public SmsCommandCreator setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public SmsCommandCreator setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    @Override
    public SmsCommand create(final KandyRestClient client) {
        String path = "/v1/SmsCommands";

        path = path.replace("{" + "Sim" + "}", this.sim.toString());
        path = path.replace("{" + "Payload" + "}", this.payload.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.SUPERSIM.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("SmsCommand creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SmsCommand.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (sim != null) {
            request.addPostParam("Sim", sim);

        }
        if (payload != null) {
            request.addPostParam("Payload", payload);

        }
        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod.toString());

        }
        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());

        }
    }
}
