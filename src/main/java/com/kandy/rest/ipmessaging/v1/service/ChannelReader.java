/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Ip_messaging
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.ipmessaging.v1.service;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import com.kandy.base.Page;

import java.util.List;

public class ChannelReader extends Reader<Channel> {
    private String pathServiceSid;
    private List<Channel.ChannelType> type;
    private Integer pageSize;

    public ChannelReader(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    public ChannelReader setType(final List<Channel.ChannelType> type) {
        this.type = type;
        return this;
    }

    public ChannelReader setType(final Channel.ChannelType type) {
        return setType(Promoter.listOfOne(type));
    }

    public ChannelReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Channel> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Channel> firstPage(final KandyRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Channels";
        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.IPMESSAGING.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Channel> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Channel read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "channels",
                response.getContent(),
                Channel.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Channel> previousPage(final Page<Channel> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.IPMESSAGING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Channel> nextPage(final Page<Channel> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.IPMESSAGING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Channel> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (type != null) {
            for (Channel.ChannelType prop : type) {
                request.addQueryParam("Type", prop.toString());
            }
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
