/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trunking
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trunking.v1.trunk;

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

public class CredentialListReader extends Reader<CredentialList> {
    private String pathTrunkSid;
    private Integer pageSize;

    public CredentialListReader(final String pathTrunkSid) {
        this.pathTrunkSid = pathTrunkSid;
    }

    public CredentialListReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<CredentialList> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<CredentialList> firstPage(final KandyRestClient client) {
        String path = "/v1/Trunks/{TrunkSid}/CredentialLists";
        path = path.replace("{" + "TrunkSid" + "}", this.pathTrunkSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.TRUNKING.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<CredentialList> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CredentialList read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "credential_lists",
                response.getContent(),
                CredentialList.class,
                client.getObjectMapper());
    }

    @Override
    public Page<CredentialList> previousPage(final Page<CredentialList> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.TRUNKING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<CredentialList> nextPage(final Page<CredentialList> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.TRUNKING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<CredentialList> getPage(final String targetUrl, final KandyRestClient client) {
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
