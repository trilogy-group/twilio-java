/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Voice
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.voice.v1.dialingpermissions;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import com.kandy.base.Page;

public class CountryReader extends Reader<Country> {
    private String isoCode;
    private String continent;
    private String countryCode;
    private Boolean lowRiskNumbersEnabled;
    private Boolean highRiskSpecialNumbersEnabled;
    private Boolean highRiskTollfraudNumbersEnabled;
    private Integer pageSize;

    public CountryReader() {
    }

    public CountryReader setIsoCode(final String isoCode) {
        this.isoCode = isoCode;
        return this;
    }

    public CountryReader setContinent(final String continent) {
        this.continent = continent;
        return this;
    }

    public CountryReader setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public CountryReader setLowRiskNumbersEnabled(final Boolean lowRiskNumbersEnabled) {
        this.lowRiskNumbersEnabled = lowRiskNumbersEnabled;
        return this;
    }

    public CountryReader setHighRiskSpecialNumbersEnabled(final Boolean highRiskSpecialNumbersEnabled) {
        this.highRiskSpecialNumbersEnabled = highRiskSpecialNumbersEnabled;
        return this;
    }

    public CountryReader setHighRiskTollfraudNumbersEnabled(final Boolean highRiskTollfraudNumbersEnabled) {
        this.highRiskTollfraudNumbersEnabled = highRiskTollfraudNumbersEnabled;
        return this;
    }

    public CountryReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Country> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Country> firstPage(final KandyRestClient client) {
        String path = "/v1/DialingPermissions/Countries";

        Request request = new Request(
                HttpMethod.GET,
                Domains.VOICE.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Country> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Country read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "content",
                response.getContent(),
                Country.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Country> previousPage(final Page<Country> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.VOICE.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Country> nextPage(final Page<Country> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.VOICE.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Country> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (isoCode != null) {

            request.addQueryParam("IsoCode", isoCode);
        }
        if (continent != null) {

            request.addQueryParam("Continent", continent);
        }
        if (countryCode != null) {

            request.addQueryParam("CountryCode", countryCode);
        }
        if (lowRiskNumbersEnabled != null) {

            request.addQueryParam("LowRiskNumbersEnabled", lowRiskNumbersEnabled.toString());
        }
        if (highRiskSpecialNumbersEnabled != null) {

            request.addQueryParam("HighRiskSpecialNumbersEnabled", highRiskSpecialNumbersEnabled.toString());
        }
        if (highRiskTollfraudNumbersEnabled != null) {

            request.addQueryParam("HighRiskTollfraudNumbersEnabled", highRiskTollfraudNumbersEnabled.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
