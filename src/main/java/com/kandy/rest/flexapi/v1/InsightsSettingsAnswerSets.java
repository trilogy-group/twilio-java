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
public class InsightsSettingsAnswerSets extends Resource {
    private static final long serialVersionUID = 252326702169213L;

    public static InsightsSettingsAnswerSetsFetcher fetcher() {
        return new InsightsSettingsAnswerSetsFetcher();
    }

    /**
     * Converts a JSON String into a InsightsSettingsAnswerSets object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return InsightsSettingsAnswerSets object represented by the provided JSON
     */
    public static InsightsSettingsAnswerSets fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, InsightsSettingsAnswerSets.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a InsightsSettingsAnswerSets object using
     * the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return InsightsSettingsAnswerSets object represented by the provided JSON
     */
    public static InsightsSettingsAnswerSets fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, InsightsSettingsAnswerSets.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Map<String, Object> answerSets;
    private final Map<String, Object> answerSetCategories;
    private final Map<String, Object> notApplicable;
    private final URI url;

    @JsonCreator
    private InsightsSettingsAnswerSets(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("answer_sets") final Map<String, Object> answerSets,

            @JsonProperty("answer_set_categories") final Map<String, Object> answerSetCategories,

            @JsonProperty("not_applicable") final Map<String, Object> notApplicable,

            @JsonProperty("url") final URI url) {
        this.accountSid = accountSid;
        this.answerSets = answerSets;
        this.answerSetCategories = answerSetCategories;
        this.notApplicable = notApplicable;
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final Map<String, Object> getAnswerSets() {
        return this.answerSets;
    }

    public final Map<String, Object> getAnswerSetCategories() {
        return this.answerSetCategories;
    }

    public final Map<String, Object> getNotApplicable() {
        return this.notApplicable;
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

        InsightsSettingsAnswerSets other = (InsightsSettingsAnswerSets) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(answerSets, other.answerSets)
                && Objects.equals(answerSetCategories, other.answerSetCategories)
                && Objects.equals(notApplicable, other.notApplicable) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, answerSets, answerSetCategories, notApplicable, url);
    }

}
