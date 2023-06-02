/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Flex
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.flexapi.v1;

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.util.List;

import java.util.List;

public class InsightsQuestionnairesCreator extends Creator<InsightsQuestionnaires> {
    private String name;
    private String authorization;
    private String description;
    private Boolean active;
    private List<String> questionSids;

    public InsightsQuestionnairesCreator(final String name) {
        this.name = name;
    }

    public InsightsQuestionnairesCreator setName(final String name) {
        this.name = name;
        return this;
    }

    public InsightsQuestionnairesCreator setAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }

    public InsightsQuestionnairesCreator setDescription(final String description) {
        this.description = description;
        return this;
    }

    public InsightsQuestionnairesCreator setActive(final Boolean active) {
        this.active = active;
        return this;
    }

    public InsightsQuestionnairesCreator setQuestionSids(final List<String> questionSids) {
        this.questionSids = questionSids;
        return this;
    }

    public InsightsQuestionnairesCreator setQuestionSids(final String questionSids) {
        return setQuestionSids(Promoter.listOfOne(questionSids));
    }

    @Override
    public InsightsQuestionnaires create(final KandyRestClient client) {
        String path = "/v1/Insights/QualityManagement/Questionnaires";

        path = path.replace("{" + "Name" + "}", this.name.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("InsightsQuestionnaires creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InsightsQuestionnaires.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (name != null) {
            request.addPostParam("Name", name);

        }
        if (description != null) {
            request.addPostParam("Description", description);

        }
        if (active != null) {
            request.addPostParam("Active", active.toString());

        }
        if (questionSids != null) {
            for (String prop : questionSids) {
                request.addPostParam("QuestionSids", prop);
            }

        }
    }

    private void addHeaderParams(final Request request) {
        if (authorization != null) {
            request.addHeaderParam("Authorization", authorization);

        }
    }
}
