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

package com.kandy.rest.flexapi.v1.interaction;

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

public class InteractionChannelUpdater extends Updater<InteractionChannel> {
    private String pathInteractionSid;
    private String pathSid;
    private InteractionChannel.Status status;
    private Map<String, Object> routing;

    public InteractionChannelUpdater(final String pathInteractionSid, final String pathSid,
            final InteractionChannel.Status status) {
        this.pathInteractionSid = pathInteractionSid;
        this.pathSid = pathSid;
        this.status = status;
    }

    public InteractionChannelUpdater setStatus(final InteractionChannel.Status status) {
        this.status = status;
        return this;
    }

    public InteractionChannelUpdater setRouting(final Map<String, Object> routing) {
        this.routing = routing;
        return this;
    }

    @Override
    public InteractionChannel update(final KandyRestClient client) {
        String path = "/v1/Interactions/{InteractionSid}/Channels/{Sid}";

        path = path.replace("{" + "InteractionSid" + "}", this.pathInteractionSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());
        path = path.replace("{" + "Status" + "}", this.status.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("InteractionChannel update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InteractionChannel.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
        if (routing != null) {
            request.addPostParam("Routing", Converter.mapToJson(routing));

        }
    }
}
