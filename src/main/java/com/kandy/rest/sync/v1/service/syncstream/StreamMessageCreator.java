/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Sync
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.sync.v1.service.syncstream;

import com.kandy.base.Creator;
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
import com.kandy.converter.Converter;

import java.util.Map;

public class StreamMessageCreator extends Creator<StreamMessage> {
    private String pathServiceSid;
    private String pathStreamSid;
    private Map<String, Object> data;

    public StreamMessageCreator(final String pathServiceSid, final String pathStreamSid,
            final Map<String, Object> data) {
        this.pathServiceSid = pathServiceSid;
        this.pathStreamSid = pathStreamSid;
        this.data = data;
    }

    public StreamMessageCreator setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    @Override
    public StreamMessage create(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Streams/{StreamSid}/Messages";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "StreamSid" + "}", this.pathStreamSid.toString());
        path = path.replace("{" + "Data" + "}", this.data.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.SYNC.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("StreamMessage creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return StreamMessage.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));

        }
    }
}
