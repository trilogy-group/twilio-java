/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Supersim
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.supersim.v1;

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
import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Network extends Resource {
    private static final long serialVersionUID = 225839080791216L;

    public static NetworkFetcher fetcher(final String pathSid) {
        return new NetworkFetcher(pathSid);
    }

    public static NetworkReader reader() {
        return new NetworkReader();
    }

    /**
     * Converts a JSON String into a Network object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Network object represented by the provided JSON
     */
    public static Network fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Network.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Network object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Network object represented by the provided JSON
     */
    public static Network fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Network.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String friendlyName;
    private final URI url;
    private final String isoCountry;
    private final List<Map<String, Object>> identifiers;

    @JsonCreator
    private Network(
            @JsonProperty("sid") final String sid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("url") final URI url,

            @JsonProperty("iso_country") final String isoCountry,

            @JsonProperty("identifiers") final List<Map<String, Object>> identifiers) {
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.url = url;
        this.isoCountry = isoCountry;
        this.identifiers = identifiers;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final String getIsoCountry() {
        return this.isoCountry;
    }

    public final List<Map<String, Object>> getIdentifiers() {
        return this.identifiers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Network other = (Network) o;

        return Objects.equals(sid, other.sid) && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(url, other.url) && Objects.equals(isoCountry, other.isoCountry)
                && Objects.equals(identifiers, other.identifiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, friendlyName, url, isoCountry, identifiers);
    }

}
