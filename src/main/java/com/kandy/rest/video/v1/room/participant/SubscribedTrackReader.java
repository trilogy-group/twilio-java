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

package com.kandy.rest.video.v1.room.participant;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import com.kandy.base.Page;

public class SubscribedTrackReader extends Reader<SubscribedTrack> {
    private String pathRoomSid;
    private String pathParticipantSid;
    private Integer pageSize;

    public SubscribedTrackReader(final String pathRoomSid, final String pathParticipantSid) {
        this.pathRoomSid = pathRoomSid;
        this.pathParticipantSid = pathParticipantSid;
    }

    public SubscribedTrackReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<SubscribedTrack> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<SubscribedTrack> firstPage(final KandyRestClient client) {
        String path = "/v1/Rooms/{RoomSid}/Participants/{ParticipantSid}/SubscribedTracks";
        path = path.replace("{" + "RoomSid" + "}", this.pathRoomSid.toString());
        path = path.replace("{" + "ParticipantSid" + "}", this.pathParticipantSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.VIDEO.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<SubscribedTrack> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SubscribedTrack read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "subscribed_tracks",
                response.getContent(),
                SubscribedTrack.class,
                client.getObjectMapper());
    }

    @Override
    public Page<SubscribedTrack> previousPage(final Page<SubscribedTrack> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.VIDEO.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<SubscribedTrack> nextPage(final Page<SubscribedTrack> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.VIDEO.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<SubscribedTrack> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
