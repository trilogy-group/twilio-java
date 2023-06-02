/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Verify
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.verify.v2.service.entity;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class ChallengeFetcher extends Fetcher<Challenge> {
    private String pathServiceSid;
    private String pathIdentity;
    private String pathSid;

    public ChallengeFetcher(final String pathServiceSid, final String pathIdentity, final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.pathSid = pathSid;
    }

    @Override
    public Challenge fetch(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Entities/{Identity}/Challenges/{Sid}";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "Identity" + "}", this.pathIdentity.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.VERIFY.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Challenge fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Challenge.fromJson(response.getStream(), client.getObjectMapper());
    }
}
