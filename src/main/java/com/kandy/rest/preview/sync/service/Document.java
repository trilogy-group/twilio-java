/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Preview
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.preview.sync.service;

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
public class Document extends Resource {
    private static final long serialVersionUID = 115316298329366L;

    public static DocumentCreator creator(final String pathServiceSid) {
        return new DocumentCreator(pathServiceSid);
    }

    public static DocumentDeleter deleter(final String pathServiceSid, final String pathSid) {
        return new DocumentDeleter(pathServiceSid, pathSid);
    }

    public static DocumentFetcher fetcher(final String pathServiceSid, final String pathSid) {
        return new DocumentFetcher(pathServiceSid, pathSid);
    }

    public static DocumentReader reader(final String pathServiceSid) {
        return new DocumentReader(pathServiceSid);
    }

    public static DocumentUpdater updater(final String pathServiceSid, final String pathSid,
            final Map<String, Object> data) {
        return new DocumentUpdater(pathServiceSid, pathSid, data);
    }

    /**
     * Converts a JSON String into a Document object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Document object represented by the provided JSON
     */
    public static Document fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Document.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Document object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Document object represented by the provided JSON
     */
    public static Document fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Document.class);
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
    private final String revision;
    private final Map<String, Object> data;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String createdBy;

    @JsonCreator
    private Document(
            @JsonProperty("sid") final String sid,

            @JsonProperty("unique_name") final String uniqueName,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links,

            @JsonProperty("revision") final String revision,

            @JsonProperty("data") final Map<String, Object> data,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("created_by") final String createdBy) {
        this.sid = sid;
        this.uniqueName = uniqueName;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.url = url;
        this.links = links;
        this.revision = revision;
        this.data = data;
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

    public final String getRevision() {
        return this.revision;
    }

    public final Map<String, Object> getData() {
        return this.data;
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

        Document other = (Document) o;

        return Objects.equals(sid, other.sid) && Objects.equals(uniqueName, other.uniqueName)
                && Objects.equals(accountSid, other.accountSid) && Objects.equals(serviceSid, other.serviceSid)
                && Objects.equals(url, other.url) && Objects.equals(links, other.links)
                && Objects.equals(revision, other.revision) && Objects.equals(data, other.data)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(createdBy, other.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, uniqueName, accountSid, serviceSid, url, links, revision, data, dateCreated,
                dateUpdated, createdBy);
    }

}
