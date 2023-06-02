/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Numbers
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.numbers.v2.regulatorycompliance;

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

import java.net.URI;

public class BundleUpdater extends Updater<Bundle> {
    private String pathSid;
    private Bundle.Status status;
    private URI statusCallback;
    private String friendlyName;
    private String email;

    public BundleUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public BundleUpdater setStatus(final Bundle.Status status) {
        this.status = status;
        return this;
    }

    public BundleUpdater setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public BundleUpdater setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    public BundleUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public BundleUpdater setEmail(final String email) {
        this.email = email;
        return this;
    }

    @Override
    public Bundle update(final KandyRestClient client) {
        String path = "/v2/RegulatoryCompliance/Bundles/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.NUMBERS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Bundle update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Bundle.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (email != null) {
            request.addPostParam("Email", email);

        }
    }
}
