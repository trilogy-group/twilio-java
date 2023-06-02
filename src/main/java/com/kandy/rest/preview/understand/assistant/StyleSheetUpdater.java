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
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

import java.util.Map;

public class StyleSheetUpdater extends Updater<StyleSheet> {
    private String pathAssistantSid;
    private Map<String, Object> styleSheet;

    public StyleSheetUpdater(final String pathAssistantSid) {
        this.pathAssistantSid = pathAssistantSid;
    }

    public StyleSheetUpdater setStyleSheet(final Map<String, Object> styleSheet) {
        this.styleSheet = styleSheet;
        return this;
    }

    @Override
    public StyleSheet update(final TwilioRestClient client) {
        String path = "/understand/Assistants/{AssistantSid}/StyleSheet";

        path = path.replace("{" + "AssistantSid" + "}", this.pathAssistantSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PREVIEW.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("StyleSheet update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return StyleSheet.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (styleSheet != null) {
            request.addPostParam("StyleSheet", Converter.mapToJson(styleSheet));

        }
    }
}
