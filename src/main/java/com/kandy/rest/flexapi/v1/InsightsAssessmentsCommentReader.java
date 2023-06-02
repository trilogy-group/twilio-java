/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Flex
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.flexapi.v1;

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

public class InsightsAssessmentsCommentReader extends Reader<InsightsAssessmentsComment> {
    private String authorization;
    private String segmentId;
    private String agentId;
    private Integer pageSize;

    public InsightsAssessmentsCommentReader() {
    }

    public InsightsAssessmentsCommentReader setAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }

    public InsightsAssessmentsCommentReader setSegmentId(final String segmentId) {
        this.segmentId = segmentId;
        return this;
    }

    public InsightsAssessmentsCommentReader setAgentId(final String agentId) {
        this.agentId = agentId;
        return this;
    }

    public InsightsAssessmentsCommentReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<InsightsAssessmentsComment> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<InsightsAssessmentsComment> firstPage(final TwilioRestClient client) {
        String path = "/v1/Insights/QualityManagement/Assessments/Comments";

        Request request = new Request(
                HttpMethod.GET,
                Domains.FLEXAPI.toString(),
                path);

        addQueryParams(request);
        addHeaderParams(request);
        return pageForRequest(client, request);
    }

    private Page<InsightsAssessmentsComment> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("InsightsAssessmentsComment read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "comments",
                response.getContent(),
                InsightsAssessmentsComment.class,
                client.getObjectMapper());
    }

    @Override
    public Page<InsightsAssessmentsComment> previousPage(final Page<InsightsAssessmentsComment> page,
            final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.FLEXAPI.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<InsightsAssessmentsComment> nextPage(final Page<InsightsAssessmentsComment> page,
            final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.FLEXAPI.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<InsightsAssessmentsComment> getPage(final String targetUrl, final TwilioRestClient client) {
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
        if (agentId != null) {

            request.addQueryParam("AgentId", agentId);
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
