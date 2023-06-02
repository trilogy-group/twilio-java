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

package com.kandy.rest.api.v2010.account.call;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import java.time.LocalDate;
import java.net.URI;
import com.kandy.converter.DateConverter;

import java.net.URI;

public class FeedbackSummaryCreator extends Creator<FeedbackSummary> {
    private LocalDate startDate;
    private LocalDate endDate;
    private String pathAccountSid;
    private Boolean includeSubaccounts;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;

    public FeedbackSummaryCreator(final LocalDate startDate, final LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public FeedbackSummaryCreator(final String pathAccountSid, final LocalDate startDate, final LocalDate endDate) {
        this.pathAccountSid = pathAccountSid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public FeedbackSummaryCreator setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public FeedbackSummaryCreator setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public FeedbackSummaryCreator setIncludeSubaccounts(final Boolean includeSubaccounts) {
        this.includeSubaccounts = includeSubaccounts;
        return this;
    }

    public FeedbackSummaryCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public FeedbackSummaryCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    public FeedbackSummaryCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    @Override
    public FeedbackSummary create(final KandyRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/Calls/FeedbackSummary.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{" + "AccountSid" + "}", this.pathAccountSid.toString());
        path = path.replace("{" + "StartDate" + "}", this.startDate.toString());
        path = path.replace("{" + "EndDate" + "}", this.endDate.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.API.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("FeedbackSummary creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return FeedbackSummary.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (startDate != null) {
            request.addPostParam("StartDate", DateConverter.dateStringFromLocalDate(startDate));

        }
        if (endDate != null) {
            request.addPostParam("EndDate", DateConverter.dateStringFromLocalDate(endDate));

        }
        if (includeSubaccounts != null) {
            request.addPostParam("IncludeSubaccounts", includeSubaccounts.toString());

        }
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());

        }
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());

        }
    }
}
