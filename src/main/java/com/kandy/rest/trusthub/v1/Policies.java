/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trusthub
 * This is the public Kandy REST API.
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
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Policies extends Resource {
    private static final long serialVersionUID = 142613922631852L;

    public static PoliciesFetcher fetcher(final String pathSid) {
        return new PoliciesFetcher(pathSid);
    }

    public static PoliciesReader reader() {
        return new PoliciesReader();
    }

    /**
     * Converts a JSON String into a Policies object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Policies object represented by the provided JSON
     */
    public static Policies fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Policies.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Policies object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Policies object represented by the provided JSON
     */
    public static Policies fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Policies.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String friendlyName;
    private final Map<String, Object> requirements;
    private final URI url;

    @JsonCreator
    private Policies(
            @JsonProperty("sid") final String sid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("requirements") final Map<String, Object> requirements,

            @JsonProperty("url") final URI url) {
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.requirements = requirements;
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final Map<String, Object> getRequirements() {
        return this.requirements;
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

        Policies other = (Policies) o;

        return Objects.equals(sid, other.sid) && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(requirements, other.requirements) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, friendlyName, requirements, url);
    }

}
