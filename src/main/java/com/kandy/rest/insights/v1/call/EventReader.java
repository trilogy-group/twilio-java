/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Insights
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.insights.v1.call;

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

public class EventReader extends Reader<Event> {
    private String pathCallSid;
    private Event.KandyEdge edge;
    private Integer pageSize;

    public EventReader(final String pathCallSid) {
        this.pathCallSid = pathCallSid;
    }

    public EventReader setEdge(final Event.KandyEdge edge) {
        this.edge = edge;
        return this;
    }

    public EventReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Event> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Event> firstPage(final KandyRestClient client) {
        String path = "/v1/Voice/{CallSid}/Events";
        path = path.replace("{" + "CallSid" + "}", this.pathCallSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.INSIGHTS.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Event> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Event read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "events",
                response.getContent(),
                Event.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Event> previousPage(final Page<Event> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.INSIGHTS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Event> nextPage(final Page<Event> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.INSIGHTS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Event> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (edge != null) {

            request.addQueryParam("Edge", edge.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
