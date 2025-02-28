/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Microvisor
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.microvisor.v1.app;

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

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AppManifest extends Resource {
    private static final long serialVersionUID = 249809073531699L;

    public static AppManifestFetcher fetcher(final String pathAppSid) {
        return new AppManifestFetcher(pathAppSid);
    }

    /**
     * Converts a JSON String into a AppManifest object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AppManifest object represented by the provided JSON
     */
    public static AppManifest fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AppManifest.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AppManifest object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AppManifest object represented by the provided JSON
     */
    public static AppManifest fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AppManifest.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String appSid;
    private final String hash;
    private final String encodedBytes;
    private final URI url;

    @JsonCreator
    private AppManifest(
            @JsonProperty("app_sid") final String appSid,

            @JsonProperty("hash") final String hash,

            @JsonProperty("encoded_bytes") final String encodedBytes,

            @JsonProperty("url") final URI url) {
        this.appSid = appSid;
        this.hash = hash;
        this.encodedBytes = encodedBytes;
        this.url = url;
    }

    public final String getAppSid() {
        return this.appSid;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getEncodedBytes() {
        return this.encodedBytes;
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

        AppManifest other = (AppManifest) o;

        return Objects.equals(appSid, other.appSid) && Objects.equals(hash, other.hash)
                && Objects.equals(encodedBytes, other.encodedBytes) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appSid, hash, encodedBytes, url);
    }

}
