/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Video
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.video.v1;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class RoomUpdater extends Updater<Room> {
    private String pathSid;
    private Room.RoomStatus status;

    public RoomUpdater(final String pathSid, final Room.RoomStatus status) {
        this.pathSid = pathSid;
        this.status = status;
    }

    public RoomUpdater setStatus(final Room.RoomStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public Room update(final TwilioRestClient client) {
        String path = "/v1/Rooms/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());
        path = path.replace("{" + "Status" + "}", this.status.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VIDEO.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Room update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Room.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
    }
}
