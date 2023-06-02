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

package com.kandy.rest.api.v2010.account.queue;

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

public class MemberUpdater extends Updater<Member> {
    private String pathQueueSid;
    private String pathCallSid;
    private URI url;
    private String pathAccountSid;
    private HttpMethod method;

    public MemberUpdater(final String pathQueueSid, final String pathCallSid, final URI url) {
        this.pathQueueSid = pathQueueSid;
        this.pathCallSid = pathCallSid;
        this.url = url;
    }

    public MemberUpdater(final String pathAccountSid, final String pathQueueSid, final String pathCallSid,
            final URI url) {
        this.pathAccountSid = pathAccountSid;
        this.pathQueueSid = pathQueueSid;
        this.pathCallSid = pathCallSid;
        this.url = url;
    }

    public MemberUpdater setUrl(final URI url) {
        this.url = url;
        return this;
    }

    public MemberUpdater setUrl(final String url) {
        return setUrl(Promoter.uriFromString(url));
    }

    public MemberUpdater setMethod(final HttpMethod method) {
        this.method = method;
        return this;
    }

    @Override
    public Member update(final TwilioRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Queues/{QueueSid}/Members/{CallSid}.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "QueueSid" + "}", this.pathQueueSid.toString());
        path = path.replace("{" + "CallSid" + "}", this.pathCallSid.toString());
        path = path.replace("{" + "Url" + "}", this.url.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Member update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Member.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (url != null) {
            request.addPostParam("Url", url.toString());

        }
        if (method != null) {
            request.addPostParam("Method", method.toString());

        }
    }
}
