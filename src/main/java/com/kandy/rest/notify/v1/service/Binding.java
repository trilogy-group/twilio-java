/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Notify
 * This is the public Kandy REST API.
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
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Binding extends Resource {
    private static final long serialVersionUID = 204710880064403L;

    public static BindingCreator creator(final String pathServiceSid, final String identity,
            final Binding.BindingType bindingType, final String address) {
        return new BindingCreator(pathServiceSid, identity, bindingType, address);
    }

    public static BindingDeleter deleter(final String pathServiceSid, final String pathSid) {
        return new BindingDeleter(pathServiceSid, pathSid);
    }

    public static BindingFetcher fetcher(final String pathServiceSid, final String pathSid) {
        return new BindingFetcher(pathServiceSid, pathSid);
    }

    public static BindingReader reader(final String pathServiceSid) {
        return new BindingReader(pathServiceSid);
    }

    /**
     * Converts a JSON String into a Binding object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Binding object represented by the provided JSON
     */
    public static Binding fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Binding.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Binding object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Binding object represented by the provided JSON
     */
    public static Binding fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Binding.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum BindingType {
        APN("apn"),
        GCM("gcm"),
        SMS("sms"),
        FCM("fcm"),
        FACEBOOK_MESSENGER("facebook-messenger"),
        ALEXA("alexa");

        private final String value;

        private BindingType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static BindingType forValue(final String value) {
            return Promoter.enumFromString(value, BindingType.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String credentialSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String notificationProtocolVersion;
    private final String endpoint;
    private final String identity;
    private final String bindingType;
    private final String address;
    private final List<String> tags;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Binding(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("credential_sid") final String credentialSid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("notification_protocol_version") final String notificationProtocolVersion,

            @JsonProperty("endpoint") final String endpoint,

            @JsonProperty("identity") final String identity,

            @JsonProperty("binding_type") final String bindingType,

            @JsonProperty("address") final String address,

            @JsonProperty("tags") final List<String> tags,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.credentialSid = credentialSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.notificationProtocolVersion = notificationProtocolVersion;
        this.endpoint = endpoint;
        this.identity = identity;
        this.bindingType = bindingType;
        this.address = address;
        this.tags = tags;
        this.url = url;
        this.links = links;
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

    public final String getCredentialSid() {
        return this.credentialSid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getNotificationProtocolVersion() {
        return this.notificationProtocolVersion;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final String getBindingType() {
        return this.bindingType;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Binding other = (Binding) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(serviceSid, other.serviceSid) && Objects.equals(credentialSid, other.credentialSid)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(notificationProtocolVersion, other.notificationProtocolVersion)
                && Objects.equals(endpoint, other.endpoint) && Objects.equals(identity, other.identity)
                && Objects.equals(bindingType, other.bindingType) && Objects.equals(address, other.address)
                && Objects.equals(tags, other.tags) && Objects.equals(url, other.url)
                && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, serviceSid, credentialSid, dateCreated, dateUpdated,
                notificationProtocolVersion, endpoint, identity, bindingType, address, tags, url, links);
    }

}
