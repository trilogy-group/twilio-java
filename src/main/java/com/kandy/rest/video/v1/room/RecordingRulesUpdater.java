/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Video
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.video.v1.room;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

import java.util.Map;

public class RecordingRulesUpdater extends Updater<RecordingRules> {
    private String pathRoomSid;
    private Map<String, Object> rules;

    public RecordingRulesUpdater(final String pathRoomSid) {
        this.pathRoomSid = pathRoomSid;
    }

    public RecordingRulesUpdater setRules(final Map<String, Object> rules) {
        this.rules = rules;
        return this;
    }

    @Override
    public RecordingRules update(final KandyRestClient client) {
        String path = "/v1/Rooms/{RoomSid}/RecordingRules";

        path = path.replace("{" + "RoomSid" + "}", this.pathRoomSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VIDEO.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("RecordingRules update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return RecordingRules.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (rules != null) {
            request.addPostParam("Rules", Converter.mapToJson(rules));

        }
    }
}
