/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Voice
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.voice.v1.dialingpermissions.country;

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

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class HighriskSpecialPrefix extends Resource {
    private static final long serialVersionUID = 211324910415647L;

    public static HighriskSpecialPrefixReader reader(final String pathIsoCode) {
        return new HighriskSpecialPrefixReader(pathIsoCode);
    }

    /**
     * Converts a JSON String into a HighriskSpecialPrefix object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return HighriskSpecialPrefix object represented by the provided JSON
     */
    public static HighriskSpecialPrefix fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, HighriskSpecialPrefix.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a HighriskSpecialPrefix object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return HighriskSpecialPrefix object represented by the provided JSON
     */
    public static HighriskSpecialPrefix fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, HighriskSpecialPrefix.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String prefix;

    @JsonCreator
    private HighriskSpecialPrefix(
            @JsonProperty("prefix") final String prefix) {
        this.prefix = prefix;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HighriskSpecialPrefix other = (HighriskSpecialPrefix) o;

        return Objects.equals(prefix, other.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix);
    }

}
