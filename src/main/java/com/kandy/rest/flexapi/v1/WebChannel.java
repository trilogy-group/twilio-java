/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Flex
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.flexapi.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.converter.DateConverter;
import com.kandy.converter.Promoter;
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
public class WebChannel extends Resource {
    private static final long serialVersionUID = 55535071818984L;

    public static WebChannelCreator creator(final String flexFlowSid, final String identity,
            final String customerFriendlyName, final String chatFriendlyName) {
        return new WebChannelCreator(flexFlowSid, identity, customerFriendlyName, chatFriendlyName);
    }

    public static WebChannelDeleter deleter(final String pathSid) {
        return new WebChannelDeleter(pathSid);
    }

    public static WebChannelFetcher fetcher(final String pathSid) {
        return new WebChannelFetcher(pathSid);
    }

    public static WebChannelReader reader() {
        return new WebChannelReader();
    }

    public static WebChannelUpdater updater(final String pathSid) {
        return new WebChannelUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a WebChannel object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return WebChannel object represented by the provided JSON
     */
    public static WebChannel fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WebChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a WebChannel object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return WebChannel object represented by the provided JSON
     */
    public static WebChannel fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WebChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum ChatStatus {
        INACTIVE("inactive");

        private final String value;

        private ChatStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ChatStatus forValue(final String value) {
            return Promoter.enumFromString(value, ChatStatus.values());
        }
    }

    private final String accountSid;
    private final String flexFlowSid;
    private final String sid;
    private final URI url;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;

    @JsonCreator
    private WebChannel(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("flex_flow_sid") final String flexFlowSid,

            @JsonProperty("sid") final String sid,

            @JsonProperty("url") final URI url,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated) {
        this.accountSid = accountSid;
        this.flexFlowSid = flexFlowSid;
        this.sid = sid;
        this.url = url;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFlexFlowSid() {
        return this.flexFlowSid;
    }

    public final String getSid() {
        return this.sid;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WebChannel other = (WebChannel) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(flexFlowSid, other.flexFlowSid)
                && Objects.equals(sid, other.sid) && Objects.equals(url, other.url)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, flexFlowSid, sid, url, dateCreated, dateUpdated);
    }

}
