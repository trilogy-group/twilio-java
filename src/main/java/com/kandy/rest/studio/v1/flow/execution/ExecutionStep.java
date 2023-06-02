/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Studio
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.studio.v1.flow.execution;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.converter.DateConverter;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ExecutionStep extends Resource {
    private static final long serialVersionUID = 271983635262130L;

    public static ExecutionStepFetcher fetcher(final String pathFlowSid, final String pathExecutionSid,
            final String pathSid) {
        return new ExecutionStepFetcher(pathFlowSid, pathExecutionSid, pathSid);
    }

    public static ExecutionStepReader reader(final String pathFlowSid, final String pathExecutionSid) {
        return new ExecutionStepReader(pathFlowSid, pathExecutionSid);
    }

    /**
     * Converts a JSON String into a ExecutionStep object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ExecutionStep object represented by the provided JSON
     */
    public static ExecutionStep fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExecutionStep.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ExecutionStep object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ExecutionStep object represented by the provided JSON
     */
    public static ExecutionStep fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExecutionStep.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String flowSid;
    private final String executionSid;
    private final String name;
    private final Map<String, Object> context;
    private final String transitionedFrom;
    private final String transitionedTo;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private ExecutionStep(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("flow_sid") final String flowSid,

            @JsonProperty("execution_sid") final String executionSid,

            @JsonProperty("name") final String name,

            @JsonProperty("context") final Map<String, Object> context,

            @JsonProperty("transitioned_from") final String transitionedFrom,

            @JsonProperty("transitioned_to") final String transitionedTo,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.flowSid = flowSid;
        this.executionSid = executionSid;
        this.name = name;
        this.context = context;
        this.transitionedFrom = transitionedFrom;
        this.transitionedTo = transitionedTo;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFlowSid() {
        return this.flowSid;
    }

    public final String getExecutionSid() {
        return this.executionSid;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getContext() {
        return this.context;
    }

    public final String getTransitionedFrom() {
        return this.transitionedFrom;
    }

    public final String getTransitionedTo() {
        return this.transitionedTo;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExecutionStep other = (ExecutionStep) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(flowSid, other.flowSid) && Objects.equals(executionSid, other.executionSid)
                && Objects.equals(name, other.name) && Objects.equals(context, other.context)
                && Objects.equals(transitionedFrom, other.transitionedFrom)
                && Objects.equals(transitionedTo, other.transitionedTo)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(url, other.url) && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, flowSid, executionSid, name, context, transitionedFrom, transitionedTo,
                dateCreated, dateUpdated, url, links);
    }

}
