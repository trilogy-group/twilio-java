/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.preview.deployedDevices.fleet;

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

public class KeyReader extends Reader<Key> {
    private String pathFleetSid;
    private String deviceSid;
    private Integer pageSize;

    public KeyReader(final String pathFleetSid) {
        this.pathFleetSid = pathFleetSid;
    }

    public KeyReader setDeviceSid(final String deviceSid) {
        this.deviceSid = deviceSid;
        return this;
    }

    public KeyReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Key> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Key> firstPage(final TwilioRestClient client) {
        String path = "/DeployedDevices/Fleets/{FleetSid}/Keys";
        path = path.replace("{" + "FleetSid" + "}", this.pathFleetSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.PREVIEW.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Key> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Key read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "keys",
                response.getContent(),
                Key.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Key> previousPage(final Page<Key> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Key> nextPage(final Page<Key> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Key> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (deviceSid != null) {

            request.addQueryParam("DeviceSid", deviceSid);
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
