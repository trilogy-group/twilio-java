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

package com.kandy.rest.preview.marketplace;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.util.Map;
import com.kandy.converter.Converter;

import java.util.Map;

public class InstalledAddOnCreator extends Creator<InstalledAddOn> {
    private String availableAddOnSid;
    private Boolean acceptTermsOfService;
    private Map<String, Object> configuration;
    private String uniqueName;

    public InstalledAddOnCreator(final String availableAddOnSid, final Boolean acceptTermsOfService) {
        this.availableAddOnSid = availableAddOnSid;
        this.acceptTermsOfService = acceptTermsOfService;
    }

    public InstalledAddOnCreator setAvailableAddOnSid(final String availableAddOnSid) {
        this.availableAddOnSid = availableAddOnSid;
        return this;
    }

    public InstalledAddOnCreator setAcceptTermsOfService(final Boolean acceptTermsOfService) {
        this.acceptTermsOfService = acceptTermsOfService;
        return this;
    }

    public InstalledAddOnCreator setConfiguration(final Map<String, Object> configuration) {
        this.configuration = configuration;
        return this;
    }

    public InstalledAddOnCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    @Override
    public InstalledAddOn create(final KandyRestClient client) {
        String path = "/marketplace/InstalledAddOns";

        path = path.replace("{" + "AvailableAddOnSid" + "}", this.availableAddOnSid.toString());
        path = path.replace("{" + "AcceptTermsOfService" + "}", this.acceptTermsOfService.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.PREVIEW.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("InstalledAddOn creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InstalledAddOn.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (availableAddOnSid != null) {
            request.addPostParam("AvailableAddOnSid", availableAddOnSid);

        }
        if (acceptTermsOfService != null) {
            request.addPostParam("AcceptTermsOfService", acceptTermsOfService.toString());

        }
        if (configuration != null) {
            request.addPostParam("Configuration", Converter.mapToJson(configuration));

        }
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);

        }
    }
}
