/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Taskrouter
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.taskrouter.v1.workspace;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class WorkerCreator extends Creator<Worker> {
    private String pathWorkspaceSid;
    private String friendlyName;
    private String activitySid;
    private String attributes;

    public WorkerCreator(final String pathWorkspaceSid, final String friendlyName) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.friendlyName = friendlyName;
    }

    public WorkerCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public WorkerCreator setActivitySid(final String activitySid) {
        this.activitySid = activitySid;
        return this;
    }

    public WorkerCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    @Override
    public Worker create(final KandyRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Workers";

        path = path.replace("{" + "WorkspaceSid" + "}", this.pathWorkspaceSid.toString());
        path = path.replace("{" + "FriendlyName" + "}", this.friendlyName.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TASKROUTER.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Worker creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Worker.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (activitySid != null) {
            request.addPostParam("ActivitySid", activitySid);

        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);

        }
    }
}
