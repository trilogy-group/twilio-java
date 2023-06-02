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

package com.kandy.rest.numbers.v2.regulatorycompliance.bundle;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class ItemAssignmentFetcher extends Fetcher<ItemAssignment> {
    private String pathBundleSid;
    private String pathSid;

    public ItemAssignmentFetcher(final String pathBundleSid, final String pathSid) {
        this.pathBundleSid = pathBundleSid;
        this.pathSid = pathSid;
    }

    @Override
    public ItemAssignment fetch(final KandyRestClient client) {
        String path = "/v2/RegulatoryCompliance/Bundles/{BundleSid}/ItemAssignments/{Sid}";

        path = path.replace("{" + "BundleSid" + "}", this.pathBundleSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.NUMBERS.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ItemAssignment fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ItemAssignment.fromJson(response.getStream(), client.getObjectMapper());
    }
}
