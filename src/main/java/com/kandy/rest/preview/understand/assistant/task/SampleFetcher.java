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

package com.kandy.rest.preview.understand.assistant.task;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class SampleFetcher extends Fetcher<Sample> {
    private String pathAssistantSid;
    private String pathTaskSid;
    private String pathSid;

    public SampleFetcher(final String pathAssistantSid, final String pathTaskSid, final String pathSid) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathTaskSid = pathTaskSid;
        this.pathSid = pathSid;
    }

    @Override
    public Sample fetch(final TwilioRestClient client) {
        String path = "/understand/Assistants/{AssistantSid}/Tasks/{TaskSid}/Samples/{Sid}";

        path = path.replace("{" + "AssistantSid" + "}", this.pathAssistantSid.toString());
        path = path.replace("{" + "TaskSid" + "}", this.pathTaskSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.PREVIEW.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Sample fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Sample.fromJson(response.getStream(), client.getObjectMapper());
    }
}
