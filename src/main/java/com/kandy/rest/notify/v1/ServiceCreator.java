/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Notify
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.notify.v1;

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
    private String friendlyName;
    private String apnCredentialSid;
    private String gcmCredentialSid;
    private String messagingServiceSid;
    private String facebookMessengerPageId;
    private String defaultApnNotificationProtocolVersion;
    private String defaultGcmNotificationProtocolVersion;
    private String fcmCredentialSid;
    private String defaultFcmNotificationProtocolVersion;
    private Boolean logEnabled;
    private String alexaSkillId;
    private String defaultAlexaNotificationProtocolVersion;
    private String deliveryCallbackUrl;
    private Boolean deliveryCallbackEnabled;

    public ServiceCreator() {
    }

    public ServiceCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ServiceCreator setApnCredentialSid(final String apnCredentialSid) {
        this.apnCredentialSid = apnCredentialSid;
        return this;
    }

    public ServiceCreator setGcmCredentialSid(final String gcmCredentialSid) {
        this.gcmCredentialSid = gcmCredentialSid;
        return this;
    }

    public ServiceCreator setMessagingServiceSid(final String messagingServiceSid) {
        this.messagingServiceSid = messagingServiceSid;
        return this;
    }

    public ServiceCreator setFacebookMessengerPageId(final String facebookMessengerPageId) {
        this.facebookMessengerPageId = facebookMessengerPageId;
        return this;
    }

    public ServiceCreator setDefaultApnNotificationProtocolVersion(final String defaultApnNotificationProtocolVersion) {
        this.defaultApnNotificationProtocolVersion = defaultApnNotificationProtocolVersion;
        return this;
    }

    public ServiceCreator setDefaultGcmNotificationProtocolVersion(final String defaultGcmNotificationProtocolVersion) {
        this.defaultGcmNotificationProtocolVersion = defaultGcmNotificationProtocolVersion;
        return this;
    }

    public ServiceCreator setFcmCredentialSid(final String fcmCredentialSid) {
        this.fcmCredentialSid = fcmCredentialSid;
        return this;
    }

    public ServiceCreator setDefaultFcmNotificationProtocolVersion(final String defaultFcmNotificationProtocolVersion) {
        this.defaultFcmNotificationProtocolVersion = defaultFcmNotificationProtocolVersion;
        return this;
    }

    public ServiceCreator setLogEnabled(final Boolean logEnabled) {
        this.logEnabled = logEnabled;
        return this;
    }

    public ServiceCreator setAlexaSkillId(final String alexaSkillId) {
        this.alexaSkillId = alexaSkillId;
        return this;
    }

    public ServiceCreator setDefaultAlexaNotificationProtocolVersion(
            final String defaultAlexaNotificationProtocolVersion) {
        this.defaultAlexaNotificationProtocolVersion = defaultAlexaNotificationProtocolVersion;
        return this;
    }

    public ServiceCreator setDeliveryCallbackUrl(final String deliveryCallbackUrl) {
        this.deliveryCallbackUrl = deliveryCallbackUrl;
        return this;
    }

    public ServiceCreator setDeliveryCallbackEnabled(final Boolean deliveryCallbackEnabled) {
        this.deliveryCallbackEnabled = deliveryCallbackEnabled;
        return this;
    }

    @Override
    public Service create(final KandyRestClient client) {
        String path = "/v1/Services";

        Request request = new Request(
                HttpMethod.POST,
                Domains.NOTIFY.toString(),
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
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (apnCredentialSid != null) {
            request.addPostParam("ApnCredentialSid", apnCredentialSid);

        }
        if (gcmCredentialSid != null) {
            request.addPostParam("GcmCredentialSid", gcmCredentialSid);

        }
        if (messagingServiceSid != null) {
            request.addPostParam("MessagingServiceSid", messagingServiceSid);

        }
        if (facebookMessengerPageId != null) {
            request.addPostParam("FacebookMessengerPageId", facebookMessengerPageId);

        }
        if (defaultApnNotificationProtocolVersion != null) {
            request.addPostParam("DefaultApnNotificationProtocolVersion", defaultApnNotificationProtocolVersion);

        }
        if (defaultGcmNotificationProtocolVersion != null) {
            request.addPostParam("DefaultGcmNotificationProtocolVersion", defaultGcmNotificationProtocolVersion);

        }
        if (fcmCredentialSid != null) {
            request.addPostParam("FcmCredentialSid", fcmCredentialSid);

        }
        if (defaultFcmNotificationProtocolVersion != null) {
            request.addPostParam("DefaultFcmNotificationProtocolVersion", defaultFcmNotificationProtocolVersion);

        }
        if (logEnabled != null) {
            request.addPostParam("LogEnabled", logEnabled.toString());

        }
        if (alexaSkillId != null) {
            request.addPostParam("AlexaSkillId", alexaSkillId);

        }
        if (defaultAlexaNotificationProtocolVersion != null) {
            request.addPostParam("DefaultAlexaNotificationProtocolVersion", defaultAlexaNotificationProtocolVersion);

        }
        if (deliveryCallbackUrl != null) {
            request.addPostParam("DeliveryCallbackUrl", deliveryCallbackUrl);

        }
        if (deliveryCallbackEnabled != null) {
            request.addPostParam("DeliveryCallbackEnabled", deliveryCallbackEnabled.toString());

        }
    }
}
