/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Messaging
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.messaging.v1;

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
public class LinkshorteningMessagingService extends Resource {
    private static final long serialVersionUID = 242981332247911L;

    public static LinkshorteningMessagingServiceCreator creator(final String pathDomainSid,
            final String pathMessagingServiceSid) {
        return new LinkshorteningMessagingServiceCreator(pathDomainSid, pathMessagingServiceSid);
    }

    public static LinkshorteningMessagingServiceDeleter deleter(final String pathDomainSid,
            final String pathMessagingServiceSid) {
        return new LinkshorteningMessagingServiceDeleter(pathDomainSid, pathMessagingServiceSid);
    }

    /**
     * Converts a JSON String into a LinkshorteningMessagingService object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return LinkshorteningMessagingService object represented by the provided
     *         JSON
     */
    public static LinkshorteningMessagingService fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, LinkshorteningMessagingService.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a LinkshorteningMessagingService object
     * using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return LinkshorteningMessagingService object represented by the provided
     *         JSON
     */
    public static LinkshorteningMessagingService fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, LinkshorteningMessagingService.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String domainSid;
    private final String messagingServiceSid;
    private final URI url;

    @JsonCreator
    private LinkshorteningMessagingService(
            @JsonProperty("domain_sid") final String domainSid,

            @JsonProperty("messaging_service_sid") final String messagingServiceSid,

            @JsonProperty("url") final URI url) {
        this.domainSid = domainSid;
        this.messagingServiceSid = messagingServiceSid;
        this.url = url;
    }

    public final String getDomainSid() {
        return this.domainSid;
    }

    public final String getMessagingServiceSid() {
        return this.messagingServiceSid;
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

        LinkshorteningMessagingService other = (LinkshorteningMessagingService) o;

        return Objects.equals(domainSid, other.domainSid)
                && Objects.equals(messagingServiceSid, other.messagingServiceSid) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domainSid, messagingServiceSid, url);
    }

}
