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

package com.kandy.rest.api.v2010.account.sip.domain;

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

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class IpAccessControlListMapping extends Resource {
    private static final long serialVersionUID = 220550473371145L;

    public static IpAccessControlListMappingCreator creator(final String pathDomainSid,
            final String ipAccessControlListSid) {
        return new IpAccessControlListMappingCreator(pathDomainSid, ipAccessControlListSid);
    }

    public static IpAccessControlListMappingCreator creator(final String pathAccountSid, final String pathDomainSid,
            final String ipAccessControlListSid) {
        return new IpAccessControlListMappingCreator(pathAccountSid, pathDomainSid, ipAccessControlListSid);
    }

    public static IpAccessControlListMappingDeleter deleter(final String pathDomainSid, final String pathSid) {
        return new IpAccessControlListMappingDeleter(pathDomainSid, pathSid);
    }

    public static IpAccessControlListMappingDeleter deleter(final String pathAccountSid, final String pathDomainSid,
            final String pathSid) {
        return new IpAccessControlListMappingDeleter(pathAccountSid, pathDomainSid, pathSid);
    }

    public static IpAccessControlListMappingFetcher fetcher(final String pathDomainSid, final String pathSid) {
        return new IpAccessControlListMappingFetcher(pathDomainSid, pathSid);
    }

    public static IpAccessControlListMappingFetcher fetcher(final String pathAccountSid, final String pathDomainSid,
            final String pathSid) {
        return new IpAccessControlListMappingFetcher(pathAccountSid, pathDomainSid, pathSid);
    }

    public static IpAccessControlListMappingReader reader(final String pathDomainSid) {
        return new IpAccessControlListMappingReader(pathDomainSid);
    }

    public static IpAccessControlListMappingReader reader(final String pathAccountSid, final String pathDomainSid) {
        return new IpAccessControlListMappingReader(pathAccountSid, pathDomainSid);
    }

    /**
     * Converts a JSON String into a IpAccessControlListMapping object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return IpAccessControlListMapping object represented by the provided JSON
     */
    public static IpAccessControlListMapping fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlListMapping.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a IpAccessControlListMapping object using
     * the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return IpAccessControlListMapping object represented by the provided JSON
     */
    public static IpAccessControlListMapping fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlListMapping.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String domainSid;
    private final String friendlyName;
    private final String sid;
    private final String uri;

    @JsonCreator
    private IpAccessControlListMapping(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("domain_sid") final String domainSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("sid") final String sid,

            @JsonProperty("uri") final String uri) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.domainSid = domainSid;
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.uri = uri;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getDomainSid() {
        return this.domainSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IpAccessControlListMapping other = (IpAccessControlListMapping) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(domainSid, other.domainSid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(sid, other.sid)
                && Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, dateCreated, dateUpdated, domainSid, friendlyName, sid, uri);
    }

}
