/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Api
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account;

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
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class RecordingReader extends Reader<Recording> {
    private String pathAccountSid;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateCreatedBefore;
    private ZonedDateTime dateCreatedAfter;
    private String callSid;
    private String conferenceSid;
    private Boolean includeSoftDeleted;
    private Integer pageSize;

    public RecordingReader() {
    }

    public RecordingReader(final String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    public RecordingReader setDateCreated(final ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public RecordingReader setDateCreatedBefore(final ZonedDateTime dateCreatedBefore) {
        this.dateCreatedBefore = dateCreatedBefore;
        return this;
    }

    public RecordingReader setDateCreatedAfter(final ZonedDateTime dateCreatedAfter) {
        this.dateCreatedAfter = dateCreatedAfter;
        return this;
    }

    public RecordingReader setCallSid(final String callSid) {
        this.callSid = callSid;
        return this;
    }

    public RecordingReader setConferenceSid(final String conferenceSid) {
        this.conferenceSid = conferenceSid;
        return this;
    }

    public RecordingReader setIncludeSoftDeleted(final Boolean includeSoftDeleted) {
        this.includeSoftDeleted = includeSoftDeleted;
        return this;
    }

    public RecordingReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Recording> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Recording> firstPage(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Recordings.json";
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.API.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Recording> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Recording read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "recordings",
                response.getContent(),
                Recording.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Recording> previousPage(final Page<Recording> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Recording> nextPage(final Page<Recording> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Recording> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (dateCreated != null) {
            request.addQueryParam("DateCreated",
                    dateCreated.format(DateTimeFormatter.ofPattern(Request.QUERY_STRING_DATE_TIME_FORMAT)));
        } else if (dateCreatedAfter != null || dateCreatedBefore != null) {
            request.addQueryDateTimeRange("DateCreated", dateCreatedAfter, dateCreatedBefore);
        }
        if (callSid != null) {

            request.addQueryParam("CallSid", callSid);
        }
        if (conferenceSid != null) {

            request.addQueryParam("ConferenceSid", conferenceSid);
        }
        if (includeSoftDeleted != null) {

            request.addQueryParam("IncludeSoftDeleted", includeSoftDeleted.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
