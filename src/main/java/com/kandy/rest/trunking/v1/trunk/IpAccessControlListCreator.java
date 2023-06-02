/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trunking
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trunking.v1.trunk;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class IpAccessControlListCreator extends Creator<IpAccessControlList> {
    private String pathTrunkSid;
    private String ipAccessControlListSid;

    public IpAccessControlListCreator(final String pathTrunkSid, final String ipAccessControlListSid) {
        this.pathTrunkSid = pathTrunkSid;
        this.ipAccessControlListSid = ipAccessControlListSid;
    }

    public IpAccessControlListCreator setIpAccessControlListSid(final String ipAccessControlListSid) {
        this.ipAccessControlListSid = ipAccessControlListSid;
        return this;
    }

    @Override
    public IpAccessControlList create(final TwilioRestClient client) {
        String path = "/v1/Trunks/{TrunkSid}/IpAccessControlLists";

        path = path.replace("{" + "TrunkSid" + "}", this.pathTrunkSid.toString());
        path = path.replace("{" + "IpAccessControlListSid" + "}", this.ipAccessControlListSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TRUNKING.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("IpAccessControlList creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IpAccessControlList.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (ipAccessControlListSid != null) {
            request.addPostParam("IpAccessControlListSid", ipAccessControlListSid);

        }
    }
}
