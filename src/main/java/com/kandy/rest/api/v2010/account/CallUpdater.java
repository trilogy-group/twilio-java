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

import com.kandy.base.Updater;
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

public class CallUpdater extends Updater<Call> {
    private String pathSid;
    private String pathAccountSid;
    private URI url;
    private HttpMethod method;
    private Call.UpdateStatus status;
    private URI fallbackUrl;
    private HttpMethod fallbackMethod;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private com.kandy.type.Twiml twiml;
    private Integer timeLimit;

    public CallUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    public CallUpdater(final String pathAccountSid, final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    public CallUpdater setUrl(final URI url) {
        this.url = url;
        return this;
    }

    public CallUpdater setUrl(final String url) {
        return setUrl(Promoter.uriFromString(url));
    }

    public CallUpdater setMethod(final HttpMethod method) {
        this.method = method;
        return this;
    }

    public CallUpdater setStatus(final Call.UpdateStatus status) {
        this.status = status;
        return this;
    }

    public CallUpdater setFallbackUrl(final URI fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    public CallUpdater setFallbackUrl(final String fallbackUrl) {
        return setFallbackUrl(Promoter.uriFromString(fallbackUrl));
    }

    public CallUpdater setFallbackMethod(final HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    public CallUpdater setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public CallUpdater setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    public CallUpdater setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public CallUpdater setTwiml(final com.kandy.type.Twiml twiml) {
        this.twiml = twiml;
        return this;
    }

    public CallUpdater setTwiml(final String twiml) {
        return setTwiml(Promoter.twimlFromString(twiml));
    }

    public CallUpdater setTimeLimit(final Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    @Override
    public Call update(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Calls/{Sid}.json";

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
            throw new ApiConnectionException("Call update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Call.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (url != null) {
            request.addPostParam("Url", url.toString());

        }
        if (method != null) {
            request.addPostParam("Method", method.toString());

        }
        if (status != null) {
            request.addPostParam("Status", status.toString());

        }
        if (fallbackUrl != null) {
            request.addPostParam("FallbackUrl", fallbackUrl.toString());

        }
        if (fallbackMethod != null) {
            request.addPostParam("FallbackMethod", fallbackMethod.toString());

        }
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());

        }
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());

        }
        if (twiml != null) {
            request.addPostParam("Twiml", twiml.toString());

        }
        if (timeLimit != null) {
            request.addPostParam("TimeLimit", timeLimit.toString());

        }
    }
}
