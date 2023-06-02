/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.preview.understand.assistant;

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

import java.net.URI;

import java.util.Map;

public class TaskUpdater extends Updater<Task> {
    private String pathAssistantSid;
    private String pathSid;
    private String friendlyName;
    private String uniqueName;
    private Map<String, Object> actions;
    private URI actionsUrl;

    public TaskUpdater(final String pathAssistantSid, final String pathSid) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathSid = pathSid;
    }

    public TaskUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public TaskUpdater setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    public TaskUpdater setActions(final Map<String, Object> actions) {
        this.actions = actions;
        return this;
    }

    public TaskUpdater setActionsUrl(final URI actionsUrl) {
        this.actionsUrl = actionsUrl;
        return this;
    }

    public TaskUpdater setActionsUrl(final String actionsUrl) {
        return setActionsUrl(Promoter.uriFromString(actionsUrl));
    }

    @Override
    public Task update(final TwilioRestClient client) {
        String path = "/understand/Assistants/{AssistantSid}/Tasks/{Sid}";

        path = path.replace("{" + "AssistantSid" + "}", this.pathAssistantSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PREVIEW.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Task update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Task.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);

        }
        if (actions != null) {
            request.addPostParam("Actions", Converter.mapToJson(actions));

        }
        if (actionsUrl != null) {
            request.addPostParam("ActionsUrl", actionsUrl.toString());

        }
    }
}
