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
import com.kandy.exception.ApiConnectionException;

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
public class Participant extends Resource {
    private static final long serialVersionUID = 85413043665121L;

    public static ParticipantCreator creator(final String pathServiceSid, final String pathSessionSid,
            final String identifier) {
        return new ParticipantCreator(pathServiceSid, pathSessionSid, identifier);
    }

    public static ParticipantDeleter deleter(final String pathServiceSid, final String pathSessionSid,
            final String pathSid) {
        return new ParticipantDeleter(pathServiceSid, pathSessionSid, pathSid);
    }

    public static ParticipantFetcher fetcher(final String pathServiceSid, final String pathSessionSid,
            final String pathSid) {
        return new ParticipantFetcher(pathServiceSid, pathSessionSid, pathSid);
    }

    public static ParticipantReader reader(final String pathServiceSid, final String pathSessionSid) {
        return new ParticipantReader(pathServiceSid, pathSessionSid);
    }

    /**
     * Converts a JSON String into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String sessionSid;
    private final String serviceSid;
    private final String accountSid;
    private final String friendlyName;
    private final String identifier;
    private final String proxyIdentifier;
    private final String proxyIdentifierSid;
    private final ZonedDateTime dateDeleted;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Participant(
            @JsonProperty("sid") final String sid,

            @JsonProperty("session_sid") final String sessionSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("identifier") final String identifier,

            @JsonProperty("proxy_identifier") final String proxyIdentifier,

            @JsonProperty("proxy_identifier_sid") final String proxyIdentifierSid,

            @JsonProperty("date_deleted") final String dateDeleted,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links) {
        this.sid = sid;
        this.sessionSid = sessionSid;
        this.serviceSid = serviceSid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.identifier = identifier;
        this.proxyIdentifier = proxyIdentifier;
        this.proxyIdentifierSid = proxyIdentifierSid;
        this.dateDeleted = DateConverter.iso8601DateTimeFromString(dateDeleted);
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
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

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getProxyIdentifier() {
        return this.proxyIdentifier;
    }

    public final String getProxyIdentifierSid() {
        return this.proxyIdentifierSid;
    }

    public final ZonedDateTime getDateDeleted() {
        return this.dateDeleted;
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

        Participant other = (Participant) o;

        return Objects.equals(sid, other.sid) && Objects.equals(sessionSid, other.sessionSid)
                && Objects.equals(serviceSid, other.serviceSid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(identifier, other.identifier)
                && Objects.equals(proxyIdentifier, other.proxyIdentifier)
                && Objects.equals(proxyIdentifierSid, other.proxyIdentifierSid)
                && Objects.equals(dateDeleted, other.dateDeleted) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(url, other.url)
                && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sessionSid, serviceSid, accountSid, friendlyName, identifier, proxyIdentifier,
                proxyIdentifierSid, dateDeleted, dateCreated, dateUpdated, url, links);
    }

}
