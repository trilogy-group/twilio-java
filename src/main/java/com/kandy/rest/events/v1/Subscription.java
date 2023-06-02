/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Events
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.events.v1;

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

import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Subscription extends Resource {
    private static final long serialVersionUID = 198248500185102L;

    public static SubscriptionCreator creator(final String description, final String sinkSid,
            final List<Map<String, Object>> types) {
        return new SubscriptionCreator(description, sinkSid, types);
    }

    public static SubscriptionDeleter deleter(final String pathSid) {
        return new SubscriptionDeleter(pathSid);
    }

    public static SubscriptionFetcher fetcher(final String pathSid) {
        return new SubscriptionFetcher(pathSid);
    }

    public static SubscriptionReader reader() {
        return new SubscriptionReader();
    }

    public static SubscriptionUpdater updater(final String pathSid) {
        return new SubscriptionUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a Subscription object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Subscription object represented by the provided JSON
     */
    public static Subscription fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Subscription.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Subscription object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Subscription object represented by the provided JSON
     */
    public static Subscription fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Subscription.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String description;
    private final String sinkSid;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Subscription(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("sid") final String sid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("description") final String description,

            @JsonProperty("sink_sid") final String sinkSid,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.description = description;
        this.sinkSid = sinkSid;
        this.url = url;
        this.links = links;
    }

    public final String getAccountSid() {
        return this.accountSid;
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

    public final String getDescription() {
        return this.description;
    }

    public final String getSinkSid() {
        return this.sinkSid;
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

        Subscription other = (Subscription) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(sid, other.sid)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(description, other.description) && Objects.equals(sinkSid, other.sinkSid)
                && Objects.equals(url, other.url) && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, sid, dateCreated, dateUpdated, description, sinkSid, url, links);
    }

}
