/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Autopilot
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.autopilot.v1.assistant.task;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class FieldCreator extends Creator<Field> {
    private String pathAssistantSid;
    private String pathTaskSid;
    private String fieldType;
    private String uniqueName;

    public FieldCreator(final String pathAssistantSid, final String pathTaskSid, final String fieldType,
            final String uniqueName) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathTaskSid = pathTaskSid;
        this.fieldType = fieldType;
        this.uniqueName = uniqueName;
    }

    public FieldCreator setFieldType(final String fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    public FieldCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    @Override
    public Field create(final KandyRestClient client) {
        String path = "/v1/Assistants/{AssistantSid}/Tasks/{TaskSid}/Fields";

        path = path.replace("{" + "AssistantSid" + "}", this.pathAssistantSid.toString());
        path = path.replace("{" + "TaskSid" + "}", this.pathTaskSid.toString());
        path = path.replace("{" + "FieldType" + "}", this.fieldType.toString());
        path = path.replace("{" + "UniqueName" + "}", this.uniqueName.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.AUTOPILOT.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Field creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Field.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (fieldType != null) {
            request.addPostParam("FieldType", fieldType);

        }
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);

        }
    }
}
