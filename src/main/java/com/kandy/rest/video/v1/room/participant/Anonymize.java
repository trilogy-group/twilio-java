/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Video
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.video.v1.room.participant;

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
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Anonymize extends Resource {
    private static final long serialVersionUID = 134789378539185L;

    public static AnonymizeUpdater updater(final String pathRoomSid, final String pathSid) {
        return new AnonymizeUpdater(pathRoomSid, pathSid);
    }

    /**
     * Converts a JSON String into a Anonymize object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Anonymize object represented by the provided JSON
     */
    public static Anonymize fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Anonymize.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Anonymize object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Anonymize object represented by the provided JSON
     */
    public static Anonymize fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Anonymize.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Status {
        CONNECTED("connected"),
        DISCONNECTED("disconnected");

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
    private final String roomSid;
    private final String accountSid;
    private final Anonymize.Status status;
    private final String identity;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private final Integer duration;
    private final URI url;

    @JsonCreator
    private Anonymize(
            @JsonProperty("sid") final String sid,

            @JsonProperty("room_sid") final String roomSid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("status") final Anonymize.Status status,

            @JsonProperty("identity") final String identity,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("start_time") final String startTime,

            @JsonProperty("end_time") final String endTime,

            @JsonProperty("duration") final Integer duration,

            @JsonProperty("url") final URI url) {
        this.sid = sid;
        this.roomSid = roomSid;
        this.accountSid = accountSid;
        this.status = status;
        this.identity = identity;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.startTime = DateConverter.iso8601DateTimeFromString(startTime);
        this.endTime = DateConverter.iso8601DateTimeFromString(endTime);
        this.duration = duration;
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getRoomSid() {
        return this.roomSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final Anonymize.Status getStatus() {
        return this.status;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final ZonedDateTime getStartTime() {
        return this.startTime;
    }

    public final ZonedDateTime getEndTime() {
        return this.endTime;
    }

    public final Integer getDuration() {
        return this.duration;
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

        Anonymize other = (Anonymize) o;

        return Objects.equals(sid, other.sid) && Objects.equals(roomSid, other.roomSid)
                && Objects.equals(accountSid, other.accountSid) && Objects.equals(status, other.status)
                && Objects.equals(identity, other.identity) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(startTime, other.startTime)
                && Objects.equals(endTime, other.endTime) && Objects.equals(duration, other.duration)
                && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, roomSid, accountSid, status, identity, dateCreated, dateUpdated, startTime, endTime,
                duration, url);
    }

}
