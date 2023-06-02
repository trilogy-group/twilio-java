/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Api
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import java.util.Currency;
import com.kandy.converter.DateConverter;
import com.kandy.converter.Promoter;
import com.kandy.converter.CurrencyDeserializer;
import com.kandy.exception.ApiConnectionException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
public class Call extends Resource {
    private static final long serialVersionUID = 229062317637234L;

    public static CallCreator creator(final com.kandy.type.Endpoint to, final com.kandy.type.Endpoint from,
            final URI url) {
        return new CallCreator(to, from, url);
    }

    public static CallCreator creator(final String pathAccountSid, final com.kandy.type.Endpoint to,
            final com.kandy.type.Endpoint from, final URI url) {
        return new CallCreator(pathAccountSid, to, from, url);
    }

    public static CallCreator creator(final com.kandy.type.Endpoint to, final com.kandy.type.Endpoint from,
            final com.kandy.type.Twiml twiml) {
        return new CallCreator(to, from, twiml);
    }

    public static CallCreator creator(final String pathAccountSid, final com.kandy.type.Endpoint to,
            final com.kandy.type.Endpoint from, final com.kandy.type.Twiml twiml) {
        return new CallCreator(pathAccountSid, to, from, twiml);
    }

    public static CallCreator creator(final com.kandy.type.Endpoint to, final com.kandy.type.Endpoint from,
            final String applicationSid) {
        return new CallCreator(to, from, applicationSid);
    }

    public static CallCreator creator(final String pathAccountSid, final com.kandy.type.Endpoint to,
            final com.kandy.type.Endpoint from, final String applicationSid) {
        return new CallCreator(pathAccountSid, to, from, applicationSid);
    }

    public static CallDeleter deleter(final String pathSid) {
        return new CallDeleter(pathSid);
    }

    public static CallDeleter deleter(final String pathAccountSid, final String pathSid) {
        return new CallDeleter(pathAccountSid, pathSid);
    }

    public static CallFetcher fetcher(final String pathSid) {
        return new CallFetcher(pathSid);
    }

    public static CallFetcher fetcher(final String pathAccountSid, final String pathSid) {
        return new CallFetcher(pathAccountSid, pathSid);
    }

    public static CallReader reader() {
        return new CallReader();
    }

    public static CallReader reader(final String pathAccountSid) {
        return new CallReader(pathAccountSid);
    }

    public static CallUpdater updater(final String pathSid) {
        return new CallUpdater(pathSid);
    }

    public static CallUpdater updater(final String pathAccountSid, final String pathSid) {
        return new CallUpdater(pathAccountSid, pathSid);
    }

