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

package com.kandy.rest.taskrouter.v1;

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class WorkspaceUpdater extends Updater<Workspace> {
    private String pathSid;
    private String defaultActivitySid;
    private URI eventCallbackUrl;
    private String eventsFilter;
    private String friendlyName;
    private Boolean multiTaskEnabled;
    private String timeoutActivitySid;
    private Workspace.QueueOrder prioritizeQueueOrder;

    public WorkspaceUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public WorkspaceUpdater setDefaultActivitySid(final String defaultActivitySid) {
        this.defaultActivitySid = defaultActivitySid;
        return this;
    }

    public WorkspaceUpdater setEventCallbackUrl(final URI eventCallbackUrl) {
        this.eventCallbackUrl = eventCallbackUrl;
        return this;
    }

    public WorkspaceUpdater setEventCallbackUrl(final String eventCallbackUrl) {
        return setEventCallbackUrl(Promoter.uriFromString(eventCallbackUrl));
    }

    public WorkspaceUpdater setEventsFilter(final String eventsFilter) {
        this.eventsFilter = eventsFilter;
        return this;
    }

    public WorkspaceUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public WorkspaceUpdater setMultiTaskEnabled(final Boolean multiTaskEnabled) {
        this.multiTaskEnabled = multiTaskEnabled;
        return this;
    }

    public WorkspaceUpdater setTimeoutActivitySid(final String timeoutActivitySid) {
        this.timeoutActivitySid = timeoutActivitySid;
        return this;
    }

    public WorkspaceUpdater setPrioritizeQueueOrder(final Workspace.QueueOrder prioritizeQueueOrder) {
        this.prioritizeQueueOrder = prioritizeQueueOrder;
        return this;
    }

    @Override
    public Workspace update(final KandyRestClient client) {
        String path = "/v1/Workspaces/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TASKROUTER.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Workspace update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Workspace.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (defaultActivitySid != null) {
            request.addPostParam("DefaultActivitySid", defaultActivitySid);

        }
        if (eventCallbackUrl != null) {
            request.addPostParam("EventCallbackUrl", eventCallbackUrl.toString());

        }
        if (eventsFilter != null) {
            request.addPostParam("EventsFilter", eventsFilter);

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (multiTaskEnabled != null) {
            request.addPostParam("MultiTaskEnabled", multiTaskEnabled.toString());

        }
        if (timeoutActivitySid != null) {
            request.addPostParam("TimeoutActivitySid", timeoutActivitySid);

        }
        if (prioritizeQueueOrder != null) {
            request.addPostParam("PrioritizeQueueOrder", prioritizeQueueOrder.toString());

        }
    }
}
