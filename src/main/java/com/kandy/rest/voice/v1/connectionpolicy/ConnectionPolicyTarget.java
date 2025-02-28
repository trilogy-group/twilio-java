/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Voice
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.voice.v1.connectionpolicy;

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

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ConnectionPolicyTarget extends Resource {
    private static final long serialVersionUID = 117046725474544L;

    public static ConnectionPolicyTargetCreator creator(final String pathConnectionPolicySid, final URI target) {
        return new ConnectionPolicyTargetCreator(pathConnectionPolicySid, target);
    }

    public static ConnectionPolicyTargetDeleter deleter(final String pathConnectionPolicySid, final String pathSid) {
        return new ConnectionPolicyTargetDeleter(pathConnectionPolicySid, pathSid);
    }

    public static ConnectionPolicyTargetFetcher fetcher(final String pathConnectionPolicySid, final String pathSid) {
        return new ConnectionPolicyTargetFetcher(pathConnectionPolicySid, pathSid);
    }

    public static ConnectionPolicyTargetReader reader(final String pathConnectionPolicySid) {
        return new ConnectionPolicyTargetReader(pathConnectionPolicySid);
    }

    public static ConnectionPolicyTargetUpdater updater(final String pathConnectionPolicySid, final String pathSid) {
        return new ConnectionPolicyTargetUpdater(pathConnectionPolicySid, pathSid);
    }

    /**
     * Converts a JSON String into a ConnectionPolicyTarget object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ConnectionPolicyTarget object represented by the provided JSON
     */
    public static ConnectionPolicyTarget fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ConnectionPolicyTarget.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ConnectionPolicyTarget object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ConnectionPolicyTarget object represented by the provided JSON
     */
    public static ConnectionPolicyTarget fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ConnectionPolicyTarget.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String connectionPolicySid;
    private final String sid;
    private final String friendlyName;
    private final URI target;
    private final Integer priority;
    private final Integer weight;
    private final Boolean enabled;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private ConnectionPolicyTarget(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("connection_policy_sid") final String connectionPolicySid,

            @JsonProperty("sid") final String sid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("target") final URI target,

            @JsonProperty("priority") final Integer priority,

            @JsonProperty("weight") final Integer weight,

            @JsonProperty("enabled") final Boolean enabled,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url) {
        this.accountSid = accountSid;
        this.connectionPolicySid = connectionPolicySid;
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.target = target;
        this.priority = priority;
        this.weight = weight;
        this.enabled = enabled;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getConnectionPolicySid() {
        return this.connectionPolicySid;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final URI getTarget() {
        return this.target;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getWeight() {
        return this.weight;
    }

    public final Boolean getEnabled() {
        return this.enabled;
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

        ConnectionPolicyTarget other = (ConnectionPolicyTarget) o;

        return Objects.equals(accountSid, other.accountSid)
                && Objects.equals(connectionPolicySid, other.connectionPolicySid) && Objects.equals(sid, other.sid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(target, other.target)
                && Objects.equals(priority, other.priority) && Objects.equals(weight, other.weight)
                && Objects.equals(enabled, other.enabled) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, connectionPolicySid, sid, friendlyName, target, priority, weight, enabled,
                dateCreated, dateUpdated, url);
    }

}
