/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Bulkexports
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.bulkexports.v1.export;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class DayFetcher extends Fetcher<Day> {
    private String pathResourceType;
    private String pathDay;

    public DayFetcher(final String pathResourceType, final String pathDay) {
        this.pathResourceType = pathResourceType;
        this.pathDay = pathDay;
    }

    @Override
    public Day fetch(final KandyRestClient client) {
        String path = "/v1/Exports/{ResourceType}/Days/{Day}";

        path = path.replace("{" + "ResourceType" + "}", this.pathResourceType.toString());
        path = path.replace("{" + "Day" + "}", this.pathDay.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.BULKEXPORTS.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Day fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Day.fromJson(response.getStream(), client.getObjectMapper());
    }
}
