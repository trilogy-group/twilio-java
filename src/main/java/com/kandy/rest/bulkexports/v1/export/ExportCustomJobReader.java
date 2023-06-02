/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Bulkexports
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.bulkexports.v1.export;

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

public class ExportCustomJobReader extends Reader<ExportCustomJob> {
    private String pathResourceType;
    private Integer pageSize;

    public ExportCustomJobReader(final String pathResourceType) {
        this.pathResourceType = pathResourceType;
    }

    public ExportCustomJobReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<ExportCustomJob> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<ExportCustomJob> firstPage(final TwilioRestClient client) {
        String path = "/v1/Exports/{ResourceType}/Jobs";
        path = path.replace("{" + "ResourceType" + "}", this.pathResourceType.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.BULKEXPORTS.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<ExportCustomJob> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ExportCustomJob read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "jobs",
                response.getContent(),
                ExportCustomJob.class,
                client.getObjectMapper());
    }

    @Override
    public Page<ExportCustomJob> previousPage(final Page<ExportCustomJob> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.BULKEXPORTS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<ExportCustomJob> nextPage(final Page<ExportCustomJob> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.BULKEXPORTS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<ExportCustomJob> getPage(final String targetUrl, final TwilioRestClient client) {
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
