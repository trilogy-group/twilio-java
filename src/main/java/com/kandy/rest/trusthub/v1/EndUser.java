/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trusthub
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trusthub.v1;

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
public class EndUser extends Resource {
    private static final long serialVersionUID = 90504447987573L;

    public static EndUserCreator creator(final String friendlyName, final String type) {
        return new EndUserCreator(friendlyName, type);
    }

    public static EndUserDeleter deleter(final String pathSid) {
        return new EndUserDeleter(pathSid);
    }

    public static EndUserFetcher fetcher(final String pathSid) {
        return new EndUserFetcher(pathSid);
    }

    public static EndUserReader reader() {
        return new EndUserReader();
    }

    public static EndUserUpdater updater(final String pathSid) {
        return new EndUserUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a EndUser object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return EndUser object represented by the provided JSON
     */
    public static EndUser fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, EndUser.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a EndUser object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return EndUser object represented by the provided JSON
     */
    public static EndUser fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, EndUser.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final String type;
    private final Map<String, Object> attributes;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private EndUser(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("type") final String type,

            @JsonProperty("attributes") final Map<String, Object> attributes,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.type = type;
        this.attributes = attributes;
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

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getType() {
        return this.type;
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
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

        EndUser other = (EndUser) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(type, other.type)
                && Objects.equals(attributes, other.attributes) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, friendlyName, type, attributes, dateCreated, dateUpdated, url);
    }

}
