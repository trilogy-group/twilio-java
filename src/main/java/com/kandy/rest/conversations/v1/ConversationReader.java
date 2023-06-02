/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.conversations.v1;

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

public class ConversationReader extends Reader<Conversation> {
    private String startDate;
    private String endDate;
    private Conversation.State state;
    private Integer pageSize;

    public ConversationReader() {
    }

    public ConversationReader setStartDate(final String startDate) {
        this.startDate = startDate;
        return this;
    }

    public ConversationReader setEndDate(final String endDate) {
        this.endDate = endDate;
        return this;
    }

    public ConversationReader setState(final Conversation.State state) {
        this.state = state;
        return this;
    }

    public ConversationReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Conversation> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Conversation> firstPage(final TwilioRestClient client) {
        String path = "/v1/Conversations";

        Request request = new Request(
                HttpMethod.GET,
                Domains.CONVERSATIONS.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Conversation> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Conversation read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "conversations",
                response.getContent(),
                Conversation.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Conversation> previousPage(final Page<Conversation> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.CONVERSATIONS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Conversation> nextPage(final Page<Conversation> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.CONVERSATIONS.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Conversation> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (startDate != null) {

            request.addQueryParam("StartDate", startDate);
        }
        if (endDate != null) {

            request.addQueryParam("EndDate", endDate);
        }
        if (state != null) {

            request.addQueryParam("State", state.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
