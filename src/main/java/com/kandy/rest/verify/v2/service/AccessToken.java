/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.verify.v2.service;

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
public class AccessToken extends Resource {
    private static final long serialVersionUID = 272179273532388L;

    public static AccessTokenCreator creator(final String pathServiceSid, final String identity,
            final AccessToken.FactorTypes factorType) {
        return new AccessTokenCreator(pathServiceSid, identity, factorType);
    }

    public static AccessTokenFetcher fetcher(final String pathServiceSid, final String pathSid) {
        return new AccessTokenFetcher(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a AccessToken object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AccessToken object represented by the provided JSON
     */
    public static AccessToken fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AccessToken.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AccessToken object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AccessToken object represented by the provided JSON
     */
    public static AccessToken fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AccessToken.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum FactorTypes {
        PUSH("push");

        private final String value;

        private FactorTypes(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static FactorTypes forValue(final String value) {
            return Promoter.enumFromString(value, FactorTypes.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String entityIdentity;
    private final AccessToken.FactorTypes factorType;
    private final String factorFriendlyName;
    private final String token;
    private final URI url;
    private final Integer ttl;
    private final ZonedDateTime dateCreated;

    @JsonCreator
    private AccessToken(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("service_sid") final String serviceSid,

            @JsonProperty("entity_identity") final String entityIdentity,

            @JsonProperty("factor_type") final AccessToken.FactorTypes factorType,

            @JsonProperty("factor_friendly_name") final String factorFriendlyName,

            @JsonProperty("token") final String token,

            @JsonProperty("url") final URI url,

            @JsonProperty("ttl") final Integer ttl,

            @JsonProperty("date_created") final String dateCreated) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.entityIdentity = entityIdentity;
        this.factorType = factorType;
        this.factorFriendlyName = factorFriendlyName;
        this.token = token;
        this.url = url;
        this.ttl = ttl;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
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

    public final String getEntityIdentity() {
        return this.entityIdentity;
    }

    public final AccessToken.FactorTypes getFactorType() {
        return this.factorType;
    }

    public final String getFactorFriendlyName() {
        return this.factorFriendlyName;
    }

    public final String getToken() {
        return this.token;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Integer getTtl() {
        return this.ttl;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccessToken other = (AccessToken) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(serviceSid, other.serviceSid) && Objects.equals(entityIdentity, other.entityIdentity)
                && Objects.equals(factorType, other.factorType)
                && Objects.equals(factorFriendlyName, other.factorFriendlyName) && Objects.equals(token, other.token)
                && Objects.equals(url, other.url) && Objects.equals(ttl, other.ttl)
                && Objects.equals(dateCreated, other.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, serviceSid, entityIdentity, factorType, factorFriendlyName, token, url,
                ttl, dateCreated);
    }

}
