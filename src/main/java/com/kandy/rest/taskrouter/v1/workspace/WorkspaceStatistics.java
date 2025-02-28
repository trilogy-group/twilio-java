/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Taskrouter
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.taskrouter.v1.workspace;

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
public class WorkspaceStatistics extends Resource {
    private static final long serialVersionUID = 274987650256203L;

    public static WorkspaceStatisticsFetcher fetcher(final String pathWorkspaceSid) {
        return new WorkspaceStatisticsFetcher(pathWorkspaceSid);
    }

    /**
     * Converts a JSON String into a WorkspaceStatistics object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return WorkspaceStatistics object represented by the provided JSON
     */
    public static WorkspaceStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkspaceStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a WorkspaceStatistics object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return WorkspaceStatistics object represented by the provided JSON
     */
    public static WorkspaceStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkspaceStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final Map<String, Object> realtime;
    private final Map<String, Object> cumulative;
    private final String accountSid;
    private final String workspaceSid;
    private final URI url;

    @JsonCreator
    private WorkspaceStatistics(
            @JsonProperty("realtime") final Map<String, Object> realtime,

            @JsonProperty("cumulative") final Map<String, Object> cumulative,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("workspace_sid") final String workspaceSid,

            @JsonProperty("url") final URI url) {
        this.realtime = realtime;
        this.cumulative = cumulative;
        this.accountSid = accountSid;
        this.workspaceSid = workspaceSid;
        this.url = url;
    }

    public final Map<String, Object> getRealtime() {
        return this.realtime;
    }

    public final Map<String, Object> getCumulative() {
        return this.cumulative;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getWorkspaceSid() {
        return this.workspaceSid;
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

        WorkspaceStatistics other = (WorkspaceStatistics) o;

        return Objects.equals(realtime, other.realtime) && Objects.equals(cumulative, other.cumulative)
                && Objects.equals(accountSid, other.accountSid) && Objects.equals(workspaceSid, other.workspaceSid)
                && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realtime, cumulative, accountSid, workspaceSid, url);
    }

}
