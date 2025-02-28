/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Taskrouter
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.taskrouter.v1.workspace;

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
public class Activity extends Resource {
    private static final long serialVersionUID = 20275383236164L;

    public static ActivityCreator creator(final String pathWorkspaceSid, final String friendlyName) {
        return new ActivityCreator(pathWorkspaceSid, friendlyName);
    }

    public static ActivityDeleter deleter(final String pathWorkspaceSid, final String pathSid) {
        return new ActivityDeleter(pathWorkspaceSid, pathSid);
    }

    public static ActivityFetcher fetcher(final String pathWorkspaceSid, final String pathSid) {
        return new ActivityFetcher(pathWorkspaceSid, pathSid);
    }

    public static ActivityReader reader(final String pathWorkspaceSid) {
        return new ActivityReader(pathWorkspaceSid);
    }

    public static ActivityUpdater updater(final String pathWorkspaceSid, final String pathSid) {
        return new ActivityUpdater(pathWorkspaceSid, pathSid);
    }

    /**
     * Converts a JSON String into a Activity object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Activity object represented by the provided JSON
     */
    public static Activity fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Activity.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Activity object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Activity object represented by the provided JSON
     */
    public static Activity fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Activity.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Boolean available;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final String sid;
    private final String workspaceSid;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Activity(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("available") final Boolean available,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("sid") final String sid,

            @JsonProperty("workspace_sid") final String workspaceSid,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links) {
        this.accountSid = accountSid;
        this.available = available;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.workspaceSid = workspaceSid;
        this.url = url;
        this.links = links;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final Boolean getAvailable() {
        return this.available;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getWorkspaceSid() {
        return this.workspaceSid;
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

        Activity other = (Activity) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(available, other.available)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(sid, other.sid)
                && Objects.equals(workspaceSid, other.workspaceSid) && Objects.equals(url, other.url)
                && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, available, dateCreated, dateUpdated, friendlyName, sid, workspaceSid, url,
                links);
    }

}
