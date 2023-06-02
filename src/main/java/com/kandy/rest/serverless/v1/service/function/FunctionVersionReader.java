/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Serverless
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.serverless.v1.service.function;

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

public class FunctionVersionReader extends Reader<FunctionVersion> {
    private String pathServiceSid;
    private String pathFunctionSid;
    private Integer pageSize;

    public FunctionVersionReader(final String pathServiceSid, final String pathFunctionSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathFunctionSid = pathFunctionSid;
    }

    public FunctionVersionReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<FunctionVersion> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<FunctionVersion> firstPage(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Functions/{FunctionSid}/Versions";
        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "FunctionSid" + "}", this.pathFunctionSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.SERVERLESS.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<FunctionVersion> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("FunctionVersion read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "function_versions",
                response.getContent(),
                FunctionVersion.class,
                client.getObjectMapper());
    }

    @Override
    public Page<FunctionVersion> previousPage(final Page<FunctionVersion> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.SERVERLESS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<FunctionVersion> nextPage(final Page<FunctionVersion> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.SERVERLESS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<FunctionVersion> getPage(final String targetUrl, final TwilioRestClient client) {
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
