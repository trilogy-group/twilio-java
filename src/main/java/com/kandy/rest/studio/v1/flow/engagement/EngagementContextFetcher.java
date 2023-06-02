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

public class EngagementContextFetcher extends Fetcher<EngagementContext> {
    private String pathFlowSid;
    private String pathEngagementSid;

    public EngagementContextFetcher(final String pathFlowSid, final String pathEngagementSid) {
        this.pathFlowSid = pathFlowSid;
        this.pathEngagementSid = pathEngagementSid;
    }

    @Override
    public EngagementContext fetch(final TwilioRestClient client) {
        String path = "/v1/Flows/{FlowSid}/Engagements/{EngagementSid}/Context";

        path = path.replace("{" + "FlowSid" + "}", this.pathFlowSid.toString());
        path = path.replace("{" + "EngagementSid" + "}", this.pathEngagementSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.STUDIO.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("EngagementContext fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return EngagementContext.fromJson(response.getStream(), client.getObjectMapper());
    }
}
