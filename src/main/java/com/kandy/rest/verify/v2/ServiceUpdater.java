/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.verify.v2;

import com.kandy.base.Updater;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class ServiceUpdater extends Updater<Service> {
    private String pathSid;
    private String friendlyName;
    private Integer codeLength;
    private Boolean lookupEnabled;
    private Boolean skipSmsToLandlines;
    private Boolean dtmfInputRequired;
    private String ttsName;
    private Boolean psd2Enabled;
    private Boolean doNotShareWarningEnabled;
    private Boolean customCodeEnabled;
    private Boolean pushIncludeDate;
    private String pushApnCredentialSid;
    private String pushFcmCredentialSid;
    private String totpIssuer;
    private Integer totpTimeStep;
    private Integer totpCodeLength;
    private Integer totpSkew;
    private String defaultTemplateSid;

    public ServiceUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public ServiceUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ServiceUpdater setCodeLength(final Integer codeLength) {
        this.codeLength = codeLength;
        return this;
    }

    public ServiceUpdater setLookupEnabled(final Boolean lookupEnabled) {
        this.lookupEnabled = lookupEnabled;
        return this;
    }

    public ServiceUpdater setSkipSmsToLandlines(final Boolean skipSmsToLandlines) {
        this.skipSmsToLandlines = skipSmsToLandlines;
        return this;
    }

    public ServiceUpdater setDtmfInputRequired(final Boolean dtmfInputRequired) {
        this.dtmfInputRequired = dtmfInputRequired;
        return this;
    }

    public ServiceUpdater setTtsName(final String ttsName) {
        this.ttsName = ttsName;
        return this;
    }

    public ServiceUpdater setPsd2Enabled(final Boolean psd2Enabled) {
        this.psd2Enabled = psd2Enabled;
        return this;
    }

    public ServiceUpdater setDoNotShareWarningEnabled(final Boolean doNotShareWarningEnabled) {
        this.doNotShareWarningEnabled = doNotShareWarningEnabled;
        return this;
    }

    public ServiceUpdater setCustomCodeEnabled(final Boolean customCodeEnabled) {
        this.customCodeEnabled = customCodeEnabled;
        return this;
    }

    public ServiceUpdater setPushIncludeDate(final Boolean pushIncludeDate) {
        this.pushIncludeDate = pushIncludeDate;
        return this;
    }

    public ServiceUpdater setPushApnCredentialSid(final String pushApnCredentialSid) {
        this.pushApnCredentialSid = pushApnCredentialSid;
        return this;
    }

    public ServiceUpdater setPushFcmCredentialSid(final String pushFcmCredentialSid) {
        this.pushFcmCredentialSid = pushFcmCredentialSid;
        return this;
    }

    public ServiceUpdater setTotpIssuer(final String totpIssuer) {
        this.totpIssuer = totpIssuer;
        return this;
    }

    public ServiceUpdater setTotpTimeStep(final Integer totpTimeStep) {
        this.totpTimeStep = totpTimeStep;
        return this;
    }

    public ServiceUpdater setTotpCodeLength(final Integer totpCodeLength) {
        this.totpCodeLength = totpCodeLength;
        return this;
    }

    public ServiceUpdater setTotpSkew(final Integer totpSkew) {
        this.totpSkew = totpSkew;
        return this;
    }

    public ServiceUpdater setDefaultTemplateSid(final String defaultTemplateSid) {
        this.defaultTemplateSid = defaultTemplateSid;
        return this;
    }

    @Override
    public Service update(final TwilioRestClient client) {
        String path = "/v2/Services/{Sid}";

        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VERIFY.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Service update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
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
        if (codeLength != null) {
            request.addPostParam("CodeLength", codeLength.toString());

        }
        if (lookupEnabled != null) {
            request.addPostParam("LookupEnabled", lookupEnabled.toString());

        }
        if (skipSmsToLandlines != null) {
            request.addPostParam("SkipSmsToLandlines", skipSmsToLandlines.toString());

        }
        if (dtmfInputRequired != null) {
            request.addPostParam("DtmfInputRequired", dtmfInputRequired.toString());

        }
        if (ttsName != null) {
            request.addPostParam("TtsName", ttsName);

        }
        if (psd2Enabled != null) {
            request.addPostParam("Psd2Enabled", psd2Enabled.toString());

        }
        if (doNotShareWarningEnabled != null) {
            request.addPostParam("DoNotShareWarningEnabled", doNotShareWarningEnabled.toString());

        }
        if (customCodeEnabled != null) {
            request.addPostParam("CustomCodeEnabled", customCodeEnabled.toString());

        }
        if (pushIncludeDate != null) {
            request.addPostParam("Push.IncludeDate", pushIncludeDate.toString());

        }
        if (pushApnCredentialSid != null) {
            request.addPostParam("Push.ApnCredentialSid", pushApnCredentialSid);

        }
        if (pushFcmCredentialSid != null) {
            request.addPostParam("Push.FcmCredentialSid", pushFcmCredentialSid);

        }
        if (totpIssuer != null) {
            request.addPostParam("Totp.Issuer", totpIssuer);

        }
        if (totpTimeStep != null) {
            request.addPostParam("Totp.TimeStep", totpTimeStep.toString());

        }
        if (totpCodeLength != null) {
            request.addPostParam("Totp.CodeLength", totpCodeLength.toString());

        }
        if (totpSkew != null) {
            request.addPostParam("Totp.Skew", totpSkew.toString());

        }
        if (defaultTemplateSid != null) {
            request.addPostParam("DefaultTemplateSid", defaultTemplateSid);

        }
    }
}
