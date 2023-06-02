/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account.sip.ipaccesscontrollist;

import com.kandy.base.Deleter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class IpAddressDeleter extends Deleter<IpAddress> {
    private String pathIpAccessControlListSid;
    private String pathSid;
    private String pathAccountSid;

    public IpAddressDeleter(final String pathIpAccessControlListSid, final String pathSid) {
        this.pathIpAccessControlListSid = pathIpAccessControlListSid;
        this.pathSid = pathSid;
    }

    public IpAddressDeleter(final String pathAccountSid, final String pathIpAccessControlListSid,
            final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathIpAccessControlListSid = pathIpAccessControlListSid;
        this.pathSid = pathSid;
    }

    @Override
    public boolean delete(final TwilioRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}/IpAddresses/{Sid}.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "IpAccessControlListSid" + "}", this.pathIpAccessControlListSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.DELETE,
                Domains.API.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpAddress delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
}
