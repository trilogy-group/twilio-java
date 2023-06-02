/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Lookups
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.lookups.v1;

import com.kandy.base.Fetcher;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.PrefixedCollapsibleMap;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

import java.util.List;
import java.util.Map;

public class PhoneNumberFetcher extends Fetcher<PhoneNumber> {
    private com.kandy.type.PhoneNumber pathPhoneNumber;
    private String countryCode;
    private List<String> type;
    private List<String> addOns;
    private Map<String, Object> addOnsData;

    public PhoneNumberFetcher(final com.kandy.type.PhoneNumber pathPhoneNumber) {
        this.pathPhoneNumber = pathPhoneNumber;
    }

    public PhoneNumberFetcher setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public PhoneNumberFetcher setType(final List<String> type) {
        this.type = type;
        return this;
    }

    public PhoneNumberFetcher setType(final String type) {
        return setType(Promoter.listOfOne(type));
    }

    public PhoneNumberFetcher setAddOns(final List<String> addOns) {
        this.addOns = addOns;
        return this;
    }

    public PhoneNumberFetcher setAddOns(final String addOns) {
        return setAddOns(Promoter.listOfOne(addOns));
    }

    public PhoneNumberFetcher setAddOnsData(final Map<String, Object> addOnsData) {
        this.addOnsData = addOnsData;
        return this;
    }

    @Override
    public PhoneNumber fetch(final KandyRestClient client) {
        String path = "/v1/PhoneNumbers/{PhoneNumber}";

        path = path.replace("{" + "PhoneNumber" + "}", this.pathPhoneNumber.encode("utf-8"));

        Request request = new Request(
                HttpMethod.GET,
                Domains.LOOKUPS.toString(),
                path);
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("PhoneNumber fetch failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return PhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addQueryParams(final Request request) {
        if (countryCode != null) {

            request.addQueryParam("CountryCode", countryCode);
        }
        if (type != null) {
            for (String prop : type) {
                request.addQueryParam("Type", prop);
            }
        }
        if (addOns != null) {
            for (String prop : addOns) {
                request.addQueryParam("AddOns", prop);
            }
        }
        if (addOnsData != null) {
            Map<String, String> params = PrefixedCollapsibleMap.serialize(addOnsData, "AddOns");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                request.addQueryParam(entry.getKey(), entry.getValue());
            }
        }
    }
}
