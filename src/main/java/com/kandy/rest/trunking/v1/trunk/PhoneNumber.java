/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trunking
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trunking.v1.trunk;

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
public class PhoneNumber extends Resource {
    private static final long serialVersionUID = 92972440584956L;

    public static PhoneNumberCreator creator(final String pathTrunkSid, final String phoneNumberSid) {
        return new PhoneNumberCreator(pathTrunkSid, phoneNumberSid);
    }

    public static PhoneNumberDeleter deleter(final String pathTrunkSid, final String pathSid) {
        return new PhoneNumberDeleter(pathTrunkSid, pathSid);
    }

    public static PhoneNumberFetcher fetcher(final String pathTrunkSid, final String pathSid) {
        return new PhoneNumberFetcher(pathTrunkSid, pathSid);
    }

    public static PhoneNumberReader reader(final String pathTrunkSid) {
        return new PhoneNumberReader(pathTrunkSid);
    }

    /**
     * Converts a JSON String into a PhoneNumber object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return PhoneNumber object represented by the provided JSON
     */
    public static PhoneNumber fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, PhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a PhoneNumber object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return PhoneNumber object represented by the provided JSON
     */
    public static PhoneNumber fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, PhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum AddressRequirement {
        NONE("none"),
        ANY("any"),
        LOCAL("local"),
        FOREIGN("foreign");

        private final String value;

        private AddressRequirement(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static AddressRequirement forValue(final String value) {
            return Promoter.enumFromString(value, AddressRequirement.values());
        }
    }

    private final String accountSid;
    private final PhoneNumber.AddressRequirement addressRequirements;
    private final String apiVersion;
    private final Boolean beta;
    private final Map<String, String> capabilities;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final Map<String, String> links;
    private final com.kandy.type.PhoneNumber phoneNumber;
    private final String sid;
    private final String smsApplicationSid;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String trunkSid;
    private final URI url;
    private final String voiceApplicationSid;
    private final Boolean voiceCallerIdLookup;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final URI voiceUrl;

    @JsonCreator
    private PhoneNumber(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("address_requirements") final PhoneNumber.AddressRequirement addressRequirements,

            @JsonProperty("api_version") final String apiVersion,

            @JsonProperty("beta") final Boolean beta,

            @JsonProperty("capabilities") final Map<String, String> capabilities,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("links") final Map<String, String> links,

            @JsonProperty("phone_number") final com.kandy.type.PhoneNumber phoneNumber,

            @JsonProperty("sid") final String sid,

            @JsonProperty("sms_application_sid") final String smsApplicationSid,

            @JsonProperty("sms_fallback_method") final HttpMethod smsFallbackMethod,

            @JsonProperty("sms_fallback_url") final URI smsFallbackUrl,

            @JsonProperty("sms_method") final HttpMethod smsMethod,

            @JsonProperty("sms_url") final URI smsUrl,

            @JsonProperty("status_callback") final URI statusCallback,

            @JsonProperty("status_callback_method") final HttpMethod statusCallbackMethod,

            @JsonProperty("trunk_sid") final String trunkSid,

            @JsonProperty("url") final URI url,

            @JsonProperty("voice_application_sid") final String voiceApplicationSid,

            @JsonProperty("voice_caller_id_lookup") final Boolean voiceCallerIdLookup,

            @JsonProperty("voice_fallback_method") final HttpMethod voiceFallbackMethod,

            @JsonProperty("voice_fallback_url") final URI voiceFallbackUrl,

            @JsonProperty("voice_method") final HttpMethod voiceMethod,

            @JsonProperty("voice_url") final URI voiceUrl) {
        this.accountSid = accountSid;
        this.addressRequirements = addressRequirements;
        this.apiVersion = apiVersion;
        this.beta = beta;
        this.capabilities = capabilities;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.links = links;
        this.phoneNumber = phoneNumber;
        this.sid = sid;
        this.smsApplicationSid = smsApplicationSid;
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.trunkSid = trunkSid;
        this.url = url;
        this.voiceApplicationSid = voiceApplicationSid;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceUrl = voiceUrl;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final PhoneNumber.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final Boolean getBeta() {
        return this.beta;
    }

    public final Map<String, String> getCapabilities() {
        return this.capabilities;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final Map<String, String> getLinks() {
        return this.links;
    }

    public final com.kandy.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    public final String getTrunkSid() {
        return this.trunkSid;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
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

    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PhoneNumber other = (PhoneNumber) o;

        return Objects.equals(accountSid, other.accountSid)
                && Objects.equals(addressRequirements, other.addressRequirements)
                && Objects.equals(apiVersion, other.apiVersion) && Objects.equals(beta, other.beta)
                && Objects.equals(capabilities, other.capabilities) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(links, other.links) && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(sid, other.sid) && Objects.equals(smsApplicationSid, other.smsApplicationSid)
                && Objects.equals(smsFallbackMethod, other.smsFallbackMethod)
                && Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && Objects.equals(smsMethod, other.smsMethod)
                && Objects.equals(smsUrl, other.smsUrl) && Objects.equals(statusCallback, other.statusCallback)
                && Objects.equals(statusCallbackMethod, other.statusCallbackMethod)
                && Objects.equals(trunkSid, other.trunkSid) && Objects.equals(url, other.url)
                && Objects.equals(voiceApplicationSid, other.voiceApplicationSid)
                && Objects.equals(voiceCallerIdLookup, other.voiceCallerIdLookup)
                && Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod)
                && Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl)
                && Objects.equals(voiceMethod, other.voiceMethod) && Objects.equals(voiceUrl, other.voiceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, addressRequirements, apiVersion, beta, capabilities, dateCreated, dateUpdated,
                friendlyName, links, phoneNumber, sid, smsApplicationSid, smsFallbackMethod, smsFallbackUrl, smsMethod,
                smsUrl, statusCallback, statusCallbackMethod, trunkSid, url, voiceApplicationSid, voiceCallerIdLookup,
                voiceFallbackMethod, voiceFallbackUrl, voiceMethod, voiceUrl);
    }

}
