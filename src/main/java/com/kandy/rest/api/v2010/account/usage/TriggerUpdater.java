/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account.usage;

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

import java.net.URI;

public class TriggerUpdater extends Updater<Trigger> {
    private String pathSid;
    private String pathAccountSid;
    private HttpMethod callbackMethod;
    private URI callbackUrl;
    private String friendlyName;

    public TriggerUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public TriggerUpdater(final String pathAccountSid, final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    public TriggerUpdater setCallbackMethod(final HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    public TriggerUpdater setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public TriggerUpdater setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    public TriggerUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    @Override
    public Trigger update(final TwilioRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Usage/Triggers/{Sid}.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Trigger update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Trigger.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod.toString());

        }
        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
    }
}
