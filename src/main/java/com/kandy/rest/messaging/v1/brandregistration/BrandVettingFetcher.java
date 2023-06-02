/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.messaging.v1.brandregistration;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.TwilioRestClient;
import com.kandy.rest.Domains;

public class BrandVettingFetcher extends Fetcher<BrandVetting> {
    private String pathBrandSid;
    private String pathBrandVettingSid;

    public BrandVettingFetcher(final String pathBrandSid, final String pathBrandVettingSid) {
        this.pathBrandSid = pathBrandSid;
        this.pathBrandVettingSid = pathBrandVettingSid;
    }

    @Override
    public BrandVetting fetch(final TwilioRestClient client) {
        String path = "/v1/a2p/BrandRegistrations/{BrandSid}/Vettings/{BrandVettingSid}";

        path = path.replace("{" + "BrandSid" + "}", this.pathBrandSid.toString());
        path = path.replace("{" + "BrandVettingSid" + "}", this.pathBrandVettingSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.MESSAGING.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("BrandVetting fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return BrandVetting.fromJson(response.getStream(), client.getObjectMapper());
    }
}
