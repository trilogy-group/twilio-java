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

package com.kandy.rest.preview.marketplace;

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
public class AvailableAddOn extends Resource {
    private static final long serialVersionUID = 265387241353044L;

    public static AvailableAddOnFetcher fetcher(final String pathSid) {
        return new AvailableAddOnFetcher(pathSid);
    }

    public static AvailableAddOnReader reader() {
        return new AvailableAddOnReader();
    }

    /**
     * Converts a JSON String into a AvailableAddOn object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AvailableAddOn object represented by the provided JSON
     */
    public static AvailableAddOn fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AvailableAddOn.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AvailableAddOn object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AvailableAddOn object represented by the provided JSON
     */
    public static AvailableAddOn fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AvailableAddOn.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String friendlyName;
    private final String description;
    private final String pricingType;
    private final Map<String, Object> configurationSchema;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private AvailableAddOn(
            @JsonProperty("sid") final String sid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("description") final String description,

            @JsonProperty("pricing_type") final String pricingType,

            @JsonProperty("configuration_schema") final Map<String, Object> configurationSchema,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links) {
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.description = description;
        this.pricingType = pricingType;
        this.configurationSchema = configurationSchema;
        this.url = url;
        this.links = links;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getPricingType() {
        return this.pricingType;
    }

    public final Map<String, Object> getConfigurationSchema() {
        return this.configurationSchema;
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

        AvailableAddOn other = (AvailableAddOn) o;

        return Objects.equals(sid, other.sid) && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(description, other.description) && Objects.equals(pricingType, other.pricingType)
                && Objects.equals(configurationSchema, other.configurationSchema) && Objects.equals(url, other.url)
                && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, friendlyName, description, pricingType, configurationSchema, url, links);
    }

}
