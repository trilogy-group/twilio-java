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

package com.kandy.rest.api.v2010.account.incomingphonenumber;

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

public class LocalCreator extends Creator<Local> {
    private com.kandy.type.PhoneNumber phoneNumber;
    private String pathAccountSid;
    private String apiVersion;
    private String friendlyName;
    private String smsApplicationSid;
    private HttpMethod smsFallbackMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsMethod;
    private URI smsUrl;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private String voiceApplicationSid;
    private Boolean voiceCallerIdLookup;
    private HttpMethod voiceFallbackMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceMethod;
    private URI voiceUrl;
    private String identitySid;
    private String addressSid;
    private Local.EmergencyStatus emergencyStatus;
    private String emergencyAddressSid;
    private String trunkSid;
    private Local.VoiceReceiveMode voiceReceiveMode;
    private String bundleSid;

    public LocalCreator(final com.kandy.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalCreator(final String pathAccountSid, final com.kandy.type.PhoneNumber phoneNumber) {
        this.pathAccountSid = pathAccountSid;
        this.phoneNumber = phoneNumber;
    }

    public LocalCreator setPhoneNumber(final com.kandy.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public LocalCreator setPhoneNumber(final String phoneNumber) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    public LocalCreator setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public LocalCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public LocalCreator setSmsApplicationSid(final String smsApplicationSid) {
        this.smsApplicationSid = smsApplicationSid;
        return this;
    }

    public LocalCreator setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    public LocalCreator setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public LocalCreator setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    public LocalCreator setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    public LocalCreator setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    public LocalCreator setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    public LocalCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public LocalCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    public LocalCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public LocalCreator setVoiceApplicationSid(final String voiceApplicationSid) {
        this.voiceApplicationSid = voiceApplicationSid;
        return this;
    }

    public LocalCreator setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    public LocalCreator setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public LocalCreator setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public LocalCreator setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    public LocalCreator setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public LocalCreator setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public LocalCreator setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    public LocalCreator setIdentitySid(final String identitySid) {
        this.identitySid = identitySid;
        return this;
    }

    public LocalCreator setAddressSid(final String addressSid) {
        this.addressSid = addressSid;
        return this;
    }

    public LocalCreator setEmergencyStatus(final Local.EmergencyStatus emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
        return this;
    }

    public LocalCreator setEmergencyAddressSid(final String emergencyAddressSid) {
        this.emergencyAddressSid = emergencyAddressSid;
        return this;
    }

    public LocalCreator setTrunkSid(final String trunkSid) {
        this.trunkSid = trunkSid;
        return this;
    }

    public LocalCreator setVoiceReceiveMode(final Local.VoiceReceiveMode voiceReceiveMode) {
        this.voiceReceiveMode = voiceReceiveMode;
        return this;
    }

    public LocalCreator setBundleSid(final String bundleSid) {
        this.bundleSid = bundleSid;
        return this;
    }

    @Override
    public Local create(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/IncomingPhoneNumbers/Local.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "PhoneNumber" + "}", this.phoneNumber.encode("utf-8"));

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Local creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Local.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());

        }
        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (smsApplicationSid != null) {
            request.addPostParam("SmsApplicationSid", smsApplicationSid);

        }
        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());

        }
        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());

        }
        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());

        }
        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());

        }
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());

        }
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());

        }
        if (voiceApplicationSid != null) {
            request.addPostParam("VoiceApplicationSid", voiceApplicationSid);

        }
        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());

        }
        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());

        }
        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());

        }
        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());

        }
        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());

        }
        if (identitySid != null) {
            request.addPostParam("IdentitySid", identitySid);

        }
        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);

        }
        if (emergencyStatus != null) {
            request.addPostParam("EmergencyStatus", emergencyStatus.toString());

        }
        if (emergencyAddressSid != null) {
            request.addPostParam("EmergencyAddressSid", emergencyAddressSid);

        }
        if (trunkSid != null) {
            request.addPostParam("TrunkSid", trunkSid);

        }
        if (voiceReceiveMode != null) {
            request.addPostParam("VoiceReceiveMode", voiceReceiveMode.toString());

        }
        if (bundleSid != null) {
            request.addPostParam("BundleSid", bundleSid);

        }
    }
}
