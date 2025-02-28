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

package com.kandy.rest.verify.v2.service.ratelimit;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class BucketCreator extends Creator<Bucket> {
    private String pathServiceSid;
    private String pathRateLimitSid;
    private Integer max;
    private Integer interval;

    public BucketCreator(final String pathServiceSid, final String pathRateLimitSid, final Integer max,
            final Integer interval) {
        this.pathServiceSid = pathServiceSid;
        this.pathRateLimitSid = pathRateLimitSid;
        this.max = max;
        this.interval = interval;
    }

    public BucketCreator setMax(final Integer max) {
        this.max = max;
        return this;
    }

    public BucketCreator setInterval(final Integer interval) {
        this.interval = interval;
        return this;
    }

    @Override
    public Bucket create(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/RateLimits/{RateLimitSid}/Buckets";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "RateLimitSid" + "}", this.pathRateLimitSid.toString());
        path = path.replace("{" + "Max" + "}", this.max.toString());
        path = path.replace("{" + "Interval" + "}", this.interval.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VERIFY.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Bucket creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Bucket.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (max != null) {
            request.addPostParam("Max", max.toString());

        }
        if (interval != null) {
            request.addPostParam("Interval", interval.toString());

        }
    }
}
