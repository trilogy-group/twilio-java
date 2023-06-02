/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Preview
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.preview.hostedNumbers;

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

public class AuthorizationDocumentReader extends Reader<AuthorizationDocument> {
    private String email;
    private AuthorizationDocument.Status status;
    private Integer pageSize;

    public AuthorizationDocumentReader() {
    }

    public AuthorizationDocumentReader setEmail(final String email) {
        this.email = email;
        return this;
    }

    public AuthorizationDocumentReader setStatus(final AuthorizationDocument.Status status) {
        this.status = status;
        return this;
    }

    public AuthorizationDocumentReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<AuthorizationDocument> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<AuthorizationDocument> firstPage(final KandyRestClient client) {
        String path = "/HostedNumbers/AuthorizationDocuments";

        Request request = new Request(
                HttpMethod.GET,
                Domains.PREVIEW.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<AuthorizationDocument> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AuthorizationDocument read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "items",
                response.getContent(),
                AuthorizationDocument.class,
                client.getObjectMapper());
    }

    @Override
    public Page<AuthorizationDocument> previousPage(final Page<AuthorizationDocument> page,
            final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<AuthorizationDocument> nextPage(final Page<AuthorizationDocument> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<AuthorizationDocument> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (email != null) {

            request.addQueryParam("Email", email);
        }
        if (status != null) {

            request.addQueryParam("Status", status.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
