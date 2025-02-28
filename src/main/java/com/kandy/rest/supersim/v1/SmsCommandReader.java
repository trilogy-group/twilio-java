/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Supersim
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.supersim.v1;

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

public class SmsCommandReader extends Reader<SmsCommand> {
    private String sim;
    private SmsCommand.Status status;
    private SmsCommand.Direction direction;
    private Integer pageSize;

    public SmsCommandReader() {
    }

    public SmsCommandReader setSim(final String sim) {
        this.sim = sim;
        return this;
    }

    public SmsCommandReader setStatus(final SmsCommand.Status status) {
        this.status = status;
        return this;
    }

    public SmsCommandReader setDirection(final SmsCommand.Direction direction) {
        this.direction = direction;
        return this;
    }

    public SmsCommandReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<SmsCommand> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<SmsCommand> firstPage(final KandyRestClient client) {
        String path = "/v1/SmsCommands";

        Request request = new Request(
                HttpMethod.GET,
                Domains.SUPERSIM.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<SmsCommand> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SmsCommand read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "sms_commands",
                response.getContent(),
                SmsCommand.class,
                client.getObjectMapper());
    }

    @Override
    public Page<SmsCommand> previousPage(final Page<SmsCommand> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.SUPERSIM.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<SmsCommand> nextPage(final Page<SmsCommand> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.SUPERSIM.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<SmsCommand> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (sim != null) {

            request.addQueryParam("Sim", sim);
        }
        if (status != null) {

            request.addQueryParam("Status", status.toString());
        }
        if (direction != null) {

            request.addQueryParam("Direction", direction.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
