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
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class SimCreator extends Creator<Sim> {
    private String iccid;
    private String registrationCode;

    public SimCreator(final String iccid, final String registrationCode) {
        this.iccid = iccid;
        this.registrationCode = registrationCode;
    }

    public SimCreator setIccid(final String iccid) {
        this.iccid = iccid;
        return this;
    }

    public SimCreator setRegistrationCode(final String registrationCode) {
        this.registrationCode = registrationCode;
        return this;
    }

    @Override
    public Sim create(final KandyRestClient client) {
        String path = "/v1/Sims";

        path = path.replace("{" + "Iccid" + "}", this.iccid.toString());
        path = path.replace("{" + "RegistrationCode" + "}", this.registrationCode.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.SUPERSIM.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Sim creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Sim.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (iccid != null) {
            request.addPostParam("Iccid", iccid);

        }
        if (registrationCode != null) {
            request.addPostParam("RegistrationCode", registrationCode);

        }
    }
}
