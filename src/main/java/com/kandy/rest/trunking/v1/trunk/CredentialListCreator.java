/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trunking
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trunking.v1.trunk;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class CredentialListCreator extends Creator<CredentialList> {
    private String pathTrunkSid;
    private String credentialListSid;

    public CredentialListCreator(final String pathTrunkSid, final String credentialListSid) {
        this.pathTrunkSid = pathTrunkSid;
        this.credentialListSid = credentialListSid;
    }

    public CredentialListCreator setCredentialListSid(final String credentialListSid) {
        this.credentialListSid = credentialListSid;
        return this;
    }

    @Override
    public CredentialList create(final KandyRestClient client) {
        String path = "/v1/Trunks/{TrunkSid}/CredentialLists";

        path = path.replace("{" + "TrunkSid" + "}", this.pathTrunkSid.toString());
        path = path.replace("{" + "CredentialListSid" + "}", this.credentialListSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TRUNKING.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("CredentialList creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return CredentialList.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (credentialListSid != null) {
            request.addPostParam("CredentialListSid", credentialListSid);

        }
    }
}
