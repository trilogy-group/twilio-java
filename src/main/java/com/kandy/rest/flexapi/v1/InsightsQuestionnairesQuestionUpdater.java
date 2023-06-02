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
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;

public class InsightsQuestionnairesQuestionUpdater extends Updater<InsightsQuestionnairesQuestion> {
    private String pathQuestionSid;
    private Boolean allowNa;
    private String authorization;
    private String categorySid;
    private String question;
    private String description;
    private String answerSetId;

    public InsightsQuestionnairesQuestionUpdater(final String pathQuestionSid, final Boolean allowNa) {
        this.pathQuestionSid = pathQuestionSid;
        this.allowNa = allowNa;
    }

    public InsightsQuestionnairesQuestionUpdater setAllowNa(final Boolean allowNa) {
        this.allowNa = allowNa;
        return this;
    }

    public InsightsQuestionnairesQuestionUpdater setAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }

    public InsightsQuestionnairesQuestionUpdater setCategorySid(final String categorySid) {
        this.categorySid = categorySid;
        return this;
    }

    public InsightsQuestionnairesQuestionUpdater setQuestion(final String question) {
        this.question = question;
        return this;
    }

    public InsightsQuestionnairesQuestionUpdater setDescription(final String description) {
        this.description = description;
        return this;
    }

    public InsightsQuestionnairesQuestionUpdater setAnswerSetId(final String answerSetId) {
        this.answerSetId = answerSetId;
        return this;
    }

    @Override
    public InsightsQuestionnairesQuestion update(final KandyRestClient client) {
        String path = "/v1/Insights/QualityManagement/Questions/{QuestionSid}";

        path = path.replace("{" + "QuestionSid" + "}", this.pathQuestionSid.toString());
        path = path.replace("{" + "AllowNa" + "}", this.allowNa.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                    "InsightsQuestionnairesQuestion update failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InsightsQuestionnairesQuestion.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (allowNa != null) {
            request.addPostParam("AllowNa", allowNa.toString());

        }
        if (categorySid != null) {
            request.addPostParam("CategorySid", categorySid);

        }
        if (question != null) {
            request.addPostParam("Question", question);

        }
        if (description != null) {
            request.addPostParam("Description", description);

        }
        if (answerSetId != null) {
            request.addPostParam("AnswerSetId", answerSetId);

        }
    }

    private void addHeaderParams(final Request request) {
        if (authorization != null) {
            request.addHeaderParam("Authorization", authorization);

        }
    }
}
