/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Studio
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.studio.v1.flow.engagement;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class StepFetcher extends Fetcher<Step> {
    private String pathFlowSid;
    private String pathEngagementSid;
    private String pathSid;

    public StepFetcher(final String pathFlowSid, final String pathEngagementSid, final String pathSid) {
        this.pathFlowSid = pathFlowSid;
        this.pathEngagementSid = pathEngagementSid;
        this.pathSid = pathSid;
    }

    @Override
    public Step fetch(final TwilioRestClient client) {
        String path = "/v1/Flows/{FlowSid}/Engagements/{EngagementSid}/Steps/{Sid}";

        path = path.replace("{" + "FlowSid" + "}", this.pathFlowSid.toString());
        path = path.replace("{" + "EngagementSid" + "}", this.pathEngagementSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.STUDIO.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Step fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Step.fromJson(response.getStream(), client.getObjectMapper());
    }
}
