/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Insights
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.insights.v1;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class RoomFetcher extends Fetcher<Room> {
    private String pathRoomSid;

    public RoomFetcher(final String pathRoomSid) {
        this.pathRoomSid = pathRoomSid;
    }

    @Override
    public Room fetch(final TwilioRestClient client) {
        String path = "/v1/Video/Rooms/{RoomSid}";

        path = path.replace("{" + "RoomSid" + "}", this.pathRoomSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.INSIGHTS.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Room fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Room.fromJson(response.getStream(), client.getObjectMapper());
    }
}
