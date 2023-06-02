/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Supersim
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.supersim.v1.networkaccessprofile;

import com.kandy.base.Deleter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class NetworkAccessProfileNetworkDeleter extends Deleter<NetworkAccessProfileNetwork> {
    private String pathNetworkAccessProfileSid;
    private String pathSid;

    public NetworkAccessProfileNetworkDeleter(final String pathNetworkAccessProfileSid, final String pathSid) {
        this.pathNetworkAccessProfileSid = pathNetworkAccessProfileSid;
        this.pathSid = pathSid;
    }

    @Override
    public boolean delete(final TwilioRestClient client) {
        String path = "/v1/NetworkAccessProfiles/{NetworkAccessProfileSid}/Networks/{Sid}";

        path = path.replace("{" + "NetworkAccessProfileSid" + "}", this.pathNetworkAccessProfileSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.DELETE,
                Domains.SUPERSIM.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("NetworkAccessProfileNetwork delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
}
