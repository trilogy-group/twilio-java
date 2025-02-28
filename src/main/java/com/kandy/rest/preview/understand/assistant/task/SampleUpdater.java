/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Preview
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.preview.understand.assistant.task;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class SampleUpdater extends Updater<Sample> {
    private String pathAssistantSid;
    private String pathTaskSid;
    private String pathSid;
    private String language;
    private String taggedText;
    private String sourceChannel;

    public SampleUpdater(final String pathAssistantSid, final String pathTaskSid, final String pathSid) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathTaskSid = pathTaskSid;
        this.pathSid = pathSid;
    }

    public SampleUpdater setLanguage(final String language) {
        this.language = language;
        return this;
    }

    public SampleUpdater setTaggedText(final String taggedText) {
        this.taggedText = taggedText;
        return this;
    }

    public SampleUpdater setSourceChannel(final String sourceChannel) {
        this.sourceChannel = sourceChannel;
        return this;
    }

    @Override
    public Sample update(final KandyRestClient client) {
        String path = "/understand/Assistants/{AssistantSid}/Tasks/{TaskSid}/Samples/{Sid}";

        path = path.replace("{" + "AssistantSid" + "}", this.pathAssistantSid.toString());
        path = path.replace("{" + "TaskSid" + "}", this.pathTaskSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PREVIEW.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Sample update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Sample.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (language != null) {
            request.addPostParam("Language", language);

        }
        if (taggedText != null) {
            request.addPostParam("TaggedText", taggedText);

        }
        if (sourceChannel != null) {
            request.addPostParam("SourceChannel", sourceChannel);

        }
    }
}
