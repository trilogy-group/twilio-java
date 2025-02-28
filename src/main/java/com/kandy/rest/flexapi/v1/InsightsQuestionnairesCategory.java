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

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class InsightsQuestionnairesCategory extends Resource {
    private static final long serialVersionUID = 80122837059940L;

    public static InsightsQuestionnairesCategoryCreator creator(final String name) {
        return new InsightsQuestionnairesCategoryCreator(name);
    }

    public static InsightsQuestionnairesCategoryDeleter deleter(final String pathCategorySid) {
        return new InsightsQuestionnairesCategoryDeleter(pathCategorySid);
    }

    public static InsightsQuestionnairesCategoryReader reader() {
        return new InsightsQuestionnairesCategoryReader();
    }

    public static InsightsQuestionnairesCategoryUpdater updater(final String pathCategorySid, final String name) {
        return new InsightsQuestionnairesCategoryUpdater(pathCategorySid, name);
    }

    /**
     * Converts a JSON String into a InsightsQuestionnairesCategory object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return InsightsQuestionnairesCategory object represented by the provided
     *         JSON
     */
    public static InsightsQuestionnairesCategory fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, InsightsQuestionnairesCategory.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a InsightsQuestionnairesCategory object
     * using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return InsightsQuestionnairesCategory object represented by the provided
     *         JSON
     */
    public static InsightsQuestionnairesCategory fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, InsightsQuestionnairesCategory.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String categorySid;
    private final String name;
    private final URI url;

    @JsonCreator
    private InsightsQuestionnairesCategory(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("category_sid") final String categorySid,

            @JsonProperty("name") final String name,

            @JsonProperty("url") final URI url) {
        this.accountSid = accountSid;
        this.categorySid = categorySid;
        this.name = name;
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getCategorySid() {
        return this.categorySid;
    }

    public final String getName() {
        return this.name;
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

        InsightsQuestionnairesCategory other = (InsightsQuestionnairesCategory) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(categorySid, other.categorySid)
                && Objects.equals(name, other.name) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, categorySid, name, url);
    }

}
