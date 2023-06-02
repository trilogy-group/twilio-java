/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Autopilot
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.autopilot.v1.assistant.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class TaskStatistics extends Resource {
    private static final long serialVersionUID = 99044881135361L;

    public static TaskStatisticsFetcher fetcher(final String pathAssistantSid, final String pathTaskSid) {
        return new TaskStatisticsFetcher(pathAssistantSid, pathTaskSid);
    }

    /**
     * Converts a JSON String into a TaskStatistics object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TaskStatistics object represented by the provided JSON
     */
    public static TaskStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TaskStatistics object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TaskStatistics object represented by the provided JSON
     */
    public static TaskStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String assistantSid;
    private final String taskSid;
    private final Integer samplesCount;
    private final Integer fieldsCount;
    private final URI url;

    @JsonCreator
    private TaskStatistics(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("assistant_sid") final String assistantSid,

            @JsonProperty("task_sid") final String taskSid,

            @JsonProperty("samples_count") final Integer samplesCount,

            @JsonProperty("fields_count") final Integer fieldsCount,

            @JsonProperty("url") final URI url) {
        this.accountSid = accountSid;
        this.assistantSid = assistantSid;
        this.taskSid = taskSid;
        this.samplesCount = samplesCount;
        this.fieldsCount = fieldsCount;
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getAssistantSid() {
        return this.assistantSid;
    }

    public final String getTaskSid() {
        return this.taskSid;
    }

    public final Integer getSamplesCount() {
        return this.samplesCount;
    }

    public final Integer getFieldsCount() {
        return this.fieldsCount;
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

        TaskStatistics other = (TaskStatistics) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(assistantSid, other.assistantSid)
                && Objects.equals(taskSid, other.taskSid) && Objects.equals(samplesCount, other.samplesCount)
                && Objects.equals(fieldsCount, other.fieldsCount) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, assistantSid, taskSid, samplesCount, fieldsCount, url);
    }

}
