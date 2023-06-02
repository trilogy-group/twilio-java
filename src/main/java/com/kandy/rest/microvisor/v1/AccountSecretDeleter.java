/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Microvisor
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.microvisor.v1;

import com.kandy.base.Deleter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class AccountSecretDeleter extends Deleter<AccountSecret> {
    private String pathKey;

    public AccountSecretDeleter(final String pathKey) {
        this.pathKey = pathKey;
    }

    @Override
    public boolean delete(final KandyRestClient client) {
        String path = "/v1/Secrets/{Key}";

        path = path.replace("{" + "Key" + "}", this.pathKey.toString());

        Request request = new Request(
                HttpMethod.DELETE,
                Domains.MICROVISOR.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AccountSecret delete failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
}
