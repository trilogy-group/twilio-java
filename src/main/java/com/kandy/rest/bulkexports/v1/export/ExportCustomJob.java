/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Bulkexports
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.bulkexports.v1.export;

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

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ExportCustomJob extends Resource {
    private static final long serialVersionUID = 125242558228L;

    public static ExportCustomJobCreator creator(final String pathResourceType, final String startDay,
            final String endDay, final String friendlyName) {
        return new ExportCustomJobCreator(pathResourceType, startDay, endDay, friendlyName);
    }

    public static ExportCustomJobReader reader(final String pathResourceType) {
        return new ExportCustomJobReader(pathResourceType);
    }

    /**
     * Converts a JSON String into a ExportCustomJob object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ExportCustomJob object represented by the provided JSON
     */
    public static ExportCustomJob fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExportCustomJob.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ExportCustomJob object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ExportCustomJob object represented by the provided JSON
     */
    public static ExportCustomJob fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExportCustomJob.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String friendlyName;
    private final String resourceType;
    private final String startDay;
    private final String endDay;
    private final String webhookUrl;
    private final String webhookMethod;
    private final String email;
    private final String jobSid;
    private final Map<String, Object> details;
    private final String jobQueuePosition;
    private final String estimatedCompletionTime;

    @JsonCreator
    private ExportCustomJob(
            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("resource_type") final String resourceType,

            @JsonProperty("start_day") final String startDay,

            @JsonProperty("end_day") final String endDay,

            @JsonProperty("webhook_url") final String webhookUrl,

            @JsonProperty("webhook_method") final String webhookMethod,

            @JsonProperty("email") final String email,

            @JsonProperty("job_sid") final String jobSid,

            @JsonProperty("details") final Map<String, Object> details,

            @JsonProperty("job_queue_position") final String jobQueuePosition,

            @JsonProperty("estimated_completion_time") final String estimatedCompletionTime) {
        this.friendlyName = friendlyName;
        this.resourceType = resourceType;
        this.startDay = startDay;
        this.endDay = endDay;
        this.webhookUrl = webhookUrl;
        this.webhookMethod = webhookMethod;
        this.email = email;
        this.jobSid = jobSid;
        this.details = details;
        this.jobQueuePosition = jobQueuePosition;
        this.estimatedCompletionTime = estimatedCompletionTime;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final String getStartDay() {
        return this.startDay;
    }

    public final String getEndDay() {
        return this.endDay;
    }

    public final String getWebhookUrl() {
        return this.webhookUrl;
    }

    public final String getWebhookMethod() {
        return this.webhookMethod;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getJobSid() {
        return this.jobSid;
    }

    public final Map<String, Object> getDetails() {
        return this.details;
    }

    public final String getJobQueuePosition() {
        return this.jobQueuePosition;
    }

    public final String getEstimatedCompletionTime() {
        return this.estimatedCompletionTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExportCustomJob other = (ExportCustomJob) o;

        return Objects.equals(friendlyName, other.friendlyName) && Objects.equals(resourceType, other.resourceType)
                && Objects.equals(startDay, other.startDay) && Objects.equals(endDay, other.endDay)
                && Objects.equals(webhookUrl, other.webhookUrl) && Objects.equals(webhookMethod, other.webhookMethod)
                && Objects.equals(email, other.email) && Objects.equals(jobSid, other.jobSid)
                && Objects.equals(details, other.details) && Objects.equals(jobQueuePosition, other.jobQueuePosition)
                && Objects.equals(estimatedCompletionTime, other.estimatedCompletionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendlyName, resourceType, startDay, endDay, webhookUrl, webhookMethod, email, jobSid,
                details, jobQueuePosition, estimatedCompletionTime);
    }

}
