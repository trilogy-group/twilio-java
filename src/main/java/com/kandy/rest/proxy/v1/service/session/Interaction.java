/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Proxy
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.proxy.v1.service.session;

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
public class Interaction extends Resource {
    private static final long serialVersionUID = 104550389018086L;

    public static InteractionDeleter deleter(final String pathServiceSid, final String pathSessionSid,
            final String pathSid) {
        return new InteractionDeleter(pathServiceSid, pathSessionSid, pathSid);
    }

    public static InteractionFetcher fetcher(final String pathServiceSid, final String pathSessionSid,
            final String pathSid) {
        return new InteractionFetcher(pathServiceSid, pathSessionSid, pathSid);
    }

    public static InteractionReader reader(final String pathServiceSid, final String pathSessionSid) {
        return new InteractionReader(pathServiceSid, pathSessionSid);
    }

    /**
     * Converts a JSON String into a Interaction object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Interaction object represented by the provided JSON
     */
    public static Interaction fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Interaction.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Interaction object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Interaction object represented by the provided JSON
     */
    public static Interaction fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Interaction.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum ResourceStatus {
        ACCEPTED("accepted"),
        ANSWERED("answered"),
        BUSY("busy"),
        CANCELED("canceled"),
        COMPLETED("completed"),
        DELETED("deleted"),
        DELIVERED("delivered"),
        DELIVERY_UNKNOWN("delivery-unknown"),
        FAILED("failed"),
        IN_PROGRESS("in-progress"),
        INITIATED("initiated"),
        NO_ANSWER("no-answer"),
        QUEUED("queued"),
        RECEIVED("received"),
        RECEIVING("receiving"),
        RINGING("ringing"),
        SCHEDULED("scheduled"),
        SENDING("sending"),
        SENT("sent"),
        UNDELIVERED("undelivered"),
        UNKNOWN("unknown");

        private final String value;

        private ResourceStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ResourceStatus forValue(final String value) {
            return Promoter.enumFromString(value, ResourceStatus.values());
        }
    }

    public enum Type {
        MESSAGE("message"),
        VOICE("voice"),
        UNKNOWN("unknown");

        private final String value;

        private Type(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Type forValue(final String value) {
            return Promoter.enumFromString(value, Type.values());
        }
    }

    private final String sid;
    private final String sessionSid;
    private final String serviceSid;
    private final String accountSid;
    private final String data;
    private final Interaction.Type type;
    private final String inboundParticipantSid;
    private final String inboundResourceSid;
    private final Interaction.ResourceStatus inboundResourceStatus;
    private final String inboundResourceType;
    private final URI inboundResourceUrl;
    private final String outboundParticipantSid;
    private final String outboundResourceSid;
    private final Interaction.ResourceStatus outboundResourceStatus;
    private final String outboundResourceType;
    private final URI outboundResourceUrl;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Interaction(
            @JsonProperty("sid") final String sid,

            @JsonProperty("session_sid") final String sessionSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("data") final String data,

            @JsonProperty("type") final Interaction.Type type,

            @JsonProperty("inbound_participant_sid") final String inboundParticipantSid,

            @JsonProperty("inbound_resource_sid") final String inboundResourceSid,

            @JsonProperty("inbound_resource_status") final Interaction.ResourceStatus inboundResourceStatus,

            @JsonProperty("inbound_resource_type") final String inboundResourceType,

            @JsonProperty("inbound_resource_url") final URI inboundResourceUrl,

            @JsonProperty("outbound_participant_sid") final String outboundParticipantSid,

            @JsonProperty("outbound_resource_sid") final String outboundResourceSid,

            @JsonProperty("outbound_resource_status") final Interaction.ResourceStatus outboundResourceStatus,

            @JsonProperty("outbound_resource_type") final String outboundResourceType,

            @JsonProperty("outbound_resource_url") final URI outboundResourceUrl,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url) {
        this.sid = sid;
        this.sessionSid = sessionSid;
        this.serviceSid = serviceSid;
        this.accountSid = accountSid;
        this.data = data;
        this.type = type;
        this.inboundParticipantSid = inboundParticipantSid;
        this.inboundResourceSid = inboundResourceSid;
        this.inboundResourceStatus = inboundResourceStatus;
        this.inboundResourceType = inboundResourceType;
        this.inboundResourceUrl = inboundResourceUrl;
        this.outboundParticipantSid = outboundParticipantSid;
        this.outboundResourceSid = outboundResourceSid;
        this.outboundResourceStatus = outboundResourceStatus;
        this.outboundResourceType = outboundResourceType;
        this.outboundResourceUrl = outboundResourceUrl;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getSessionSid() {
        return this.sessionSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getData() {
        return this.data;
    }

    public final Interaction.Type getType() {
        return this.type;
    }

    public final String getInboundParticipantSid() {
        return this.inboundParticipantSid;
    }

    public final String getInboundResourceSid() {
        return this.inboundResourceSid;
    }

    public final Interaction.ResourceStatus getInboundResourceStatus() {
        return this.inboundResourceStatus;
    }

    public final String getInboundResourceType() {
        return this.inboundResourceType;
    }

    public final URI getInboundResourceUrl() {
        return this.inboundResourceUrl;
    }

    public final String getOutboundParticipantSid() {
        return this.outboundParticipantSid;
    }

    public final String getOutboundResourceSid() {
        return this.outboundResourceSid;
    }

    public final Interaction.ResourceStatus getOutboundResourceStatus() {
        return this.outboundResourceStatus;
    }

    public final String getOutboundResourceType() {
        return this.outboundResourceType;
    }

    public final URI getOutboundResourceUrl() {
        return this.outboundResourceUrl;
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

        Interaction other = (Interaction) o;

        return Objects.equals(sid, other.sid) && Objects.equals(sessionSid, other.sessionSid)
                && Objects.equals(serviceSid, other.serviceSid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(data, other.data) && Objects.equals(type, other.type)
                && Objects.equals(inboundParticipantSid, other.inboundParticipantSid)
                && Objects.equals(inboundResourceSid, other.inboundResourceSid)
                && Objects.equals(inboundResourceStatus, other.inboundResourceStatus)
                && Objects.equals(inboundResourceType, other.inboundResourceType)
                && Objects.equals(inboundResourceUrl, other.inboundResourceUrl)
                && Objects.equals(outboundParticipantSid, other.outboundParticipantSid)
                && Objects.equals(outboundResourceSid, other.outboundResourceSid)
                && Objects.equals(outboundResourceStatus, other.outboundResourceStatus)
                && Objects.equals(outboundResourceType, other.outboundResourceType)
                && Objects.equals(outboundResourceUrl, other.outboundResourceUrl)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sessionSid, serviceSid, accountSid, data, type, inboundParticipantSid,
                inboundResourceSid, inboundResourceStatus, inboundResourceType, inboundResourceUrl,
                outboundParticipantSid, outboundResourceSid, outboundResourceStatus, outboundResourceType,
                outboundResourceUrl, dateCreated, dateUpdated, url);
    }

}
