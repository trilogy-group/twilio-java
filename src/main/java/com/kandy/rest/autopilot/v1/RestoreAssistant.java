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

package com.kandy.rest.autopilot.v1;

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

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class RestoreAssistant extends Resource {
    private static final long serialVersionUID = 63917994227032L;

    public static RestoreAssistantUpdater updater(final String assistant) {
        return new RestoreAssistantUpdater(assistant);
    }

    /**
     * Converts a JSON String into a RestoreAssistant object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return RestoreAssistant object represented by the provided JSON
     */
    public static RestoreAssistant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RestoreAssistant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a RestoreAssistant object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return RestoreAssistant object represented by the provided JSON
     */
    public static RestoreAssistant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RestoreAssistant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String uniqueName;
    private final String friendlyName;
    private final Boolean needsModelBuild;
    private final String latestModelBuildSid;
    private final Boolean logQueries;
    private final String developmentStage;
    private final URI callbackUrl;
    private final String callbackEvents;

    @JsonCreator
    private RestoreAssistant(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("sid") final String sid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("unique_name") final String uniqueName,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("needs_model_build") final Boolean needsModelBuild,

            @JsonProperty("latest_model_build_sid") final String latestModelBuildSid,

            @JsonProperty("log_queries") final Boolean logQueries,

            @JsonProperty("development_stage") final String developmentStage,

            @JsonProperty("callback_url") final URI callbackUrl,

            @JsonProperty("callback_events") final String callbackEvents) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.uniqueName = uniqueName;
        this.friendlyName = friendlyName;
        this.needsModelBuild = needsModelBuild;
        this.latestModelBuildSid = latestModelBuildSid;
        this.logQueries = logQueries;
        this.developmentStage = developmentStage;
        this.callbackUrl = callbackUrl;
        this.callbackEvents = callbackEvents;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getSid() {
        return this.sid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getUniqueName() {
        return this.uniqueName;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final Boolean getNeedsModelBuild() {
        return this.needsModelBuild;
    }

    public final String getLatestModelBuildSid() {
        return this.latestModelBuildSid;
    }

    public final Boolean getLogQueries() {
        return this.logQueries;
    }

    public final String getDevelopmentStage() {
        return this.developmentStage;
    }

    public final URI getCallbackUrl() {
        return this.callbackUrl;
    }

    public final String getCallbackEvents() {
        return this.callbackEvents;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RestoreAssistant other = (RestoreAssistant) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(sid, other.sid)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(uniqueName, other.uniqueName) && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(needsModelBuild, other.needsModelBuild)
                && Objects.equals(latestModelBuildSid, other.latestModelBuildSid)
                && Objects.equals(logQueries, other.logQueries)
                && Objects.equals(developmentStage, other.developmentStage)
                && Objects.equals(callbackUrl, other.callbackUrl)
                && Objects.equals(callbackEvents, other.callbackEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, sid, dateCreated, dateUpdated, uniqueName, friendlyName, needsModelBuild,
                latestModelBuildSid, logQueries, developmentStage, callbackUrl, callbackEvents);
    }

}
