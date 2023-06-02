/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Notify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.notify.v1.service;

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
public class Notification extends Resource {
    private static final long serialVersionUID = 129411229878484L;

    public static NotificationCreator creator(final String pathServiceSid) {
        return new NotificationCreator(pathServiceSid);
    }

    /**
     * Converts a JSON String into a Notification object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Notification object represented by the provided JSON
     */
    public static Notification fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Notification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Notification object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Notification object represented by the provided JSON
     */
    public static Notification fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Notification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Priority {
        HIGH("high"),
        LOW("low");

        private final String value;

        private Priority(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Priority forValue(final String value) {
            return Promoter.enumFromString(value, Priority.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final ZonedDateTime dateCreated;
    private final List<String> identities;
    private final List<String> tags;
    private final List<String> segments;
    private final Notification.Priority priority;
    private final Integer ttl;
    private final String title;
    private final String body;
    private final String sound;
    private final String action;
    private final Map<String, Object> data;
    private final Map<String, Object> apn;
    private final Map<String, Object> gcm;
    private final Map<String, Object> fcm;
    private final Map<String, Object> sms;
    private final Map<String, Object> facebookMessenger;
    private final Map<String, Object> alexa;

    @JsonCreator
    private Notification(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("identities") final List<String> identities,

            @JsonProperty("tags") final List<String> tags,

            @JsonProperty("segments") final List<String> segments,

            @JsonProperty("priority") final Notification.Priority priority,

            @JsonProperty("ttl") final Integer ttl,

            @JsonProperty("title") final String title,

            @JsonProperty("body") final String body,

            @JsonProperty("sound") final String sound,

            @JsonProperty("action") final String action,

            @JsonProperty("data") final Map<String, Object> data,

            @JsonProperty("apn") final Map<String, Object> apn,

            @JsonProperty("gcm") final Map<String, Object> gcm,

            @JsonProperty("fcm") final Map<String, Object> fcm,

            @JsonProperty("sms") final Map<String, Object> sms,

            @JsonProperty("facebook_messenger") final Map<String, Object> facebookMessenger,

            @JsonProperty("alexa") final Map<String, Object> alexa) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.identities = identities;
        this.tags = tags;
        this.segments = segments;
        this.priority = priority;
        this.ttl = ttl;
        this.title = title;
        this.body = body;
        this.sound = sound;
        this.action = action;
        this.data = data;
        this.apn = apn;
        this.gcm = gcm;
        this.fcm = fcm;
        this.sms = sms;
        this.facebookMessenger = facebookMessenger;
        this.alexa = alexa;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final List<String> getIdentities() {
        return this.identities;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final List<String> getSegments() {
        return this.segments;
    }

    public final Notification.Priority getPriority() {
        return this.priority;
    }

    public final Integer getTtl() {
        return this.ttl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getSound() {
        return this.sound;
    }

    public final String getAction() {
        return this.action;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final Map<String, Object> getApn() {
        return this.apn;
    }

    public final Map<String, Object> getGcm() {
        return this.gcm;
    }

    public final Map<String, Object> getFcm() {
        return this.fcm;
    }

    public final Map<String, Object> getSms() {
        return this.sms;
    }

    public final Map<String, Object> getFacebookMessenger() {
        return this.facebookMessenger;
    }

    public final Map<String, Object> getAlexa() {
        return this.alexa;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Notification other = (Notification) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(serviceSid, other.serviceSid) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(identities, other.identities) && Objects.equals(tags, other.tags)
                && Objects.equals(segments, other.segments) && Objects.equals(priority, other.priority)
                && Objects.equals(ttl, other.ttl) && Objects.equals(title, other.title)
                && Objects.equals(body, other.body) && Objects.equals(sound, other.sound)
                && Objects.equals(action, other.action) && Objects.equals(data, other.data)
                && Objects.equals(apn, other.apn) && Objects.equals(gcm, other.gcm) && Objects.equals(fcm, other.fcm)
                && Objects.equals(sms, other.sms) && Objects.equals(facebookMessenger, other.facebookMessenger)
                && Objects.equals(alexa, other.alexa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, serviceSid, dateCreated, identities, tags, segments, priority, ttl, title,
                body, sound, action, data, apn, gcm, fcm, sms, facebookMessenger, alexa);
    }

}
