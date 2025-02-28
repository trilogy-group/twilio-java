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

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class ServiceUpdater extends Updater<Service> {
    private String pathSid;
    private String ifMatch;
    private Boolean autoTranscribe;
    private Boolean dataLogging;
    private String friendlyName;
    private String languageCode;
    private String uniqueName;
    private Boolean autoRedaction;
    private Boolean mediaRedaction;
    private String webhookUrl;
    private Service.HttpMethod webhookHttpMethod;

    public ServiceUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public ServiceUpdater setIfMatch(final String ifMatch) {
        this.ifMatch = ifMatch;
        return this;
    }

    public ServiceUpdater setAutoTranscribe(final Boolean autoTranscribe) {
        this.autoTranscribe = autoTranscribe;
        return this;
    }

    public ServiceUpdater setDataLogging(final Boolean dataLogging) {
        this.dataLogging = dataLogging;
        return this;
    }

    public ServiceUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ServiceUpdater setLanguageCode(final String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    public ServiceUpdater setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    public ServiceUpdater setAutoRedaction(final Boolean autoRedaction) {
        this.autoRedaction = autoRedaction;
        return this;
    }

    public ServiceUpdater setMediaRedaction(final Boolean mediaRedaction) {
        this.mediaRedaction = mediaRedaction;
        return this;
    }

    public ServiceUpdater setWebhookUrl(final String webhookUrl) {
        this.webhookUrl = webhookUrl;
        return this;
    }

    public ServiceUpdater setWebhookHttpMethod(final Service.HttpMethod webhookHttpMethod) {
        this.webhookHttpMethod = webhookHttpMethod;
        return this;
    }

    @Override
    public Service update(final KandyRestClient client) {
        String path = "/v2/Services/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.INTELLIGENCE.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Service update failed: Unable to connect to server");
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
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);

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

    private void addHeaderParams(final Request request) {
        if (ifMatch != null) {
            request.addHeaderParam("If-Match", ifMatch);

        }
    }
}
