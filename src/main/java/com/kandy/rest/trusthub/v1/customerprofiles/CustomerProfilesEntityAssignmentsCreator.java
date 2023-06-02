/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trusthub
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trusthub.v1.customerprofiles;

import com.kandy.base.Creator;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

public class CustomerProfilesEntityAssignmentsCreator extends Creator<CustomerProfilesEntityAssignments> {
    private String pathCustomerProfileSid;
    private String objectSid;

    public CustomerProfilesEntityAssignmentsCreator(final String pathCustomerProfileSid, final String objectSid) {
        this.pathCustomerProfileSid = pathCustomerProfileSid;
        this.objectSid = objectSid;
    }

    public CustomerProfilesEntityAssignmentsCreator setObjectSid(final String objectSid) {
        this.objectSid = objectSid;
        return this;
    }

    @Override
    public CustomerProfilesEntityAssignments create(final KandyRestClient client) {
        String path = "/v1/CustomerProfiles/{CustomerProfileSid}/EntityAssignments";

        path = path.replace("{" + "CustomerProfileSid" + "}", this.pathCustomerProfileSid.toString());
        path = path.replace("{" + "ObjectSid" + "}", this.objectSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.TRUSTHUB.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                    "CustomerProfilesEntityAssignments creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return CustomerProfilesEntityAssignments.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (objectSid != null) {
            request.addPostParam("ObjectSid", objectSid);

        }
    }
}
