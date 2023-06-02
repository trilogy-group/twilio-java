/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Pricing
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.pricing.v2.voice;

import com.kandy.base.Fetcher;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class NumberFetcher extends Fetcher<Number> {
    private com.kandy.type.PhoneNumber pathDestinationNumber;
    private com.kandy.type.PhoneNumber originationNumber;

    public NumberFetcher(final com.kandy.type.PhoneNumber pathDestinationNumber) {
        this.pathDestinationNumber = pathDestinationNumber;
    }

    public NumberFetcher setOriginationNumber(final com.kandy.type.PhoneNumber originationNumber) {
        this.originationNumber = originationNumber;
        return this;
    }

    public NumberFetcher setOriginationNumber(final String originationNumber) {
        return setOriginationNumber(Promoter.phoneNumberFromString(originationNumber));
    }

    @Override
    public Number fetch(final KandyRestClient client) {
        String path = "/v2/Voice/Numbers/{DestinationNumber}";

        path = path.replace("{" + "DestinationNumber" + "}", this.pathDestinationNumber.encode("utf-8"));

        Request request = new Request(
                HttpMethod.GET,
                Domains.PRICING.toString(),
                path);
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Number fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Number.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addQueryParams(final Request request) {
        if (originationNumber != null) {

            request.addQueryParam("OriginationNumber", originationNumber.toString());
        }
    }
}
