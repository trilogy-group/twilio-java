/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Content
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.content.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.converter.DateConverter;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ContentAndApprovals extends Resource {
    private static final long serialVersionUID = 67575038421166L;

    public static ContentAndApprovalsReader reader() {
        return new ContentAndApprovalsReader();
    }

    /**
     * Converts a JSON String into a ContentAndApprovals object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ContentAndApprovals object represented by the provided JSON
     */
    public static ContentAndApprovals fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ContentAndApprovals.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ContentAndApprovals object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ContentAndApprovals object represented by the provided JSON
     */
    public static ContentAndApprovals fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ContentAndApprovals.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final String language;
    private final Map<String, Object> variables;
    private final Map<String, Object> types;
    private final Map<String, Object> approvalRequests;

    @JsonCreator
    private ContentAndApprovals(
            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("language") final String language,

            @JsonProperty("variables") final Map<String, Object> variables,

            @JsonProperty("types") final Map<String, Object> types,

            @JsonProperty("approval_requests") final Map<String, Object> approvalRequests) {
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.language = language;
        this.variables = variables;
        this.types = types;
        this.approvalRequests = approvalRequests;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Map<String, Object> getVariables() {
        return this.variables;
    }

    public final Map<String, Object> getTypes() {
        return this.types;
    }

    public final Map<String, Object> getApprovalRequests() {
        return this.approvalRequests;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ContentAndApprovals other = (ContentAndApprovals) o;

        return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(language, other.language)
                && Objects.equals(variables, other.variables) && Objects.equals(types, other.types)
                && Objects.equals(approvalRequests, other.approvalRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCreated, dateUpdated, sid, accountSid, friendlyName, language, variables, types,
                approvalRequests);
    }

}
