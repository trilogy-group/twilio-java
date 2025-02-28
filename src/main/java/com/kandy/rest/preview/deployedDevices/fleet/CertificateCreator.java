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

package com.kandy.rest.preview.deployedDevices.fleet;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class CertificateCreator extends Creator<Certificate> {
    private String pathFleetSid;
    private String certificateData;
    private String friendlyName;
    private String deviceSid;

    public CertificateCreator(final String pathFleetSid, final String certificateData) {
        this.pathFleetSid = pathFleetSid;
        this.certificateData = certificateData;
    }

    public CertificateCreator setCertificateData(final String certificateData) {
        this.certificateData = certificateData;
        return this;
    }

    public CertificateCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public CertificateCreator setDeviceSid(final String deviceSid) {
        this.deviceSid = deviceSid;
        return this;
    }

    @Override
    public Certificate create(final KandyRestClient client) {
        String path = "/DeployedDevices/Fleets/{FleetSid}/Certificates";

        path = path.replace("{" + "FleetSid" + "}", this.pathFleetSid.toString());
        path = path.replace("{" + "CertificateData" + "}", this.certificateData.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PREVIEW.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Certificate creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Certificate.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (certificateData != null) {
            request.addPostParam("CertificateData", certificateData);

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (deviceSid != null) {
            request.addPostParam("DeviceSid", deviceSid);

        }
    }
}
