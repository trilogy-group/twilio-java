/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Intelligence
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.intelligence.v2;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class ServiceCreator extends Creator<Service> {
    private String uniqueName;
    private Boolean autoTranscribe;
    private Boolean dataLogging;
    private String friendlyName;
    private String languageCode;
    private Boolean autoRedaction;
    private Boolean mediaRedaction;
    private String webhookUrl;
    private Service.HttpMethod webhookHttpMethod;

    public ServiceCreator(final String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public ServiceCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    public ServiceCreator setAutoTranscribe(final Boolean autoTranscribe) {
        this.autoTranscribe = autoTranscribe;
        return this;
    }

    public ServiceCreator setDataLogging(final Boolean dataLogging) {
        this.dataLogging = dataLogging;
        return this;
    }

    public ServiceCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ServiceCreator setLanguageCode(final String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    public ServiceCreator setAutoRedaction(final Boolean autoRedaction) {
        this.autoRedaction = autoRedaction;
        return this;
    }

    public ServiceCreator setMediaRedaction(final Boolean mediaRedaction) {
        this.mediaRedaction = mediaRedaction;
        return this;
    }

    public ServiceCreator setWebhookUrl(final String webhookUrl) {
        this.webhookUrl = webhookUrl;
        return this;
    }

    public ServiceCreator setWebhookHttpMethod(final Service.HttpMethod webhookHttpMethod) {
        this.webhookHttpMethod = webhookHttpMethod;
        return this;
    }

    @Override
    public Service create(final KandyRestClient client) {
        String path = "/v2/Services";

        path = path.replace("{" + "UniqueName" + "}", this.uniqueName.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.INTELLIGENCE.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Service creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Service.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);

        }
        if (autoTranscribe != null) {
            request.addPostParam("AutoTranscribe", autoTranscribe.toString());

        }
        if (dataLogging != null) {
            request.addPostParam("DataLogging", dataLogging.toString());

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (languageCode != null) {
            request.addPostParam("LanguageCode", languageCode);

        }
        if (autoRedaction != null) {
            request.addPostParam("AutoRedaction", autoRedaction.toString());

        }
        if (mediaRedaction != null) {
            request.addPostParam("MediaRedaction", mediaRedaction.toString());

        }
        if (webhookUrl != null) {
            request.addPostParam("WebhookUrl", webhookUrl);

        }
        if (webhookHttpMethod != null) {
            request.addPostParam("WebhookHttpMethod", webhookHttpMethod.toString());

        }
    }
}
