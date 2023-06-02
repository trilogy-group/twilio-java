/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Accounts
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.accounts.v1.credential;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class AwsCreator extends Creator<Aws> {
    private String credentials;
    private String friendlyName;
    private String accountSid;

    public AwsCreator(final String credentials) {
        this.credentials = credentials;
    }

    public AwsCreator setCredentials(final String credentials) {
        this.credentials = credentials;
        return this;
    }

    public AwsCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public AwsCreator setAccountSid(final String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    @Override
    public Aws create(final TwilioRestClient client) {
        String path = "/v1/Credentials/AWS";

        path = path.replace("{" + "Credentials" + "}", this.credentials.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.ACCOUNTS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Aws creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Aws.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (credentials != null) {
            request.addPostParam("Credentials", credentials);

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (accountSid != null) {
            request.addPostParam("AccountSid", accountSid);

        }
    }
}
