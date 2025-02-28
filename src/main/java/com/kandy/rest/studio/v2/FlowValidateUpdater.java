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

package com.kandy.rest.studio.v2;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

import java.util.Map;

public class FlowValidateUpdater extends Updater<FlowValidate> {
    private String friendlyName;
    private FlowValidate.Status status;
    private Map<String, Object> definition;
    private String commitMessage;

    public FlowValidateUpdater(final String friendlyName, final FlowValidate.Status status,
            final Map<String, Object> definition) {
        this.friendlyName = friendlyName;
        this.status = status;
        this.definition = definition;
    }

    public FlowValidateUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public FlowValidateUpdater setStatus(final FlowValidate.Status status) {
        this.status = status;
        return this;
    }

    public FlowValidateUpdater setDefinition(final Map<String, Object> definition) {
        this.definition = definition;
        return this;
    }

    public FlowValidateUpdater setCommitMessage(final String commitMessage) {
        this.commitMessage = commitMessage;
        return this;
    }

    @Override
    public FlowValidate update(final KandyRestClient client) {
        String path = "/v2/Flows/Validate";

        path = path.replace("{" + "FriendlyName" + "}", this.friendlyName.toString());
        path = path.replace("{" + "Status" + "}", this.status.toString());
        path = path.replace("{" + "Definition" + "}", this.definition.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.STUDIO.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("FlowValidate update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return FlowValidate.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
        if (definition != null) {
            request.addPostParam("Definition", Converter.mapToJson(definition));

        }
        if (commitMessage != null) {
            request.addPostParam("CommitMessage", commitMessage);

        }
    }
}
