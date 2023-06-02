/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Studio
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.studio.v2.flow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class FlowTestUser extends Resource {
    private static final long serialVersionUID = 221844198208701L;

    public static FlowTestUserFetcher fetcher(final String pathSid) {
        return new FlowTestUserFetcher(pathSid);
    }

    public static FlowTestUserUpdater updater(final String pathSid, final List<String> testUsers) {
        return new FlowTestUserUpdater(pathSid, testUsers);
    }

    /**
     * Converts a JSON String into a FlowTestUser object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return FlowTestUser object represented by the provided JSON
     */
    public static FlowTestUser fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FlowTestUser.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a FlowTestUser object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return FlowTestUser object represented by the provided JSON
     */
    public static FlowTestUser fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FlowTestUser.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final List<String> testUsers;
    private final URI url;

    @JsonCreator
    private FlowTestUser(
            @JsonProperty("sid") final String sid,

            @JsonProperty("test_users") final List<String> testUsers,

            @JsonProperty("url") final URI url) {
        this.sid = sid;
        this.testUsers = testUsers;
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final List<String> getTestUsers() {
        return this.testUsers;
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

        FlowTestUser other = (FlowTestUser) o;

        return Objects.equals(sid, other.sid) && Objects.equals(testUsers, other.testUsers)
                && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, testUsers, url);
    }

}
