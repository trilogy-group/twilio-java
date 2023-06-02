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

public class TaskCreator extends Creator<Task> {
    private String pathWorkspaceSid;
    private Integer timeout;
    private Integer priority;
    private String taskChannel;
    private String workflowSid;
    private String attributes;

    public TaskCreator(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    public TaskCreator setTimeout(final Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public TaskCreator setPriority(final Integer priority) {
        this.priority = priority;
        return this;
    }

    public TaskCreator setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    public TaskCreator setWorkflowSid(final String workflowSid) {
        this.workflowSid = workflowSid;
        return this;
    }

    public TaskCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    @Override
    public Task create(final KandyRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Tasks";

        path = path.replace("{" + "WorkspaceSid" + "}", this.pathWorkspaceSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TASKROUTER.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Task creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Task.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (timeout != null) {
            request.addPostParam("Timeout", timeout.toString());

        }
        if (priority != null) {
            request.addPostParam("Priority", priority.toString());

        }
        if (taskChannel != null) {
            request.addPostParam("TaskChannel", taskChannel);

        }
        if (workflowSid != null) {
            request.addPostParam("WorkflowSid", workflowSid);

        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);

        }
    }
}
