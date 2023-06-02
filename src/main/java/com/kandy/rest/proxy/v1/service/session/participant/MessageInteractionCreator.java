/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Proxy
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.proxy.v1.service.session.participant;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;
import java.util.List;
import java.net.URI;

import java.util.List;

import java.net.URI;

public class MessageInteractionCreator extends Creator<MessageInteraction> {
    private String pathServiceSid;
    private String pathSessionSid;
    private String pathParticipantSid;
    private String body;
    private List<URI> mediaUrl;

    public MessageInteractionCreator(final String pathServiceSid, final String pathSessionSid,
            final String pathParticipantSid, final String body) {
        this.pathServiceSid = pathServiceSid;
        this.pathSessionSid = pathSessionSid;
        this.pathParticipantSid = pathParticipantSid;
        this.body = body;
    }

    public MessageInteractionCreator(final String pathServiceSid, final String pathSessionSid,
            final String pathParticipantSid, final List<URI> mediaUrl) {
        this.pathServiceSid = pathServiceSid;
        this.pathSessionSid = pathSessionSid;
        this.pathParticipantSid = pathParticipantSid;
        this.mediaUrl = mediaUrl;
    }

    public MessageInteractionCreator setBody(final String body) {
        this.body = body;
        return this;
    }

    public MessageInteractionCreator setMediaUrl(final List<URI> mediaUrl) {
        this.mediaUrl = mediaUrl;
        return this;
    }

    public MessageInteractionCreator setMediaUrl(final URI mediaUrl) {
        return setMediaUrl(Promoter.listOfOne(mediaUrl));
    }

    public MessageInteractionCreator setMediaUrl(final String mediaUrl) {
        return setMediaUrl(Promoter.uriFromString(mediaUrl));
    }

    @Override
    public MessageInteraction create(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Sessions/{SessionSid}/Participants/{ParticipantSid}/MessageInteractions";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "SessionSid" + "}", this.pathSessionSid.toString());
        path = path.replace("{" + "ParticipantSid" + "}", this.pathParticipantSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PROXY.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("MessageInteraction creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return MessageInteraction.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (body != null) {
            request.addPostParam("Body", body);

        }
        if (mediaUrl != null) {
            for (URI prop : mediaUrl) {
                request.addPostParam("MediaUrl", prop.toString());
            }

        }
    }
}
