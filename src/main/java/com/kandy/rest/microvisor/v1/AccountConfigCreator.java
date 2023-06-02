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

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class AccountConfigCreator extends Creator<AccountConfig> {
    private String key;
    private String value;

    public AccountConfigCreator(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public AccountConfigCreator setKey(final String key) {
        this.key = key;
        return this;
    }

    public AccountConfigCreator setValue(final String value) {
        this.value = value;
        return this;
    }

    @Override
    public AccountConfig create(final KandyRestClient client) {
        String path = "/v1/Configs";

        path = path.replace("{" + "Key" + "}", this.key.toString());
        path = path.replace("{" + "Value" + "}", this.value.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.MICROVISOR.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("AccountConfig creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AccountConfig.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (key != null) {
            request.addPostParam("Key", key);

        }
        if (value != null) {
            request.addPostParam("Value", value);

        }
    }
}
