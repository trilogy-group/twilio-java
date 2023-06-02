/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Chat
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.chat.v2.service.channel;

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

public class MessageReader extends Reader<Message> {
    private String pathServiceSid;
    private String pathChannelSid;
    private Message.OrderType order;
    private Integer pageSize;

    public MessageReader(final String pathServiceSid, final String pathChannelSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
    }

    public MessageReader setOrder(final Message.OrderType order) {
        this.order = order;
        return this;
    }

    public MessageReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Message> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Message> firstPage(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Channels/{ChannelSid}/Messages";
        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "ChannelSid" + "}", this.pathChannelSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.CHAT.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Message> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Message read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "messages",
                response.getContent(),
                Message.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Message> previousPage(final Page<Message> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.CHAT.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Message> nextPage(final Page<Message> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.CHAT.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Message> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (order != null) {

            request.addQueryParam("Order", order.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
