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

package com.kandy.rest.api.v2010.account.sip.domain;

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

public class IpAccessControlListMappingReader extends Reader<IpAccessControlListMapping> {
    private String pathDomainSid;
    private String pathAccountSid;
    private Integer pageSize;

    public IpAccessControlListMappingReader(final String pathDomainSid) {
        this.pathDomainSid = pathDomainSid;
    }

    public IpAccessControlListMappingReader(final String pathAccountSid, final String pathDomainSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathDomainSid = pathDomainSid;
    }

    public IpAccessControlListMappingReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<IpAccessControlListMapping> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<IpAccessControlListMapping> firstPage(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/SIP/Domains/{DomainSid}/IpAccessControlListMappings.json";
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "DomainSid" + "}", this.pathDomainSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.API.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<IpAccessControlListMapping> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpAccessControlListMapping read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "ip_access_control_list_mappings",
                response.getContent(),
                IpAccessControlListMapping.class,
                client.getObjectMapper());
    }

    @Override
    public Page<IpAccessControlListMapping> previousPage(final Page<IpAccessControlListMapping> page,
            final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<IpAccessControlListMapping> nextPage(final Page<IpAccessControlListMapping> page,
            final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<IpAccessControlListMapping> getPage(final String targetUrl, final KandyRestClient client) {
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
