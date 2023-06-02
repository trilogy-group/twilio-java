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

import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Message extends Resource {
    private static final long serialVersionUID = 20600562506098L;

    public static MessageCreator creator(final com.kandy.type.PhoneNumber to, final com.kandy.type.PhoneNumber from,
            final String body) {
        return new MessageCreator(to, from, body);
    }

    public static MessageCreator creator(final String pathAccountSid, final com.kandy.type.PhoneNumber to,
            final com.kandy.type.PhoneNumber from, final String body) {
        return new MessageCreator(pathAccountSid, to, from, body);
    }

    public static MessageCreator creator(final com.kandy.type.PhoneNumber to, final com.kandy.type.PhoneNumber from,
            final List<URI> mediaUrl) {
        return new MessageCreator(to, from, mediaUrl);
    }

    public static MessageCreator creator(final String pathAccountSid, final com.kandy.type.PhoneNumber to,
            final com.kandy.type.PhoneNumber from, final List<URI> mediaUrl) {
        return new MessageCreator(pathAccountSid, to, from, mediaUrl);
    }

    public static MessageCreator creator(final com.kandy.type.PhoneNumber to, final String messagingServiceSid,
            final String body) {
        return new MessageCreator(to, messagingServiceSid, body);
    }

    public static MessageCreator creator(final String pathAccountSid, final com.kandy.type.PhoneNumber to,
            final String messagingServiceSid, final String body) {
        return new MessageCreator(pathAccountSid, to, messagingServiceSid, body);
    }

    public static MessageCreator creator(final com.kandy.type.PhoneNumber to, final String messagingServiceSid,
            final List<URI> mediaUrl) {
        return new MessageCreator(to, messagingServiceSid, mediaUrl);
    }

    public static MessageCreator creator(final String pathAccountSid, final com.kandy.type.PhoneNumber to,
            final String messagingServiceSid, final List<URI> mediaUrl) {
        return new MessageCreator(pathAccountSid, to, messagingServiceSid, mediaUrl);
    }

    public static MessageDeleter deleter(final String pathSid) {
        return new MessageDeleter(pathSid);
    }

    public static MessageDeleter deleter(final String pathAccountSid, final String pathSid) {
        return new MessageDeleter(pathAccountSid, pathSid);
    }

    public static MessageFetcher fetcher(final String pathSid) {
        return new MessageFetcher(pathSid);
    }

    public static MessageFetcher fetcher(final String pathAccountSid, final String pathSid) {
        return new MessageFetcher(pathAccountSid, pathSid);
    }

    public static MessageReader reader() {
        return new MessageReader();
    }

    public static MessageReader reader(final String pathAccountSid) {
        return new MessageReader(pathAccountSid);
    }

    public static MessageUpdater updater(final String pathSid) {
        return new MessageUpdater(pathSid);
    }

    public static MessageUpdater updater(final String pathAccountSid, final String pathSid) {
        return new MessageUpdater(pathAccountSid, pathSid);
    }

    /**
     * Converts a JSON String into a Message object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Message object represented by the provided JSON
     */
    public static Message fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Message.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Message object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Message object represented by the provided JSON
     */
    public static Message fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Message.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum AddressRetention {
        RETAIN("retain");

        private final String value;

        private AddressRetention(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static AddressRetention forValue(final String value) {
            return Promoter.enumFromString(value, AddressRetention.values());
        }
    }

    public enum ContentRetention {
        RETAIN("retain");

        private final String value;

        private ContentRetention(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ContentRetention forValue(final String value) {
            return Promoter.enumFromString(value, ContentRetention.values());
        }
    }

    public enum Direction {
        INBOUND("inbound"),
        OUTBOUND_API("outbound-api"),
        OUTBOUND_CALL("outbound-call"),
        OUTBOUND_REPLY("outbound-reply");

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

    public enum ScheduleType {
        FIXED("fixed");

        private final String value;

        private ScheduleType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ScheduleType forValue(final String value) {
            return Promoter.enumFromString(value, ScheduleType.values());
        }
    }

    public enum Status {
        QUEUED("queued"),
        SENDING("sending"),
        SENT("sent"),
        FAILED("failed"),
        DELIVERED("delivered"),
        UNDELIVERED("undelivered"),
        RECEIVING("receiving"),
        RECEIVED("received"),
        ACCEPTED("accepted"),
        SCHEDULED("scheduled"),
        READ("read"),
        PARTIALLY_DELIVERED("partially_delivered"),
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
        CANCELED("canceled");

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

    private final String body;
    private final String numSegments;
    private final Message.Direction direction;
    private final com.kandy.type.PhoneNumber from;
    private final String to;
    private final ZonedDateTime dateUpdated;
    private final String price;
    private final String errorMessage;
    private final String uri;
    private final String accountSid;
    private final String numMedia;
    private final Message.Status status;
    private final String messagingServiceSid;
    private final String sid;
    private final ZonedDateTime dateSent;
    private final ZonedDateTime dateCreated;
    private final Integer errorCode;
    private final Currency priceUnit;
    private final String apiVersion;
    private final Map<String, String> subresourceUris;

    @JsonCreator
    private Message(
            @JsonProperty("body") final String body,

            @JsonProperty("num_segments") final String numSegments,

            @JsonProperty("direction") final Message.Direction direction,

            @JsonProperty("from") final com.kandy.type.PhoneNumber from,

            @JsonProperty("to") final String to,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("price") final String price,

            @JsonProperty("error_message") final String errorMessage,

            @JsonProperty("uri") final String uri,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("num_media") final String numMedia,

            @JsonProperty("status") final Message.Status status,

            @JsonProperty("messaging_service_sid") final String messagingServiceSid,

            @JsonProperty("sid") final String sid,

            @JsonProperty("date_sent") final String dateSent,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("error_code") final Integer errorCode,

            @JsonProperty("price_unit") @JsonDeserialize(using = com.kandy.converter.CurrencyDeserializer.class) final Currency priceUnit,

            @JsonProperty("api_version") final String apiVersion,

            @JsonProperty("subresource_uris") final Map<String, String> subresourceUris) {
        this.body = body;
        this.numSegments = numSegments;
        this.direction = direction;
        this.from = from;
        this.to = to;
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.price = price;
        this.errorMessage = errorMessage;
        this.uri = uri;
        this.accountSid = accountSid;
        this.numMedia = numMedia;
        this.status = status;
        this.messagingServiceSid = messagingServiceSid;
        this.sid = sid;
        this.dateSent = DateConverter.rfc2822DateTimeFromString(dateSent);
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.errorCode = errorCode;
        this.priceUnit = priceUnit;
        this.apiVersion = apiVersion;
        this.subresourceUris = subresourceUris;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getNumSegments() {
        return this.numSegments;
    }

    public final Message.Direction getDirection() {
        return this.direction;
    }

    public final com.kandy.type.PhoneNumber getFrom() {
        return this.from;
    }

    public final String getTo() {
        return this.to;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getNumMedia() {
        return this.numMedia;
    }

    public final Message.Status getStatus() {
        return this.status;
    }

    public final String getMessagingServiceSid() {
        return this.messagingServiceSid;
    }

    public final String getSid() {
        return this.sid;
    }

    public final ZonedDateTime getDateSent() {
        return this.dateSent;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    public final String getApiVersion() {
        return this.apiVersion;
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

        Message other = (Message) o;

        return Objects.equals(body, other.body) && Objects.equals(numSegments, other.numSegments)
                && Objects.equals(direction, other.direction) && Objects.equals(from, other.from)
                && Objects.equals(to, other.to) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(price, other.price) && Objects.equals(errorMessage, other.errorMessage)
                && Objects.equals(uri, other.uri) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(numMedia, other.numMedia) && Objects.equals(status, other.status)
                && Objects.equals(messagingServiceSid, other.messagingServiceSid) && Objects.equals(sid, other.sid)
                && Objects.equals(dateSent, other.dateSent) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(errorCode, other.errorCode) && Objects.equals(priceUnit, other.priceUnit)
                && Objects.equals(apiVersion, other.apiVersion)
                && Objects.equals(subresourceUris, other.subresourceUris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, numSegments, direction, from, to, dateUpdated, price, errorMessage, uri, accountSid,
                numMedia, status, messagingServiceSid, sid, dateSent, dateCreated, errorCode, priceUnit, apiVersion,
                subresourceUris);
    }

}
