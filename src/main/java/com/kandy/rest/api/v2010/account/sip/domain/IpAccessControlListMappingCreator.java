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

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class IpAccessControlListMappingCreator extends Creator<IpAccessControlListMapping> {
    private String pathDomainSid;
    private String ipAccessControlListSid;
    private String pathAccountSid;

    public IpAccessControlListMappingCreator(final String pathDomainSid, final String ipAccessControlListSid) {
        this.pathDomainSid = pathDomainSid;
        this.ipAccessControlListSid = ipAccessControlListSid;
    }

    public IpAccessControlListMappingCreator(final String pathAccountSid, final String pathDomainSid,
            final String ipAccessControlListSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathDomainSid = pathDomainSid;
        this.ipAccessControlListSid = ipAccessControlListSid;
    }

    public IpAccessControlListMappingCreator setIpAccessControlListSid(final String ipAccessControlListSid) {
        this.ipAccessControlListSid = ipAccessControlListSid;
        return this;
    }

    @Override
    public IpAccessControlListMapping create(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/SIP/Domains/{DomainSid}/IpAccessControlListMappings.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "DomainSid" + "}", this.pathDomainSid.toString());
        path = path.replace("{" + "IpAccessControlListSid" + "}", this.ipAccessControlListSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("IpAccessControlListMapping creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IpAccessControlListMapping.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (ipAccessControlListSid != null) {
            request.addPostParam("IpAccessControlListSid", ipAccessControlListSid);

        }
    }
}
