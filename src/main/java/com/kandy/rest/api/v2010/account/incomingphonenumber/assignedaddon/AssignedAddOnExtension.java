/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Api
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.api.v2010.account.incomingphonenumber.assignedaddon;

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
public class AssignedAddOnExtension extends Resource {
    private static final long serialVersionUID = 103705040276662L;

    public static AssignedAddOnExtensionFetcher fetcher(final String pathResourceSid, final String pathAssignedAddOnSid,
            final String pathSid) {
        return new AssignedAddOnExtensionFetcher(pathResourceSid, pathAssignedAddOnSid, pathSid);
    }

    public static AssignedAddOnExtensionFetcher fetcher(final String pathAccountSid, final String pathResourceSid,
            final String pathAssignedAddOnSid, final String pathSid) {
        return new AssignedAddOnExtensionFetcher(pathAccountSid, pathResourceSid, pathAssignedAddOnSid, pathSid);
    }

    public static AssignedAddOnExtensionReader reader(final String pathResourceSid, final String pathAssignedAddOnSid) {
        return new AssignedAddOnExtensionReader(pathResourceSid, pathAssignedAddOnSid);
    }

    public static AssignedAddOnExtensionReader reader(final String pathAccountSid, final String pathResourceSid,
            final String pathAssignedAddOnSid) {
        return new AssignedAddOnExtensionReader(pathAccountSid, pathResourceSid, pathAssignedAddOnSid);
    }

    /**
     * Converts a JSON String into a AssignedAddOnExtension object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AssignedAddOnExtension object represented by the provided JSON
     */
    public static AssignedAddOnExtension fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssignedAddOnExtension.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AssignedAddOnExtension object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AssignedAddOnExtension object represented by the provided JSON
     */
    public static AssignedAddOnExtension fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssignedAddOnExtension.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String resourceSid;
    private final String assignedAddOnSid;
    private final String friendlyName;
    private final String productName;
    private final String uniqueName;
    private final String uri;
    private final Boolean enabled;

    @JsonCreator
    private AssignedAddOnExtension(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("resource_sid") final String resourceSid,

            @JsonProperty("assigned_add_on_sid") final String assignedAddOnSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("product_name") final String productName,

            @JsonProperty("unique_name") final String uniqueName,

            @JsonProperty("uri") final String uri,

            @JsonProperty("enabled") final Boolean enabled) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.resourceSid = resourceSid;
        this.assignedAddOnSid = assignedAddOnSid;
        this.friendlyName = friendlyName;
        this.productName = productName;
        this.uniqueName = uniqueName;
        this.uri = uri;
        this.enabled = enabled;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getResourceSid() {
        return this.resourceSid;
    }

    public final String getAssignedAddOnSid() {
        return this.assignedAddOnSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getUniqueName() {
        return this.uniqueName;
    }

    public final String getUri() {
        return this.uri;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssignedAddOnExtension other = (AssignedAddOnExtension) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(resourceSid, other.resourceSid)
                && Objects.equals(assignedAddOnSid, other.assignedAddOnSid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(productName, other.productName)
                && Objects.equals(uniqueName, other.uniqueName) && Objects.equals(uri, other.uri)
                && Objects.equals(enabled, other.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, resourceSid, assignedAddOnSid, friendlyName, productName, uniqueName, uri,
                enabled);
    }

}
