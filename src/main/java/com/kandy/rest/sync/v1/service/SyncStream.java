/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Sync
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.sync.v1.service;

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
public class SyncStream extends Resource {
    private static final long serialVersionUID = 122709874652370L;

    public static SyncStreamCreator creator(final String pathServiceSid) {
        return new SyncStreamCreator(pathServiceSid);
    }

    public static SyncStreamDeleter deleter(final String pathServiceSid, final String pathSid) {
        return new SyncStreamDeleter(pathServiceSid, pathSid);
    }

    public static SyncStreamFetcher fetcher(final String pathServiceSid, final String pathSid) {
        return new SyncStreamFetcher(pathServiceSid, pathSid);
    }

    public static SyncStreamReader reader(final String pathServiceSid) {
        return new SyncStreamReader(pathServiceSid);
    }

    public static SyncStreamUpdater updater(final String pathServiceSid, final String pathSid) {
        return new SyncStreamUpdater(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a SyncStream object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SyncStream object represented by the provided JSON
     */
    public static SyncStream fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SyncStream.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SyncStream object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SyncStream object represented by the provided JSON
     */
    public static SyncStream fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SyncStream.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String uniqueName;
    private final String accountSid;
    private final String serviceSid;
    private final URI url;
    private final Map<String, String> links;
    private final ZonedDateTime dateExpires;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String createdBy;

    @JsonCreator
    private SyncStream(
            @JsonProperty("sid") final String sid,

            @JsonProperty("unique_name") final String uniqueName,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links,

            @JsonProperty("date_expires") final String dateExpires,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("created_by") final String createdBy) {
        this.sid = sid;
        this.uniqueName = uniqueName;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.url = url;
        this.links = links;
        this.dateExpires = DateConverter.iso8601DateTimeFromString(dateExpires);
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.createdBy = createdBy;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getUniqueName() {
        return this.uniqueName;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Map<String, String> getLinks() {
        return this.links;
    }

    public final ZonedDateTime getDateExpires() {
        return this.dateExpires;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SyncStream other = (SyncStream) o;

        return Objects.equals(sid, other.sid) && Objects.equals(uniqueName, other.uniqueName)
                && Objects.equals(accountSid, other.accountSid) && Objects.equals(serviceSid, other.serviceSid)
                && Objects.equals(url, other.url) && Objects.equals(links, other.links)
                && Objects.equals(dateExpires, other.dateExpires) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(createdBy, other.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, uniqueName, accountSid, serviceSid, url, links, dateExpires, dateCreated, dateUpdated,
                createdBy);
    }

}
