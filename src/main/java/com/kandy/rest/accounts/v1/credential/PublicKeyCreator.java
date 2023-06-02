/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Accounts
 * This is the public Kandy REST API.
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
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class PublicKeyCreator extends Creator<PublicKey> {
    private String publicKey;
    private String friendlyName;
    private String accountSid;

    public PublicKeyCreator(final String publicKey) {
        this.publicKey = publicKey;
    }

    public PublicKeyCreator setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public PublicKeyCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public PublicKeyCreator setAccountSid(final String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    @Override
    public PublicKey create(final KandyRestClient client) {
        String path = "/v1/Credentials/PublicKeys";

        path = path.replace("{" + "PublicKey" + "}", this.publicKey.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.ACCOUNTS.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("PublicKey creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return PublicKey.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (publicKey != null) {
            request.addPostParam("PublicKey", publicKey);

        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (accountSid != null) {
            request.addPostParam("AccountSid", accountSid);

        }
    }
}
