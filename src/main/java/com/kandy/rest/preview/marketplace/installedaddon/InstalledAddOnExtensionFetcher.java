/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Preview
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.preview.marketplace.installedaddon;

import com.kandy.base.Fetcher;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class InstalledAddOnExtensionFetcher extends Fetcher<InstalledAddOnExtension> {
    private String pathInstalledAddOnSid;
    private String pathSid;

    public InstalledAddOnExtensionFetcher(final String pathInstalledAddOnSid, final String pathSid) {
        this.pathInstalledAddOnSid = pathInstalledAddOnSid;
        this.pathSid = pathSid;
    }

    @Override
    public InstalledAddOnExtension fetch(final KandyRestClient client) {
        String path = "/marketplace/InstalledAddOns/{InstalledAddOnSid}/Extensions/{Sid}";

        path = path.replace("{" + "InstalledAddOnSid" + "}", this.pathInstalledAddOnSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.PREVIEW.toString(),
                path);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("InstalledAddOnExtension fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InstalledAddOnExtension.fromJson(response.getStream(), client.getObjectMapper());
    }
}
