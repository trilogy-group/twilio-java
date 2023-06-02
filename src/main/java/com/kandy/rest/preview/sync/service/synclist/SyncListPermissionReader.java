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

package com.kandy.rest.preview.sync.service.synclist;

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

public class SyncListPermissionReader extends Reader<SyncListPermission> {
    private String pathServiceSid;
    private String pathListSid;
    private Integer pageSize;

    public SyncListPermissionReader(final String pathServiceSid, final String pathListSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
    }

    public SyncListPermissionReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<SyncListPermission> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<SyncListPermission> firstPage(final KandyRestClient client) {
        String path = "/Sync/Services/{ServiceSid}/Lists/{ListSid}/Permissions";
        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "ListSid" + "}", this.pathListSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.PREVIEW.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<SyncListPermission> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncListPermission read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "permissions",
                response.getContent(),
                SyncListPermission.class,
                client.getObjectMapper());
    }

    @Override
    public Page<SyncListPermission> previousPage(final Page<SyncListPermission> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<SyncListPermission> nextPage(final Page<SyncListPermission> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<SyncListPermission> getPage(final String targetUrl, final KandyRestClient client) {
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
