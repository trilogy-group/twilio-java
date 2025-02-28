/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Serverless
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.serverless.v1.service.function;

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

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class FunctionVersion extends Resource {
    private static final long serialVersionUID = 85534066966494L;

    public static FunctionVersionFetcher fetcher(final String pathServiceSid, final String pathFunctionSid,
            final String pathSid) {
        return new FunctionVersionFetcher(pathServiceSid, pathFunctionSid, pathSid);
    }

    public static FunctionVersionReader reader(final String pathServiceSid, final String pathFunctionSid) {
        return new FunctionVersionReader(pathServiceSid, pathFunctionSid);
    }

    /**
     * Converts a JSON String into a FunctionVersion object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return FunctionVersion object represented by the provided JSON
     */
    public static FunctionVersion fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FunctionVersion.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a FunctionVersion object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return FunctionVersion object represented by the provided JSON
     */
    public static FunctionVersion fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FunctionVersion.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Visibility {
        PUBLIC("public"),
        PRIVATE("private"),
        PROTECTED("protected");

        private final String value;

        private Visibility(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Visibility forValue(final String value) {
            return Promoter.enumFromString(value, Visibility.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String functionSid;
    private final String path;
    private final FunctionVersion.Visibility visibility;
    private final ZonedDateTime dateCreated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private FunctionVersion(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("function_sid") final String functionSid,

            @JsonProperty("path") final String path,

            @JsonProperty("visibility") final FunctionVersion.Visibility visibility,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("url") final URI url,

            @JsonProperty("links") final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.functionSid = functionSid;
        this.path = path;
        this.visibility = visibility;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
        this.links = links;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final String getFunctionSid() {
        return this.functionSid;
    }

    public final String getPath() {
        return this.path;
    }

    public final FunctionVersion.Visibility getVisibility() {
        return this.visibility;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
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

        FunctionVersion other = (FunctionVersion) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(serviceSid, other.serviceSid) && Objects.equals(functionSid, other.functionSid)
                && Objects.equals(path, other.path) && Objects.equals(visibility, other.visibility)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(url, other.url)
                && Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, serviceSid, functionSid, path, visibility, dateCreated, url, links);
    }

}
