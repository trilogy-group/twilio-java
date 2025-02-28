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

package com.kandy.rest.api.v2010.account.sip;

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

public class DomainCreator extends Creator<Domain> {
    private String domainName;
    private String pathAccountSid;
    private String friendlyName;
    private URI voiceUrl;
    private HttpMethod voiceMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private URI voiceStatusCallbackUrl;
    private HttpMethod voiceStatusCallbackMethod;
    private Boolean sipRegistration;
    private Boolean emergencyCallingEnabled;
    private Boolean secure;
    private String byocTrunkSid;
    private String emergencyCallerSid;

    public DomainCreator(final String domainName) {
        this.domainName = domainName;
    }

    public DomainCreator(final String pathAccountSid, final String domainName) {
        this.pathAccountSid = pathAccountSid;
        this.domainName = domainName;
    }

    public DomainCreator setDomainName(final String domainName) {
        this.domainName = domainName;
        return this;
    }

    public DomainCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public DomainCreator setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public DomainCreator setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    public DomainCreator setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public DomainCreator setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public DomainCreator setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    public DomainCreator setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public DomainCreator setVoiceStatusCallbackUrl(final URI voiceStatusCallbackUrl) {
        this.voiceStatusCallbackUrl = voiceStatusCallbackUrl;
        return this;
    }

    public DomainCreator setVoiceStatusCallbackUrl(final String voiceStatusCallbackUrl) {
        return setVoiceStatusCallbackUrl(Promoter.uriFromString(voiceStatusCallbackUrl));
    }

    public DomainCreator setVoiceStatusCallbackMethod(final HttpMethod voiceStatusCallbackMethod) {
        this.voiceStatusCallbackMethod = voiceStatusCallbackMethod;
        return this;
    }

    public DomainCreator setSipRegistration(final Boolean sipRegistration) {
        this.sipRegistration = sipRegistration;
        return this;
    }

    public DomainCreator setEmergencyCallingEnabled(final Boolean emergencyCallingEnabled) {
        this.emergencyCallingEnabled = emergencyCallingEnabled;
        return this;
    }

    public DomainCreator setSecure(final Boolean secure) {
        this.secure = secure;
        return this;
    }

    public DomainCreator setByocTrunkSid(final String byocTrunkSid) {
        this.byocTrunkSid = byocTrunkSid;
        return this;
    }

    public DomainCreator setEmergencyCallerSid(final String emergencyCallerSid) {
        this.emergencyCallerSid = emergencyCallerSid;
        return this;
    }

    @Override
    public Domain create(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/SIP/Domains.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "DomainName" + "}", this.domainName.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Domain creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Domain.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (domainName != null) {
            request.addPostParam("DomainName", domainName);

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

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
        if (voiceStatusCallbackUrl != null) {
            request.addPostParam("VoiceStatusCallbackUrl", voiceStatusCallbackUrl.toString());

        }
        if (voiceStatusCallbackMethod != null) {
            request.addPostParam("VoiceStatusCallbackMethod", voiceStatusCallbackMethod.toString());

        }
        if (sipRegistration != null) {
            request.addPostParam("SipRegistration", sipRegistration.toString());

        }
        if (emergencyCallingEnabled != null) {
            request.addPostParam("EmergencyCallingEnabled", emergencyCallingEnabled.toString());

        }
        if (secure != null) {
            request.addPostParam("Secure", secure.toString());

        }
        if (byocTrunkSid != null) {
            request.addPostParam("ByocTrunkSid", byocTrunkSid);

        }
        if (emergencyCallerSid != null) {
            request.addPostParam("EmergencyCallerSid", emergencyCallerSid);

        }
    }
}
