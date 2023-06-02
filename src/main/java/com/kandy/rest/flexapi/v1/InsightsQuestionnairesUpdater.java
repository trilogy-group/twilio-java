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

import com.kandy.base.Updater;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.twilio.rest.Domains;

import java.util.List;

public class InsightsQuestionnairesUpdater extends Updater<InsightsQuestionnaires> {
    private String pathQuestionnaireSid;
    private Boolean active;
    private String authorization;
    private String name;
    private String description;
    private List<String> questionSids;

    public InsightsQuestionnairesUpdater(final String pathQuestionnaireSid, final Boolean active) {
        this.pathQuestionnaireSid = pathQuestionnaireSid;
        this.active = active;
    }

    public InsightsQuestionnairesUpdater setActive(final Boolean active) {
        this.active = active;
        return this;
    }

    public InsightsQuestionnairesUpdater setAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }

    public InsightsQuestionnairesUpdater setName(final String name) {
        this.name = name;
        return this;
    }

    public InsightsQuestionnairesUpdater setDescription(final String description) {
        this.description = description;
        return this;
    }

    public InsightsQuestionnairesUpdater setQuestionSids(final List<String> questionSids) {
        this.questionSids = questionSids;
        return this;
    }

    public InsightsQuestionnairesUpdater setQuestionSids(final String questionSids) {
        return setQuestionSids(Promoter.listOfOne(questionSids));
    }

    @Override
    public InsightsQuestionnaires update(final KandyRestClient client) {
        String path = "/v1/Insights/QualityManagement/Questionnaires/{QuestionnaireSid}";

        path = path.replace("{" + "QuestionnaireSid" + "}", this.pathQuestionnaireSid.toString());
        path = path.replace("{" + "Active" + "}", this.active.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("InsightsQuestionnaires update failed: Unable to connect to server");
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
        if (active != null) {
            request.addPostParam("Active", active.toString());

        }
        if (name != null) {
            request.addPostParam("Name", name);

        }
        if (description != null) {
            request.addPostParam("Description", description);

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
