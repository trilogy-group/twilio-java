/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.taskrouter.v1.workspace.task;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;
import com.kandy.base.Page;

public class ReservationReader extends Reader<Reservation> {
    private String pathWorkspaceSid;
    private String pathTaskSid;
    private Reservation.Status reservationStatus;
    private String workerSid;
    private Integer pageSize;

    public ReservationReader(final String pathWorkspaceSid, final String pathTaskSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.pathTaskSid = pathTaskSid;
    }

    public ReservationReader setReservationStatus(final Reservation.Status reservationStatus) {
        this.reservationStatus = reservationStatus;
        return this;
    }

    public ReservationReader setWorkerSid(final String workerSid) {
        this.workerSid = workerSid;
        return this;
    }

    public ReservationReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Reservation> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Reservation> firstPage(final TwilioRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Tasks/{TaskSid}/Reservations";
        path = path.replace("{" + "WorkspaceSid" + "}", this.pathWorkspaceSid.toString());
        path = path.replace("{" + "TaskSid" + "}", this.pathTaskSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.TASKROUTER.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Reservation> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Reservation read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "reservations",
                response.getContent(),
                Reservation.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Reservation> previousPage(final Page<Reservation> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.TASKROUTER.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Reservation> nextPage(final Page<Reservation> page, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.TASKROUTER.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Reservation> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (reservationStatus != null) {

            request.addQueryParam("ReservationStatus", reservationStatus.toString());
        }
        if (workerSid != null) {

            request.addQueryParam("WorkerSid", workerSid);
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
