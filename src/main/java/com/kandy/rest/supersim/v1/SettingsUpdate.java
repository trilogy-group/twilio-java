/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Supersim
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.supersim.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.converter.DateConverter;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SettingsUpdate extends Resource {
    private static final long serialVersionUID = 126256874693410L;

    public static SettingsUpdateReader reader() {
        return new SettingsUpdateReader();
    }

    /**
     * Converts a JSON String into a SettingsUpdate object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SettingsUpdate object represented by the provided JSON
     */
    public static SettingsUpdate fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SettingsUpdate.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SettingsUpdate object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SettingsUpdate object represented by the provided JSON
     */
    public static SettingsUpdate fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SettingsUpdate.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Status {
        SCHEDULED("scheduled"),
        IN_PROGRESS("in-progress"),
        SUCCESSFUL("successful"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String sid;
    private final String iccid;
    private final String simSid;
    private final SettingsUpdate.Status status;
    private final List<Map<String, Object>> packages;
    private final ZonedDateTime dateCompleted;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;

    @JsonCreator
    private SettingsUpdate(
            @JsonProperty("sid") final String sid,

            @JsonProperty("iccid") final String iccid,

            @JsonProperty("sim_sid") final String simSid,

            @JsonProperty("status") final SettingsUpdate.Status status,

            @JsonProperty("packages") final List<Map<String, Object>> packages,

            @JsonProperty("date_completed") final String dateCompleted,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated) {
        this.sid = sid;
        this.iccid = iccid;
        this.simSid = simSid;
        this.status = status;
        this.packages = packages;
        this.dateCompleted = DateConverter.iso8601DateTimeFromString(dateCompleted);
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getIccid() {
        return this.iccid;
    }

    public final String getSimSid() {
        return this.simSid;
    }

    public final SettingsUpdate.Status getStatus() {
        return this.status;
    }

    public final List<Map<String, Object>> getPackages() {
        return this.packages;
    }

    public final ZonedDateTime getDateCompleted() {
        return this.dateCompleted;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SettingsUpdate other = (SettingsUpdate) o;

        return Objects.equals(sid, other.sid) && Objects.equals(iccid, other.iccid)
                && Objects.equals(simSid, other.simSid) && Objects.equals(status, other.status)
                && Objects.equals(packages, other.packages) && Objects.equals(dateCompleted, other.dateCompleted)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, iccid, simSid, status, packages, dateCompleted, dateCreated, dateUpdated);
    }

}
