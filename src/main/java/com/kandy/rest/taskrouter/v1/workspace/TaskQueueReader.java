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

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import com.kandy.base.Page;

public class TaskQueueReader extends Reader<TaskQueue> {
    private String pathWorkspaceSid;
    private String friendlyName;
    private String evaluateWorkerAttributes;
    private String workerSid;
    private String ordering;
    private Integer pageSize;

    public TaskQueueReader(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    public TaskQueueReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public TaskQueueReader setEvaluateWorkerAttributes(final String evaluateWorkerAttributes) {
        this.evaluateWorkerAttributes = evaluateWorkerAttributes;
        return this;
    }

    public TaskQueueReader setWorkerSid(final String workerSid) {
        this.workerSid = workerSid;
        return this;
    }

    public TaskQueueReader setOrdering(final String ordering) {
        this.ordering = ordering;
        return this;
    }

    public TaskQueueReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<TaskQueue> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<TaskQueue> firstPage(final KandyRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/TaskQueues";
        path = path.replace("{" + "WorkspaceSid" + "}", this.pathWorkspaceSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.TASKROUTER.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<TaskQueue> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("TaskQueue read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "task_queues",
                response.getContent(),
                TaskQueue.class,
                client.getObjectMapper());
    }

    @Override
    public Page<TaskQueue> previousPage(final Page<TaskQueue> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.TASKROUTER.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<TaskQueue> nextPage(final Page<TaskQueue> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.TASKROUTER.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<TaskQueue> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (friendlyName != null) {

            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (evaluateWorkerAttributes != null) {

            request.addQueryParam("EvaluateWorkerAttributes", evaluateWorkerAttributes);
        }
        if (workerSid != null) {

            request.addQueryParam("WorkerSid", workerSid);
        }
        if (ordering != null) {

            request.addQueryParam("Ordering", ordering);
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
