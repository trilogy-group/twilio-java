/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trusthub
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trusthub.v1.customerprofiles;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class CustomerProfilesEvaluationsFetcher extends Fetcher<CustomerProfilesEvaluations> {
    private String pathCustomerProfileSid;
    private String pathSid;

    public CustomerProfilesEvaluationsFetcher(final String pathCustomerProfileSid, final String pathSid) {
        this.pathCustomerProfileSid = pathCustomerProfileSid;
        this.pathSid = pathSid;
    }

    @Override
    public CustomerProfilesEvaluations fetch(final KandyRestClient client) {
        String path = "/v1/CustomerProfiles/{CustomerProfileSid}/Evaluations/{Sid}";

        path = path.replace("{" + "CustomerProfileSid" + "}", this.pathCustomerProfileSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.TRUSTHUB.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CustomerProfilesEvaluations fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return CustomerProfilesEvaluations.fromJson(response.getStream(), client.getObjectMapper());
    }
}
