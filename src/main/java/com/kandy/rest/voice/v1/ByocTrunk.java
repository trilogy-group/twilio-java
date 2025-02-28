/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Voice
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.voice.v1;

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

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ByocTrunk extends Resource {
    private static final long serialVersionUID = 49034684015367L;

    public static ByocTrunkCreator creator() {
        return new ByocTrunkCreator();
    }

    public static ByocTrunkDeleter deleter(final String pathSid) {
        return new ByocTrunkDeleter(pathSid);
    }

    public static ByocTrunkFetcher fetcher(final String pathSid) {
        return new ByocTrunkFetcher(pathSid);
    }

    public static ByocTrunkReader reader() {
        return new ByocTrunkReader();
    }

    public static ByocTrunkUpdater updater(final String pathSid) {
        return new ByocTrunkUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a ByocTrunk object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ByocTrunk object represented by the provided JSON
     */
    public static ByocTrunk fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ByocTrunk.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ByocTrunk object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ByocTrunk object represented by the provided JSON
     */
    public static ByocTrunk fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ByocTrunk.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final String friendlyName;
    private final URI voiceUrl;
    private final HttpMethod voiceMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceFallbackMethod;
    private final URI statusCallbackUrl;
    private final HttpMethod statusCallbackMethod;
    private final Boolean cnamLookupEnabled;
    private final String connectionPolicySid;
    private final String fromDomainSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private ByocTrunk(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("sid") final String sid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("voice_url") final URI voiceUrl,

            @JsonProperty("voice_method") final HttpMethod voiceMethod,

            @JsonProperty("voice_fallback_url") final URI voiceFallbackUrl,

            @JsonProperty("voice_fallback_method") final HttpMethod voiceFallbackMethod,

            @JsonProperty("status_callback_url") final URI statusCallbackUrl,

            @JsonProperty("status_callback_method") final HttpMethod statusCallbackMethod,

            @JsonProperty("cnam_lookup_enabled") final Boolean cnamLookupEnabled,

            @JsonProperty("connection_policy_sid") final String connectionPolicySid,

            @JsonProperty("from_domain_sid") final String fromDomainSid,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("url") final URI url) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.voiceUrl = voiceUrl;
        this.voiceMethod = voiceMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.statusCallbackUrl = statusCallbackUrl;
        this.statusCallbackMethod = statusCallbackMethod;
        this.cnamLookupEnabled = cnamLookupEnabled;
        this.connectionPolicySid = connectionPolicySid;
        this.fromDomainSid = fromDomainSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    public final URI getStatusCallbackUrl() {
        return this.statusCallbackUrl;
    }

    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    public final Boolean getCnamLookupEnabled() {
        return this.cnamLookupEnabled;
    }

    public final String getConnectionPolicySid() {
        return this.connectionPolicySid;
    }

    public final String getFromDomainSid() {
        return this.fromDomainSid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
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

        ByocTrunk other = (ByocTrunk) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(sid, other.sid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(voiceUrl, other.voiceUrl)
                && Objects.equals(voiceMethod, other.voiceMethod)
                && Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl)
                && Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod)
                && Objects.equals(statusCallbackUrl, other.statusCallbackUrl)
                && Objects.equals(statusCallbackMethod, other.statusCallbackMethod)
                && Objects.equals(cnamLookupEnabled, other.cnamLookupEnabled)
                && Objects.equals(connectionPolicySid, other.connectionPolicySid)
                && Objects.equals(fromDomainSid, other.fromDomainSid) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, sid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod,
                statusCallbackUrl, statusCallbackMethod, cnamLookupEnabled, connectionPolicySid, fromDomainSid,
                dateCreated, dateUpdated, url);
    }

}
