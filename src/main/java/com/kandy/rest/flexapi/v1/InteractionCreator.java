/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Flex
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.flexapi.v1;

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

public class InteractionCreator extends Creator<Interaction> {
    private Map<String, Object> channel;
    private Map<String, Object> routing;

    public InteractionCreator(final Map<String, Object> channel, final Map<String, Object> routing) {
        this.channel = channel;
        this.routing = routing;
    }

    public InteractionCreator setChannel(final Map<String, Object> channel) {
        this.channel = channel;
        return this;
    }

    public InteractionCreator setRouting(final Map<String, Object> routing) {
        this.routing = routing;
        return this;
    }

    @Override
    public Interaction create(final KandyRestClient client) {
        String path = "/v1/Interactions";

        path = path.replace("{" + "Channel" + "}", this.channel.toString());
        path = path.replace("{" + "Routing" + "}", this.routing.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Interaction creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Interaction.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (channel != null) {
            request.addPostParam("Channel", Converter.mapToJson(channel));

        }
        if (routing != null) {
            request.addPostParam("Routing", Converter.mapToJson(routing));

        }
    }
}
