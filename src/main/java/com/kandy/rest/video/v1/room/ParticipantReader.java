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

package com.kandy.rest.video.v1.room;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;
import com.kandy.base.Page;
import java.time.ZonedDateTime;

public class ParticipantReader extends Reader<Participant> {
    private String pathRoomSid;
    private Participant.Status status;
    private String identity;
    private ZonedDateTime dateCreatedAfter;
    private ZonedDateTime dateCreatedBefore;
    private Integer pageSize;

    public ParticipantReader(final String pathRoomSid) {
        this.pathRoomSid = pathRoomSid;
    }

    public ParticipantReader setStatus(final Participant.Status status) {
        this.status = status;
        return this;
    }

    public ParticipantReader setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    public ParticipantReader setDateCreatedAfter(final ZonedDateTime dateCreatedAfter) {
        this.dateCreatedAfter = dateCreatedAfter;
        return this;
    }

    public ParticipantReader setDateCreatedBefore(final ZonedDateTime dateCreatedBefore) {
        this.dateCreatedBefore = dateCreatedBefore;
        return this;
    }

    public ParticipantReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Participant> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Participant> firstPage(final TwilioRestClient client) {
        String path = "/v1/Rooms/{RoomSid}/Participants";
        path = path.replace("{" + "RoomSid" + "}", this.pathRoomSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.VIDEO.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Participant> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Participant read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "participants",
                response.getContent(),
                Participant.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Participant> previousPage(final Page<Participant> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.VIDEO.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Participant> nextPage(final Page<Participant> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.VIDEO.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Participant> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (status != null) {

            request.addQueryParam("Status", status.toString());
        }
        if (identity != null) {

            request.addQueryParam("Identity", identity);
        }
        if (dateCreatedAfter != null) {
            request.addQueryParam("DateCreatedAfter", dateCreatedAfter.toInstant().toString());
        }

        if (dateCreatedBefore != null) {
            request.addQueryParam("DateCreatedBefore", dateCreatedBefore.toInstant().toString());
        }

        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
