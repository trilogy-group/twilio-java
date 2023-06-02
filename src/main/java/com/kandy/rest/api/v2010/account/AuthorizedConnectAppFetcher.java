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

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class AuthorizedConnectAppFetcher extends Fetcher<AuthorizedConnectApp> {
    private String pathConnectAppSid;
    private String pathAccountSid;

    public AuthorizedConnectAppFetcher(final String pathConnectAppSid) {
        this.pathConnectAppSid = pathConnectAppSid;
    }

    public AuthorizedConnectAppFetcher(final String pathAccountSid, final String pathConnectAppSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathConnectAppSid = pathConnectAppSid;
    }

    @Override
    public AuthorizedConnectApp fetch(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/AuthorizedConnectApps/{ConnectAppSid}.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "ConnectAppSid" + "}", this.pathConnectAppSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.API.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AuthorizedConnectApp fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AuthorizedConnectApp.fromJson(response.getStream(), client.getObjectMapper());
    }
}
