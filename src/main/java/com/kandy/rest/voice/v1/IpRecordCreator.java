/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Voice
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.voice.v1;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class IpRecordCreator extends Creator<IpRecord> {
    private String ipAddress;
    private String friendlyName;
    private Integer cidrPrefixLength;

    public IpRecordCreator(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public IpRecordCreator setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public IpRecordCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public IpRecordCreator setCidrPrefixLength(final Integer cidrPrefixLength) {
        this.cidrPrefixLength = cidrPrefixLength;
        return this;
    }

    @Override
    public IpRecord create(final KandyRestClient client) {
        String path = "/v1/IpRecords";

        path = path.replace("{" + "IpAddress" + "}", this.ipAddress.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VOICE.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("IpRecord creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IpRecord.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (ipAddress != null) {
            request.addPostParam("IpAddress", ipAddress);

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (cidrPrefixLength != null) {
            request.addPostParam("CidrPrefixLength", cidrPrefixLength.toString());

        }
    }
}
