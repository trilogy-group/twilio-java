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

package com.kandy.rest.api.v2010.account.sip;

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
import com.kandy.http.HttpMethod;

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
public class Domain extends Resource {
    private static final long serialVersionUID = 8213004596487L;

    public static DomainCreator creator(final String domainName) {
        return new DomainCreator(domainName);
    }

    public static DomainCreator creator(final String pathAccountSid, final String domainName) {
        return new DomainCreator(pathAccountSid, domainName);
    }

    public static DomainDeleter deleter(final String pathSid) {
        return new DomainDeleter(pathSid);
    }

    public static DomainDeleter deleter(final String pathAccountSid, final String pathSid) {
        return new DomainDeleter(pathAccountSid, pathSid);
    }

    public static DomainFetcher fetcher(final String pathSid) {
        return new DomainFetcher(pathSid);
    }

    public static DomainFetcher fetcher(final String pathAccountSid, final String pathSid) {
        return new DomainFetcher(pathAccountSid, pathSid);
    }

    public static DomainReader reader() {
        return new DomainReader();
    }

    public static DomainReader reader(final String pathAccountSid) {
        return new DomainReader(pathAccountSid);
    }

    public static DomainUpdater updater(final String pathSid) {
        return new DomainUpdater(pathSid);
    }

    public static DomainUpdater updater(final String pathAccountSid, final String pathSid) {
        return new DomainUpdater(pathAccountSid, pathSid);
    }

    /**
     * Converts a JSON String into a Domain object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Domain object represented by the provided JSON
     */
    public static Domain fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Domain.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Domain object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Domain object represented by the provided JSON
     */
    public static Domain fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Domain.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final String authType;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String domainName;
    private final String friendlyName;
    private final String sid;
    private final String uri;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final HttpMethod voiceStatusCallbackMethod;
    private final URI voiceStatusCallbackUrl;
    private final URI voiceUrl;
    private final Map<String, String> subresourceUris;
    private final Boolean sipRegistration;
    private final Boolean emergencyCallingEnabled;
    private final Boolean secure;
    private final String byocTrunkSid;
    private final String emergencyCallerSid;

    @JsonCreator
    private Domain(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("api_version") final String apiVersion,

            @JsonProperty("auth_type") final String authType,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("domain_name") final String domainName,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("sid") final String sid,

            @JsonProperty("uri") final String uri,

            @JsonProperty("voice_fallback_method") final HttpMethod voiceFallbackMethod,

            @JsonProperty("voice_fallback_url") final URI voiceFallbackUrl,

            @JsonProperty("voice_method") final HttpMethod voiceMethod,

            @JsonProperty("voice_status_callback_method") final HttpMethod voiceStatusCallbackMethod,

            @JsonProperty("voice_status_callback_url") final URI voiceStatusCallbackUrl,

            @JsonProperty("voice_url") final URI voiceUrl,

            @JsonProperty("subresource_uris") final Map<String, String> subresourceUris,

            @JsonProperty("sip_registration") final Boolean sipRegistration,

            @JsonProperty("emergency_calling_enabled") final Boolean emergencyCallingEnabled,

            @JsonProperty("secure") final Boolean secure,

            @JsonProperty("byoc_trunk_sid") final String byocTrunkSid,

            @JsonProperty("emergency_caller_sid") final String emergencyCallerSid) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.authType = authType;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.domainName = domainName;
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.uri = uri;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceStatusCallbackMethod = voiceStatusCallbackMethod;
        this.voiceStatusCallbackUrl = voiceStatusCallbackUrl;
        this.voiceUrl = voiceUrl;
        this.subresourceUris = subresourceUris;
        this.sipRegistration = sipRegistration;
        this.emergencyCallingEnabled = emergencyCallingEnabled;
        this.secure = secure;
        this.byocTrunkSid = byocTrunkSid;
        this.emergencyCallerSid = emergencyCallerSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getDomainName() {
        return this.domainName;
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

    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    public final HttpMethod getVoiceStatusCallbackMethod() {
        return this.voiceStatusCallbackMethod;
    }

    public final URI getVoiceStatusCallbackUrl() {
        return this.voiceStatusCallbackUrl;
    }

    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    public final Boolean getSipRegistration() {
        return this.sipRegistration;
    }

    public final Boolean getEmergencyCallingEnabled() {
        return this.emergencyCallingEnabled;
    }

    public final Boolean getSecure() {
        return this.secure;
    }

    public final String getByocTrunkSid() {
        return this.byocTrunkSid;
    }

    public final String getEmergencyCallerSid() {
        return this.emergencyCallerSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Domain other = (Domain) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(apiVersion, other.apiVersion)
                && Objects.equals(authType, other.authType) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(domainName, other.domainName)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(sid, other.sid)
                && Objects.equals(uri, other.uri) && Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod)
                && Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl)
                && Objects.equals(voiceMethod, other.voiceMethod)
                && Objects.equals(voiceStatusCallbackMethod, other.voiceStatusCallbackMethod)
                && Objects.equals(voiceStatusCallbackUrl, other.voiceStatusCallbackUrl)
                && Objects.equals(voiceUrl, other.voiceUrl) && Objects.equals(subresourceUris, other.subresourceUris)
                && Objects.equals(sipRegistration, other.sipRegistration)
                && Objects.equals(emergencyCallingEnabled, other.emergencyCallingEnabled)
                && Objects.equals(secure, other.secure) && Objects.equals(byocTrunkSid, other.byocTrunkSid)
                && Objects.equals(emergencyCallerSid, other.emergencyCallerSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, apiVersion, authType, dateCreated, dateUpdated, domainName, friendlyName, sid,
                uri, voiceFallbackMethod, voiceFallbackUrl, voiceMethod, voiceStatusCallbackMethod,
                voiceStatusCallbackUrl, voiceUrl, subresourceUris, sipRegistration, emergencyCallingEnabled, secure,
                byocTrunkSid, emergencyCallerSid);
    }

}
