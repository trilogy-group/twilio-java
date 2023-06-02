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

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import com.kandy.base.Page;

import java.util.List;

public class InsightsSegmentsReader extends Reader<InsightsSegments> {
    private String authorization;
    private String segmentId;
    private List<String> reservationId;
    private Integer pageSize;

    public InsightsSegmentsReader() {
    }

    public InsightsSegmentsReader setAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }

    public InsightsSegmentsReader setSegmentId(final String segmentId) {
        this.segmentId = segmentId;
        return this;
    }

    public InsightsSegmentsReader setReservationId(final List<String> reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    public InsightsSegmentsReader setReservationId(final String reservationId) {
        return setReservationId(Promoter.listOfOne(reservationId));
    }

    public InsightsSegmentsReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<InsightsSegments> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<InsightsSegments> firstPage(final KandyRestClient client) {
        String path = "/v1/Insights/Segments";

        Request request = new Request(
                HttpMethod.GET,
                Domains.FLEXAPI.toString(),
                path);

        addQueryParams(request);
        addHeaderParams(request);
        return pageForRequest(client, request);
    }

    private Page<InsightsSegments> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("InsightsSegments read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "segments",
                response.getContent(),
                InsightsSegments.class,
                client.getObjectMapper());
    }

    @Override
    public Page<InsightsSegments> previousPage(final Page<InsightsSegments> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.FLEXAPI.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<InsightsSegments> nextPage(final Page<InsightsSegments> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.FLEXAPI.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<InsightsSegments> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addHeaderParams(final Request request) {
        if (authorization != null) {
            request.addHeaderParam("Authorization", authorization);

        }
    }

    private void addQueryParams(final Request request) {
        if (segmentId != null) {

            request.addQueryParam("SegmentId", segmentId);
        }
        if (reservationId != null) {
            for (String prop : reservationId) {
                request.addQueryParam("ReservationId", prop);
            }
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
