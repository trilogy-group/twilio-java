/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Insights
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.insights.v1.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Annotation extends Resource {
    private static final long serialVersionUID = 9735005754677L;

    public static AnnotationFetcher fetcher(final String pathCallSid) {
        return new AnnotationFetcher(pathCallSid);
    }

    public static AnnotationUpdater updater(final String pathCallSid) {
        return new AnnotationUpdater(pathCallSid);
    }

    /**
     * Converts a JSON String into a Annotation object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Annotation object represented by the provided JSON
     */
    public static Annotation fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Annotation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Annotation object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Annotation object represented by the provided JSON
     */
    public static Annotation fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Annotation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum AnsweredBy {
        UNKNOWN_ANSWERED_BY("unknown_answered_by"),
        HUMAN("human"),
        MACHINE("machine");

        private final String value;

        private AnsweredBy(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static AnsweredBy forValue(final String value) {
            return Promoter.enumFromString(value, AnsweredBy.values());
        }
    }

    public enum ConnectivityIssue {
        UNKNOWN_CONNECTIVITY_ISSUE("unknown_connectivity_issue"),
        NO_CONNECTIVITY_ISSUE("no_connectivity_issue"),
        INVALID_NUMBER("invalid_number"),
        CALLER_ID("caller_id"),
        DROPPED_CALL("dropped_call"),
        NUMBER_REACHABILITY("number_reachability");

        private final String value;

        private ConnectivityIssue(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ConnectivityIssue forValue(final String value) {
            return Promoter.enumFromString(value, ConnectivityIssue.values());
        }
    }

    private final String callSid;
    private final String accountSid;
    private final Annotation.AnsweredBy answeredBy;
    private final Annotation.ConnectivityIssue connectivityIssue;
    private final List<String> qualityIssues;
    private final Boolean spam;
    private final Integer callScore;
    private final String comment;
    private final String incident;
    private final URI url;

    @JsonCreator
    private Annotation(
            @JsonProperty("call_sid") final String callSid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("answered_by") final Annotation.AnsweredBy answeredBy,

            @JsonProperty("connectivity_issue") final Annotation.ConnectivityIssue connectivityIssue,

            @JsonProperty("quality_issues") final List<String> qualityIssues,

            @JsonProperty("spam") final Boolean spam,

            @JsonProperty("call_score") final Integer callScore,

            @JsonProperty("comment") final String comment,

            @JsonProperty("incident") final String incident,

            @JsonProperty("url") final URI url) {
        this.callSid = callSid;
        this.accountSid = accountSid;
        this.answeredBy = answeredBy;
        this.connectivityIssue = connectivityIssue;
        this.qualityIssues = qualityIssues;
        this.spam = spam;
        this.callScore = callScore;
        this.comment = comment;
        this.incident = incident;
        this.url = url;
    }

    public final String getCallSid() {
        return this.callSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final Annotation.AnsweredBy getAnsweredBy() {
        return this.answeredBy;
    }

    public final Annotation.ConnectivityIssue getConnectivityIssue() {
        return this.connectivityIssue;
    }

    public final List<String> getQualityIssues() {
        return this.qualityIssues;
    }

    public final Boolean getSpam() {
        return this.spam;
    }

    public final Integer getCallScore() {
        return this.callScore;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getIncident() {
        return this.incident;
    }

    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Annotation other = (Annotation) o;

        return Objects.equals(callSid, other.callSid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(answeredBy, other.answeredBy)
                && Objects.equals(connectivityIssue, other.connectivityIssue)
                && Objects.equals(qualityIssues, other.qualityIssues) && Objects.equals(spam, other.spam)
                && Objects.equals(callScore, other.callScore) && Objects.equals(comment, other.comment)
                && Objects.equals(incident, other.incident) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callSid, accountSid, answeredBy, connectivityIssue, qualityIssues, spam, callScore, comment,
                incident, url);
    }

}
