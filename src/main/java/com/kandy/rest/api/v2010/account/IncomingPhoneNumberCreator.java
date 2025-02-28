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

public class IncomingPhoneNumberCreator extends Creator<IncomingPhoneNumber> {
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
    private IncomingPhoneNumber.EmergencyStatus emergencyStatus;
    private String emergencyAddressSid;
    private String trunkSid;
    private String identitySid;
    private String addressSid;
    private IncomingPhoneNumber.VoiceReceiveMode voiceReceiveMode;
    private String bundleSid;
    private com.kandy.type.PhoneNumber phoneNumber;
    private String areaCode;

    public IncomingPhoneNumberCreator(final com.kandy.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public IncomingPhoneNumberCreator(final String pathAccountSid, final com.kandy.type.PhoneNumber phoneNumber) {
        this.pathAccountSid = pathAccountSid;
        this.phoneNumber = phoneNumber;
    }

    public IncomingPhoneNumberCreator(final String areaCode) {
        this.areaCode = areaCode;
    }

    public IncomingPhoneNumberCreator(final String pathAccountSid, final String areaCode) {
        this.pathAccountSid = pathAccountSid;
        this.areaCode = areaCode;
    }

    public IncomingPhoneNumberCreator setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public IncomingPhoneNumberCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public IncomingPhoneNumberCreator setSmsApplicationSid(final String smsApplicationSid) {
        this.smsApplicationSid = smsApplicationSid;
        return this;
    }

    public IncomingPhoneNumberCreator setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    public IncomingPhoneNumberCreator setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public IncomingPhoneNumberCreator setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    public IncomingPhoneNumberCreator setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    public IncomingPhoneNumberCreator setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    public IncomingPhoneNumberCreator setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    public IncomingPhoneNumberCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public IncomingPhoneNumberCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    public IncomingPhoneNumberCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceApplicationSid(final String voiceApplicationSid) {
        this.voiceApplicationSid = voiceApplicationSid;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    public IncomingPhoneNumberCreator setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    public IncomingPhoneNumberCreator setEmergencyStatus(final IncomingPhoneNumber.EmergencyStatus emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
        return this;
    }

    public IncomingPhoneNumberCreator setEmergencyAddressSid(final String emergencyAddressSid) {
        this.emergencyAddressSid = emergencyAddressSid;
        return this;
    }

    public IncomingPhoneNumberCreator setTrunkSid(final String trunkSid) {
        this.trunkSid = trunkSid;
        return this;
    }

    public IncomingPhoneNumberCreator setIdentitySid(final String identitySid) {
        this.identitySid = identitySid;
        return this;
    }

    public IncomingPhoneNumberCreator setAddressSid(final String addressSid) {
        this.addressSid = addressSid;
        return this;
    }

    public IncomingPhoneNumberCreator setVoiceReceiveMode(final IncomingPhoneNumber.VoiceReceiveMode voiceReceiveMode) {
        this.voiceReceiveMode = voiceReceiveMode;
        return this;
    }

    public IncomingPhoneNumberCreator setBundleSid(final String bundleSid) {
        this.bundleSid = bundleSid;
        return this;
    }

    public IncomingPhoneNumberCreator setPhoneNumber(final com.kandy.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public IncomingPhoneNumberCreator setPhoneNumber(final String phoneNumber) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    public IncomingPhoneNumberCreator setAreaCode(final String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    @Override
    public IncomingPhoneNumber create(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/IncomingPhoneNumbers.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("IncomingPhoneNumber creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IncomingPhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
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
        if (emergencyStatus != null) {
            request.addPostParam("EmergencyStatus", emergencyStatus.toString());

        }
        if (emergencyAddressSid != null) {
            request.addPostParam("EmergencyAddressSid", emergencyAddressSid);

        }
        if (trunkSid != null) {
            request.addPostParam("TrunkSid", trunkSid);

        }
        if (identitySid != null) {
            request.addPostParam("IdentitySid", identitySid);

        }
        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);

        }
        if (voiceReceiveMode != null) {
            request.addPostParam("VoiceReceiveMode", voiceReceiveMode.toString());

        }
        if (bundleSid != null) {
            request.addPostParam("BundleSid", bundleSid);

        }
        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());

        }
        if (areaCode != null) {
            request.addPostParam("AreaCode", areaCode);

        }
    }
}
