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
import com.kandy.exception.ApiConnectionException;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.math.BigDecimal;
import java.math.BigDecimal;

public class AssessmentsCreator extends Creator<Assessments> {
    private String categorySid;
    private String categoryName;
    private String segmentId;
    private String agentId;
    private BigDecimal offset;
    private String metricId;
    private String metricName;
    private String answerText;
    private String answerId;
    private String questionnaireSid;
    private String authorization;

    public AssessmentsCreator(final String categorySid, final String categoryName, final String segmentId,
            final String agentId, final BigDecimal offset, final String metricId, final String metricName,
            final String answerText, final String answerId, final String questionnaireSid) {
        this.categorySid = categorySid;
        this.categoryName = categoryName;
        this.segmentId = segmentId;
        this.agentId = agentId;
        this.offset = offset;
        this.metricId = metricId;
        this.metricName = metricName;
        this.answerText = answerText;
        this.answerId = answerId;
        this.questionnaireSid = questionnaireSid;
    }

    public AssessmentsCreator setCategorySid(final String categorySid) {
        this.categorySid = categorySid;
        return this;
    }

    public AssessmentsCreator setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public AssessmentsCreator setSegmentId(final String segmentId) {
        this.segmentId = segmentId;
        return this;
    }

    public AssessmentsCreator setAgentId(final String agentId) {
        this.agentId = agentId;
        return this;
    }

    public AssessmentsCreator setOffset(final BigDecimal offset) {
        this.offset = offset;
        return this;
    }

    public AssessmentsCreator setMetricId(final String metricId) {
        this.metricId = metricId;
        return this;
    }

    public AssessmentsCreator setMetricName(final String metricName) {
        this.metricName = metricName;
        return this;
    }

    public AssessmentsCreator setAnswerText(final String answerText) {
        this.answerText = answerText;
        return this;
    }

    public AssessmentsCreator setAnswerId(final String answerId) {
        this.answerId = answerId;
        return this;
    }

    public AssessmentsCreator setQuestionnaireSid(final String questionnaireSid) {
        this.questionnaireSid = questionnaireSid;
        return this;
    }

    public AssessmentsCreator setAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }

    @Override
    public Assessments create(final KandyRestClient client) {
        String path = "/v1/Insights/QualityManagement/Assessments";

        path = path.replace("{" + "CategorySid" + "}", this.categorySid.toString());
        path = path.replace("{" + "CategoryName" + "}", this.categoryName.toString());
        path = path.replace("{" + "SegmentId" + "}", this.segmentId.toString());
        path = path.replace("{" + "AgentId" + "}", this.agentId.toString());
        path = path.replace("{" + "Offset" + "}", this.offset.toString());
        path = path.replace("{" + "MetricId" + "}", this.metricId.toString());
        path = path.replace("{" + "MetricName" + "}", this.metricName.toString());
        path = path.replace("{" + "AnswerText" + "}", this.answerText.toString());
        path = path.replace("{" + "AnswerId" + "}", this.answerId.toString());
        path = path.replace("{" + "QuestionnaireSid" + "}", this.questionnaireSid.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.FLEXAPI.toString(),
                path);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Assessments creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Assessments.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (categorySid != null) {
            request.addPostParam("CategorySid", categorySid);

        }
        if (categoryName != null) {
            request.addPostParam("CategoryName", categoryName);

        }
        if (segmentId != null) {
            request.addPostParam("SegmentId", segmentId);

        }
        if (agentId != null) {
            request.addPostParam("AgentId", agentId);

        }
        if (offset != null) {
            request.addPostParam("Offset", offset.toString());

        }
        if (metricId != null) {
            request.addPostParam("MetricId", metricId);

        }
        if (metricName != null) {
            request.addPostParam("MetricName", metricName);

        }
        if (answerText != null) {
            request.addPostParam("AnswerText", answerText);

        }
        if (answerId != null) {
            request.addPostParam("AnswerId", answerId);

        }
        if (questionnaireSid != null) {
            request.addPostParam("QuestionnaireSid", questionnaireSid);

        }
    }

    private void addHeaderParams(final Request request) {
        if (authorization != null) {
            request.addHeaderParam("Authorization", authorization);

        }
    }
}
