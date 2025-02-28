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

import com.kandy.base.Creator;
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

import java.net.URI;

public class WorkspaceCreator extends Creator<Workspace> {
    private String friendlyName;
    private URI eventCallbackUrl;
    private String eventsFilter;
    private Boolean multiTaskEnabled;
    private String template;
    private Workspace.QueueOrder prioritizeQueueOrder;

    public WorkspaceCreator(final String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public WorkspaceCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public WorkspaceCreator setEventCallbackUrl(final URI eventCallbackUrl) {
        this.eventCallbackUrl = eventCallbackUrl;
        return this;
    }

    public WorkspaceCreator setEventCallbackUrl(final String eventCallbackUrl) {
        return setEventCallbackUrl(Promoter.uriFromString(eventCallbackUrl));
    }

    public WorkspaceCreator setEventsFilter(final String eventsFilter) {
        this.eventsFilter = eventsFilter;
        return this;
    }

    public WorkspaceCreator setMultiTaskEnabled(final Boolean multiTaskEnabled) {
        this.multiTaskEnabled = multiTaskEnabled;
        return this;
    }

    public WorkspaceCreator setTemplate(final String template) {
        this.template = template;
        return this;
    }

    public WorkspaceCreator setPrioritizeQueueOrder(final Workspace.QueueOrder prioritizeQueueOrder) {
        this.prioritizeQueueOrder = prioritizeQueueOrder;
        return this;
    }

    @Override
    public Workspace create(final KandyRestClient client) {
        String path = "/v1/Workspaces";

        path = path.replace("{" + "FriendlyName" + "}", this.friendlyName.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TASKROUTER.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Workspace creation failed: Unable to connect to server");
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
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (eventCallbackUrl != null) {
            request.addPostParam("EventCallbackUrl", eventCallbackUrl.toString());

        }
        if (eventsFilter != null) {
            request.addPostParam("EventsFilter", eventsFilter);

        }
        if (multiTaskEnabled != null) {
            request.addPostParam("MultiTaskEnabled", multiTaskEnabled.toString());

        }
        if (template != null) {
            request.addPostParam("Template", template);

        }
        if (prioritizeQueueOrder != null) {
            request.addPostParam("PrioritizeQueueOrder", prioritizeQueueOrder.toString());

        }
    }
}