    /**
     * Converts a JSON String into a Call object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Call object represented by the provided JSON
     */
    public static Call fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Call.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Call object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Call object represented by the provided JSON
     */
    public static Call fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Call.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Status {
        QUEUED("queued"),
        RINGING("ringing"),
        IN_PROGRESS("in-progress"),
        COMPLETED("completed"),
        BUSY("busy"),
        FAILED("failed"),
        NO_ANSWER("no-answer"),
        CANCELED("canceled");

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

    public enum UpdateStatus {
        CANCELED("canceled"),
        COMPLETED("completed");

        private final String value;

        private UpdateStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static UpdateStatus forValue(final String value) {
            return Promoter.enumFromString(value, UpdateStatus.values());
        }
    }

    private final String sid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String parentCallSid;
    private final String accountSid;
    private final String to;
    private final String toFormatted;
    private final String from;
    private final String fromFormatted;
    private final String phoneNumberSid;
    private final Call.Status status;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private final String duration;
    private final String price;
    private final Currency priceUnit;
    private final String direction;
    private final String answeredBy;
    private final String apiVersion;
    private final String forwardedFrom;
    private final String groupSid;
    private final String callerName;
    private final String queueTime;
    private final String trunkSid;
    private final String uri;
    private final Map<String, String> subresourceUris;

    @JsonCreator
    private Call(
            @JsonProperty("sid") final String sid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("parent_call_sid") final String parentCallSid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("to") final String to,

            @JsonProperty("to_formatted") final String toFormatted,

            @JsonProperty("from") final String from,

            @JsonProperty("from_formatted") final String fromFormatted,

            @JsonProperty("phone_number_sid") final String phoneNumberSid,

            @JsonProperty("status") final Call.Status status,

            @JsonProperty("start_time") final String startTime,

            @JsonProperty("end_time") final String endTime,

            @JsonProperty("duration") final String duration,

            @JsonProperty("price") final String price,

            @JsonProperty("price_unit") @JsonDeserialize(using = com.kandy.converter.CurrencyDeserializer.class) final Currency priceUnit,

            @JsonProperty("direction") final String direction,

            @JsonProperty("answered_by") final String answeredBy,

            @JsonProperty("api_version") final String apiVersion,

            @JsonProperty("forwarded_from") final String forwardedFrom,

            @JsonProperty("group_sid") final String groupSid,

            @JsonProperty("caller_name") final String callerName,

            @JsonProperty("queue_time") final String queueTime,

            @JsonProperty("trunk_sid") final String trunkSid,

            @JsonProperty("uri") final String uri,

            @JsonProperty("subresource_uris") final Map<String, String> subresourceUris) {
        this.sid = sid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.parentCallSid = parentCallSid;
        this.accountSid = accountSid;
        this.to = to;
        this.toFormatted = toFormatted;
        this.from = from;
        this.fromFormatted = fromFormatted;
        this.phoneNumberSid = phoneNumberSid;
        this.status = status;
        this.startTime = DateConverter.rfc2822DateTimeFromString(startTime);
        this.endTime = DateConverter.rfc2822DateTimeFromString(endTime);
        this.duration = duration;
        this.price = price;
        this.priceUnit = priceUnit;
        this.direction = direction;
        this.answeredBy = answeredBy;
        this.apiVersion = apiVersion;
        this.forwardedFrom = forwardedFrom;
        this.groupSid = groupSid;
        this.callerName = callerName;
        this.queueTime = queueTime;
        this.trunkSid = trunkSid;
        this.uri = uri;
        this.subresourceUris = subresourceUris;
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

    public final String getParentCallSid() {
        return this.parentCallSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getTo() {
        return this.to;
    }

    public final String getToFormatted() {
        return this.toFormatted;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getFromFormatted() {
        return this.fromFormatted;
    }

    public final String getPhoneNumberSid() {
        return this.phoneNumberSid;
    }

    public final Call.Status getStatus() {
        return this.status;
    }

    public final ZonedDateTime getStartTime() {
        return this.startTime;
    }

    public final ZonedDateTime getEndTime() {
        return this.endTime;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getPrice() {
        return this.price;
    }

    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    public final String getDirection() {
        return this.direction;
    }

    public final String getAnsweredBy() {
        return this.answeredBy;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final String getForwardedFrom() {
        return this.forwardedFrom;
    }

    public final String getGroupSid() {
        return this.groupSid;
    }

    public final String getCallerName() {
        return this.callerName;
    }

    public final String getQueueTime() {
        return this.queueTime;
    }

    public final String getTrunkSid() {
        return this.trunkSid;
    }

    public final String getUri() {
        return this.uri;
    }

    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Call other = (Call) o;

        return Objects.equals(sid, other.sid) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(parentCallSid, other.parentCallSid)
                && Objects.equals(accountSid, other.accountSid) && Objects.equals(to, other.to)
                && Objects.equals(toFormatted, other.toFormatted) && Objects.equals(from, other.from)
                && Objects.equals(fromFormatted, other.fromFormatted)
                && Objects.equals(phoneNumberSid, other.phoneNumberSid) && Objects.equals(status, other.status)
                && Objects.equals(startTime, other.startTime) && Objects.equals(endTime, other.endTime)
                && Objects.equals(duration, other.duration) && Objects.equals(price, other.price)
                && Objects.equals(priceUnit, other.priceUnit) && Objects.equals(direction, other.direction)
                && Objects.equals(answeredBy, other.answeredBy) && Objects.equals(apiVersion, other.apiVersion)
                && Objects.equals(forwardedFrom, other.forwardedFrom) && Objects.equals(groupSid, other.groupSid)
                && Objects.equals(callerName, other.callerName) && Objects.equals(queueTime, other.queueTime)
                && Objects.equals(trunkSid, other.trunkSid) && Objects.equals(uri, other.uri)
                && Objects.equals(subresourceUris, other.subresourceUris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, dateCreated, dateUpdated, parentCallSid, accountSid, to, toFormatted, from,
                fromFormatted, phoneNumberSid, status, startTime, endTime, duration, price, priceUnit, direction,
                answeredBy, apiVersion, forwardedFrom, groupSid, callerName, queueTime, trunkSid, uri, subresourceUris);
    }

}
