/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Verify
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.verify.v2.service.entity;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.util.List;
import java.util.Map;
import com.kandy.converter.Converter;
import java.time.ZonedDateTime;

import java.util.List;
import java.util.Map;

public class ChallengeCreator extends Creator<Challenge> {
    private String pathServiceSid;
    private String pathIdentity;
    private String factorSid;
    private ZonedDateTime expirationDate;
    private String detailsMessage;
    private List<Map<String, Object>> detailsFields;
    private Map<String, Object> hiddenDetails;
    private String authPayload;

    public ChallengeCreator(final String pathServiceSid, final String pathIdentity, final String factorSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.factorSid = factorSid;
    }

    public ChallengeCreator setFactorSid(final String factorSid) {
        this.factorSid = factorSid;
        return this;
    }

    public ChallengeCreator setExpirationDate(final ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public ChallengeCreator setDetailsMessage(final String detailsMessage) {
        this.detailsMessage = detailsMessage;
        return this;
    }

    public ChallengeCreator setDetailsFields(final List<Map<String, Object>> detailsFields) {
        this.detailsFields = detailsFields;
        return this;
    }

    public ChallengeCreator setDetailsFields(final Map<String, Object> detailsFields) {
        return setDetailsFields(Promoter.listOfOne(detailsFields));
    }

    public ChallengeCreator setHiddenDetails(final Map<String, Object> hiddenDetails) {
        this.hiddenDetails = hiddenDetails;
        return this;
    }

    public ChallengeCreator setAuthPayload(final String authPayload) {
        this.authPayload = authPayload;
        return this;
    }

    @Override
    public Challenge create(final KandyRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Entities/{Identity}/Challenges";

        path = path.replace("{" + "ServiceSid" + "}", this.pathServiceSid.toString());
        path = path.replace("{" + "Identity" + "}", this.pathIdentity.toString());
        path = path.replace("{" + "FactorSid" + "}", this.factorSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VERIFY.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Challenge creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Challenge.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (factorSid != null) {
            request.addPostParam("FactorSid", factorSid);

        }
        if (expirationDate != null) {
            request.addPostParam("ExpirationDate", expirationDate.toInstant().toString());

        }
        if (detailsMessage != null) {
            request.addPostParam("Details.Message", detailsMessage);

        }
        if (detailsFields != null) {
            for (Map<String, Object> prop : detailsFields) {
                request.addPostParam("Details.Fields", Converter.mapToJson(prop));
            }

        }
        if (hiddenDetails != null) {
            request.addPostParam("HiddenDetails", Converter.mapToJson(hiddenDetails));

        }
        if (authPayload != null) {
            request.addPostParam("AuthPayload", authPayload);

        }
    }
}
