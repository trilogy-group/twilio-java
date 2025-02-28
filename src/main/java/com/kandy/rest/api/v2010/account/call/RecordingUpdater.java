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

package com.kandy.rest.api.v2010.account.call;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class RecordingUpdater extends Updater<Recording> {
    private String pathCallSid;
    private String pathSid;
    private Recording.Status status;
    private String pathAccountSid;
    private String pauseBehavior;

    public RecordingUpdater(final String pathCallSid, final String pathSid, final Recording.Status status) {
        this.pathCallSid = pathCallSid;
        this.pathSid = pathSid;
        this.status = status;
    }

    public RecordingUpdater(final String pathAccountSid, final String pathCallSid, final String pathSid,
            final Recording.Status status) {
        this.pathAccountSid = pathAccountSid;
        this.pathCallSid = pathCallSid;
        this.pathSid = pathSid;
        this.status = status;
    }

    public RecordingUpdater setStatus(final Recording.Status status) {
        this.status = status;
        return this;
    }

    public RecordingUpdater setPauseBehavior(final String pauseBehavior) {
        this.pauseBehavior = pauseBehavior;
        return this;
    }

    @Override
    public Recording update(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Calls/{CallSid}/Recordings/{Sid}.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "CallSid" + "}", this.pathCallSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());
        path = path.replace("{" + "Status" + "}", this.status.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Recording update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Recording.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
        if (pauseBehavior != null) {
            request.addPostParam("PauseBehavior", pauseBehavior);

        }
    }
}
