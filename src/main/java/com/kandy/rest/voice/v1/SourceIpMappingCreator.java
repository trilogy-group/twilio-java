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

public class SourceIpMappingCreator extends Creator<SourceIpMapping> {
    private String ipRecordSid;
    private String sipDomainSid;

    public SourceIpMappingCreator(final String ipRecordSid, final String sipDomainSid) {
        this.ipRecordSid = ipRecordSid;
        this.sipDomainSid = sipDomainSid;
    }

    public SourceIpMappingCreator setIpRecordSid(final String ipRecordSid) {
        this.ipRecordSid = ipRecordSid;
        return this;
    }

    public SourceIpMappingCreator setSipDomainSid(final String sipDomainSid) {
        this.sipDomainSid = sipDomainSid;
        return this;
    }

    @Override
    public SourceIpMapping create(final KandyRestClient client) {
        String path = "/v1/SourceIpMappings";

        path = path.replace("{" + "IpRecordSid" + "}", this.ipRecordSid.toString());
        path = path.replace("{" + "SipDomainSid" + "}", this.sipDomainSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VOICE.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("SourceIpMapping creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SourceIpMapping.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (ipRecordSid != null) {
            request.addPostParam("IpRecordSid", ipRecordSid);

        }
        if (sipDomainSid != null) {
            request.addPostParam("SipDomainSid", sipDomainSid);

        }
    }
}
