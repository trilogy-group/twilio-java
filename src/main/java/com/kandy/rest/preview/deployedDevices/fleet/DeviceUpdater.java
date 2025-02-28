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

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class DeviceUpdater extends Updater<Device> {
    private String pathFleetSid;
    private String pathSid;
    private String friendlyName;
    private String identity;
    private String deploymentSid;
    private Boolean enabled;

    public DeviceUpdater(final String pathFleetSid, final String pathSid) {
        this.pathFleetSid = pathFleetSid;
        this.pathSid = pathSid;
    }

    public DeviceUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public DeviceUpdater setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    public DeviceUpdater setDeploymentSid(final String deploymentSid) {
        this.deploymentSid = deploymentSid;
        return this;
    }

    public DeviceUpdater setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public Device update(final KandyRestClient client) {
        String path = "/DeployedDevices/Fleets/{FleetSid}/Devices/{Sid}";

        path = path.replace("{" + "FleetSid" + "}", this.pathFleetSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PREVIEW.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Device update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Device.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (identity != null) {
            request.addPostParam("Identity", identity);

        }
        if (deploymentSid != null) {
            request.addPostParam("DeploymentSid", deploymentSid);

        }
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());

        }
    }
}
