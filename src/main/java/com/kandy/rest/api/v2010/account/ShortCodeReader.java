/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Api
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account;

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

public class ShortCodeReader extends Reader<ShortCode> {
    private String pathAccountSid;
    private String friendlyName;
    private String shortCode;
    private Integer pageSize;

    public ShortCodeReader() {
    }

    public ShortCodeReader(final String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    public ShortCodeReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ShortCodeReader setShortCode(final String shortCode) {
        this.shortCode = shortCode;
        return this;
    }

    public ShortCodeReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<ShortCode> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<ShortCode> firstPage(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/SMS/ShortCodes.json";
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.API.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<ShortCode> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ShortCode read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "short_codes",
                response.getContent(),
                ShortCode.class,
                client.getObjectMapper());
    }

    @Override
    public Page<ShortCode> previousPage(final Page<ShortCode> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<ShortCode> nextPage(final Page<ShortCode> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<ShortCode> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (friendlyName != null) {

            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (shortCode != null) {

            request.addQueryParam("ShortCode", shortCode);
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
