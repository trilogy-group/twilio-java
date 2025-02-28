/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Api
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account;

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

public class ApplicationCreator extends Creator<Application> {
    private String pathAccountSid;
    private String apiVersion;
    private URI voiceUrl;
    private HttpMethod voiceMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private Boolean voiceCallerIdLookup;
    private URI smsUrl;
    private HttpMethod smsMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsFallbackMethod;
    private URI smsStatusCallback;
    private URI messageStatusCallback;
    private String friendlyName;
    private Boolean publicApplicationConnectEnabled;

    public ApplicationCreator() {
    }

    public ApplicationCreator(final String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    public ApplicationCreator setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public ApplicationCreator setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public ApplicationCreator setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    public ApplicationCreator setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public ApplicationCreator setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public ApplicationCreator setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    public ApplicationCreator setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public ApplicationCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public ApplicationCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    public ApplicationCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public ApplicationCreator setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    public ApplicationCreator setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    public ApplicationCreator setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    public ApplicationCreator setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    public ApplicationCreator setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public ApplicationCreator setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    public ApplicationCreator setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    public ApplicationCreator setSmsStatusCallback(final URI smsStatusCallback) {
        this.smsStatusCallback = smsStatusCallback;
        return this;
    }

    public ApplicationCreator setSmsStatusCallback(final String smsStatusCallback) {
        return setSmsStatusCallback(Promoter.uriFromString(smsStatusCallback));
    }

    public ApplicationCreator setMessageStatusCallback(final URI messageStatusCallback) {
        this.messageStatusCallback = messageStatusCallback;
        return this;
    }

    public ApplicationCreator setMessageStatusCallback(final String messageStatusCallback) {
        return setMessageStatusCallback(Promoter.uriFromString(messageStatusCallback));
    }

    public ApplicationCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ApplicationCreator setPublicApplicationConnectEnabled(final Boolean publicApplicationConnectEnabled) {
        this.publicApplicationConnectEnabled = publicApplicationConnectEnabled;
        return this;
    }

    @Override
    public Application create(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Applications.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Application creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Application.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);

        }
        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());

        }
        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());

        }
        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());

        }
        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());

        }
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());

        }
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());

        }
        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());

        }
        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());

        }
        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());

        }
        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());

        }
        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());

        }
        if (smsStatusCallback != null) {
            request.addPostParam("SmsStatusCallback", smsStatusCallback.toString());

        }
        if (messageStatusCallback != null) {
            request.addPostParam("MessageStatusCallback", messageStatusCallback.toString());

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (publicApplicationConnectEnabled != null) {
            request.addPostParam("PublicApplicationConnectEnabled", publicApplicationConnectEnabled.toString());

        }
    }
}
