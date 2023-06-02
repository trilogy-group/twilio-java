/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Api
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account.usage.record;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import com.kandy.base.Page;
import java.time.LocalDate;
import com.kandy.converter.DateConverter;

public class YesterdayReader extends Reader<Yesterday> {
    private String pathAccountSid;
    private Yesterday.Category category;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean includeSubaccounts;
    private Integer pageSize;

    public YesterdayReader() {
    }

    public YesterdayReader(final String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    public YesterdayReader setCategory(final Yesterday.Category category) {
        this.category = category;
        return this;
    }

    public YesterdayReader setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public YesterdayReader setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public YesterdayReader setIncludeSubaccounts(final Boolean includeSubaccounts) {
        this.includeSubaccounts = includeSubaccounts;
        return this;
    }

    public YesterdayReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Yesterday> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Yesterday> firstPage(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Usage/Records/Yesterday.json";
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.API.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Yesterday> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Yesterday read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "usage_records",
                response.getContent(),
                Yesterday.class,
                client.getObjectMapper());
    }

    @Override
    public Page<Yesterday> previousPage(final Page<Yesterday> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Yesterday> nextPage(final Page<Yesterday> page, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.API.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<Yesterday> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (category != null) {

            request.addQueryParam("Category", category.toString());
        }
        if (startDate != null) {
            request.addQueryParam("StartDate", DateConverter.dateStringFromLocalDate(startDate));
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", DateConverter.dateStringFromLocalDate(endDate));
        }

        if (includeSubaccounts != null) {

            request.addQueryParam("IncludeSubaccounts", includeSubaccounts.toString());
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
