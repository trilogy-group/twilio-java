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

package com.kandy.rest.taskrouter.v1.workspace.worker;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

import java.time.ZonedDateTime;

public class WorkersCumulativeStatisticsFetcher extends Fetcher<WorkersCumulativeStatistics> {
    private String pathWorkspaceSid;
    private ZonedDateTime endDate;
    private Integer minutes;
    private ZonedDateTime startDate;
    private String taskChannel;

    public WorkersCumulativeStatisticsFetcher(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    public WorkersCumulativeStatisticsFetcher setEndDate(final ZonedDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public WorkersCumulativeStatisticsFetcher setMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    public WorkersCumulativeStatisticsFetcher setStartDate(final ZonedDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public WorkersCumulativeStatisticsFetcher setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    @Override
    public WorkersCumulativeStatistics fetch(final KandyRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Workers/CumulativeStatistics";

        path = path.replace("{" + "WorkspaceSid" + "}", this.pathWorkspaceSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.TASKROUTER.toString(),
                path);
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("WorkersCumulativeStatistics fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return WorkersCumulativeStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addQueryParams(final Request request) {
        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toInstant().toString());
        }

        if (minutes != null) {

            request.addQueryParam("Minutes", minutes.toString());
        }
        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toInstant().toString());
        }

        if (taskChannel != null) {

            request.addQueryParam("TaskChannel", taskChannel);
        }
    }
}
