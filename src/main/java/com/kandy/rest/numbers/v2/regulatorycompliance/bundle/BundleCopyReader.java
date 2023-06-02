/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Numbers
 * This is the public Twilio REST API.
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
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;
import com.kandy.base.Page;

public class BundleCopyReader extends Reader<BundleCopy> {
    private String pathBundleSid;
    private Integer pageSize;

    public BundleCopyReader(final String pathBundleSid) {
        this.pathBundleSid = pathBundleSid;
    }

    public BundleCopyReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<BundleCopy> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<BundleCopy> firstPage(final TwilioRestClient client) {
        String path = "/v2/RegulatoryCompliance/Bundles/{BundleSid}/Copies";
        path = path.replace("{" + "BundleSid" + "}", this.pathBundleSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.NUMBERS.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<BundleCopy> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("BundleCopy read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "results",
                response.getContent(),
                BundleCopy.class,
                client.getObjectMapper());
    }

    @Override
    public Page<BundleCopy> previousPage(final Page<BundleCopy> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.NUMBERS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<BundleCopy> nextPage(final Page<BundleCopy> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.NUMBERS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<BundleCopy> getPage(final String targetUrl, final TwilioRestClient client) {
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
