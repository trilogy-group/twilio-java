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

package com.kandy.rest.preview.hostedNumbers.authorizationdocument;

import com.kandy.base.Reader;
import com.kandy.base.ResourceSet;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;
import com.kandy.base.Page;

public class DependentHostedNumberOrderReader extends Reader<DependentHostedNumberOrder> {
    private String pathSigningDocumentSid;
    private DependentHostedNumberOrder.Status status;
    private com.kandy.type.PhoneNumber phoneNumber;
    private String incomingPhoneNumberSid;
    private String friendlyName;
    private String uniqueName;
    private Integer pageSize;

    public DependentHostedNumberOrderReader(final String pathSigningDocumentSid) {
        this.pathSigningDocumentSid = pathSigningDocumentSid;
    }

    public DependentHostedNumberOrderReader setStatus(final DependentHostedNumberOrder.Status status) {
        this.status = status;
        return this;
    }

    public DependentHostedNumberOrderReader setPhoneNumber(final com.kandy.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public DependentHostedNumberOrderReader setPhoneNumber(final String phoneNumber) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    public DependentHostedNumberOrderReader setIncomingPhoneNumberSid(final String incomingPhoneNumberSid) {
        this.incomingPhoneNumberSid = incomingPhoneNumberSid;
        return this;
    }

    public DependentHostedNumberOrderReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public DependentHostedNumberOrderReader setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    public DependentHostedNumberOrderReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<DependentHostedNumberOrder> read(final KandyRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<DependentHostedNumberOrder> firstPage(final KandyRestClient client) {
        String path = "/HostedNumbers/AuthorizationDocuments/{SigningDocumentSid}/DependentHostedNumberOrders";
        path = path.replace("{" + "SigningDocumentSid" + "}", this.pathSigningDocumentSid.toString());

        Request request = new Request(
                HttpMethod.GET,
                Domains.PREVIEW.toString(),
                path);

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<DependentHostedNumberOrder> pageForRequest(final KandyRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("DependentHostedNumberOrder read failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
                "items",
                response.getContent(),
                DependentHostedNumberOrder.class,
                client.getObjectMapper());
    }

    @Override
    public Page<DependentHostedNumberOrder> previousPage(final Page<DependentHostedNumberOrder> page,
            final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getPreviousPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<DependentHostedNumberOrder> nextPage(final Page<DependentHostedNumberOrder> page,
            final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                page.getNextPageUrl(Domains.PREVIEW.toString()));
        return pageForRequest(client, request);
    }

    @Override
    public Page<DependentHostedNumberOrder> getPage(final String targetUrl, final KandyRestClient client) {
        Request request = new Request(
                HttpMethod.GET,
                targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (status != null) {

            request.addQueryParam("Status", status.toString());
        }
        if (phoneNumber != null) {

            request.addQueryParam("PhoneNumber", phoneNumber.toString());
        }
        if (incomingPhoneNumberSid != null) {

            request.addQueryParam("IncomingPhoneNumberSid", incomingPhoneNumberSid);
        }
        if (friendlyName != null) {

            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (uniqueName != null) {

            request.addQueryParam("UniqueName", uniqueName);
        }
        if (pageSize != null) {

            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
