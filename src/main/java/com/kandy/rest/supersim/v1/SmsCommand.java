/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Supersim
 * This is the public Twilio REST API.
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
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SmsCommand extends Resource {
    private static final long serialVersionUID = 38007963555299L;

    public static SmsCommandCreator creator(final String sim, final String payload) {
        return new SmsCommandCreator(sim, payload);
    }

    public static SmsCommandFetcher fetcher(final String pathSid) {
        return new SmsCommandFetcher(pathSid);
    }

    public static SmsCommandReader reader() {
        return new SmsCommandReader();
    }

    /**
     * Converts a JSON String into a SmsCommand object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SmsCommand object represented by the provided JSON
     */
    public static SmsCommand fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SmsCommand.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SmsCommand object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SmsCommand object represented by the provided JSON
     */
    public static SmsCommand fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SmsCommand.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Direction {
        TO_SIM("to_sim"),
        FROM_SIM("from_sim");

        private final String value;

        private Direction(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Direction forValue(final String value) {
            return Promoter.enumFromString(value, Direction.values());
        }
    }

    public enum Status {
        QUEUED("queued"),
        SENT("sent"),
        DELIVERED("delivered"),
        RECEIVED("received"),
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
    private final String accountSid;
    private final String simSid;
    private final String payload;
    private final SmsCommand.Status status;
    private final SmsCommand.Direction direction;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private SmsCommand(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("sim_sid") final String simSid,

            @JsonProperty("payload") final String payload,

            @JsonProperty("status") final SmsCommand.Status status,

            @JsonProperty("direction") final SmsCommand.Direction direction,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.simSid = simSid;
        this.payload = payload;
        this.status = status;
        this.direction = direction;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getSimSid() {
        return this.simSid;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final SmsCommand.Status getStatus() {
        return this.status;
    }

    public final SmsCommand.Direction getDirection() {
        return this.direction;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SmsCommand other = (SmsCommand) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(simSid, other.simSid) && Objects.equals(payload, other.payload)
                && Objects.equals(status, other.status) && Objects.equals(direction, other.direction)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, simSid, payload, status, direction, dateCreated, dateUpdated, url);
    }

}
