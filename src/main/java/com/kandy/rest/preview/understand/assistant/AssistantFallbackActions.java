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

package com.kandy.rest.preview.understand.assistant;

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
public class AssistantFallbackActions extends Resource {
    private static final long serialVersionUID = 52727905251134L;

    public static AssistantFallbackActionsFetcher fetcher(final String pathAssistantSid) {
        return new AssistantFallbackActionsFetcher(pathAssistantSid);
    }

    public static AssistantFallbackActionsUpdater updater(final String pathAssistantSid) {
        return new AssistantFallbackActionsUpdater(pathAssistantSid);
    }

    /**
     * Converts a JSON String into a AssistantFallbackActions object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AssistantFallbackActions object represented by the provided JSON
     */
    public static AssistantFallbackActions fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssistantFallbackActions.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AssistantFallbackActions object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AssistantFallbackActions object represented by the provided JSON
     */
    public static AssistantFallbackActions fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssistantFallbackActions.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String assistantSid;
    private final URI url;
    private final Map<String, Object> data;

    @JsonCreator
    private AssistantFallbackActions(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("assistant_sid") final String assistantSid,

            @JsonProperty("url") final URI url,

            @JsonProperty("data") final Map<String, Object> data) {
        this.accountSid = accountSid;
        this.assistantSid = assistantSid;
        this.url = url;
        this.data = data;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getAssistantSid() {
        return this.assistantSid;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssistantFallbackActions other = (AssistantFallbackActions) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(assistantSid, other.assistantSid)
                && Objects.equals(url, other.url) && Objects.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, assistantSid, url, data);
    }

}
