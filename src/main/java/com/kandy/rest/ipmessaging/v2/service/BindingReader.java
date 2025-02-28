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

package com.kandy.rest.ipmessaging.v2.service;

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
import com.kandy.rest.Domains;
import com.kandy.base.Page;

import java.util.List;

public class BindingReader extends Reader<Binding> {
    private String pathServiceSid;
    private List<Binding.BindingType> bindingType;
    private List<String> identity;
    private Integer pageSize;

    public BindingReader(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    public BindingReader setBindingType(final List<Binding.BindingType> bindingType) {
        this.bindingType = bindingType;
        return this;
    }

    public BindingReader setBindingType(final Binding.BindingType bindingType) {
        return setBindingType(Promoter.listOfOne(bindingType));
    }

    public BindingReader setIdentity(final List<String> identity) {
        this.identity = identity;
        return this;
    }

    public BindingReader setIdentity(final String identity) {
        return setIdentity(Promoter.listOfOne(identity));
    }

    public BindingReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Binding> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Binding> firstPage(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Bindings";
        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.IPMESSAGING.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Binding> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Binding read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "bindings",
                response.getContent(),
                Binding.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Binding> previousPage(final Page<Binding> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.IPMESSAGING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Binding> nextPage(final Page<Binding> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.IPMESSAGING.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Binding> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (bindingType != null) {
            for (Binding.BindingType prop : bindingType) {
                request.addQueryParam("BindingType", prop.toString());
            }
        }
        if (identity != null) {
            for (String prop : identity) {
                request.addQueryParam("Identity", prop);
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
