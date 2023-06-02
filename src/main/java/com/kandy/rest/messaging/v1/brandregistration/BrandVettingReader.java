/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Messaging
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.messaging.v1.brandregistration;

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

public class BrandVettingReader extends Reader<BrandVetting> {
    private String pathBrandSid;
    private BrandVetting.VettingProvider vettingProvider;
    private Integer pageSize;

    public BrandVettingReader(final String pathBrandSid) {
        this.pathBrandSid = pathBrandSid;
    }

    public BrandVettingReader setVettingProvider(final BrandVetting.VettingProvider vettingProvider) {
        this.vettingProvider = vettingProvider;
        return this;
    }

    public BrandVettingReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<BrandVetting> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<BrandVetting> firstPage(final KandyRestClient client) {
        String path = "/v1/a2p/BrandRegistrations/{BrandSid}/Vettings";
        path = path.replace("{" + "BrandSid" + "}", this.pathBrandSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.MESSAGING.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<BrandVetting> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("BrandVetting read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "data",
                response.getContent(),
                BrandVetting.class,
                client.getObjectMapper());
    }

    @Override
    public Page<BrandVetting> previousPage(final Page<BrandVetting> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.MESSAGING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<BrandVetting> nextPage(final Page<BrandVetting> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.MESSAGING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<BrandVetting> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (vettingProvider != null) {

            request.addQueryParam("VettingProvider", vettingProvider.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
