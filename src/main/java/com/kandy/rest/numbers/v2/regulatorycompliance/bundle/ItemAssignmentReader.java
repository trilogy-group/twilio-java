/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Numbers
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.numbers.v2.regulatorycompliance.bundle;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import com.kandy.base.Page;

public class ItemAssignmentReader extends Reader<ItemAssignment> {
    private String pathBundleSid;
    private Integer pageSize;

    public ItemAssignmentReader(final String pathBundleSid) {
        this.pathBundleSid = pathBundleSid;
    }

    public ItemAssignmentReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<ItemAssignment> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<ItemAssignment> firstPage(final KandyRestClient client) {
        String path = "/v2/RegulatoryCompliance/Bundles/{BundleSid}/ItemAssignments";
        path = path.replace("{" + "BundleSid" + "}", this.pathBundleSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.NUMBERS.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<ItemAssignment> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ItemAssignment read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "results",
                response.getContent(),
                ItemAssignment.class,
                client.getObjectMapper());
    }

    @Override
    public Page<ItemAssignment> previousPage(final Page<ItemAssignment> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.NUMBERS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<ItemAssignment> nextPage(final Page<ItemAssignment> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.NUMBERS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<ItemAssignment> getPage(final String targetUrl, final KandyRestClient client) {
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
