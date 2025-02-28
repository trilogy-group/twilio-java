/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Studio
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.studio.v2.flow;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class ExecutionUpdater extends Updater<Execution> {
    private String pathFlowSid;
    private String pathSid;
    private Execution.Status status;

    public ExecutionUpdater(final String pathFlowSid, final String pathSid, final Execution.Status status) {
        this.pathFlowSid = pathFlowSid;
        this.pathSid = pathSid;
        this.status = status;
    }

    public ExecutionUpdater setStatus(final Execution.Status status) {
        this.status = status;
        return this;
    }

    @Override
    public Execution update(final KandyRestClient client) {
        String path = "/v2/Flows/{FlowSid}/Executions/{Sid}";

        path = path.replace("{" + "FlowSid" + "}", this.pathFlowSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());
        path = path.replace("{" + "Status" + "}", this.status.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.STUDIO.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Execution update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Execution.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
    }
}
