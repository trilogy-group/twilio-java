/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Numbers
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.numbers.v1;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class BulkEligibilityFetcher extends Fetcher<BulkEligibility> {
    private String pathRequestId;

    public BulkEligibilityFetcher(final String pathRequestId) {
        this.pathRequestId = pathRequestId;
    }

    @Override
    public BulkEligibility fetch(final KandyRestClient client) {
        String path = "/v1/HostedNumber/Eligibility/Bulk/{RequestId}";

        path = path.replace("{" + "RequestId" + "}", this.pathRequestId.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.NUMBERS.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("BulkEligibility fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return BulkEligibility.fromJson(response.getStream(), client.getObjectMapper());
    }
}
