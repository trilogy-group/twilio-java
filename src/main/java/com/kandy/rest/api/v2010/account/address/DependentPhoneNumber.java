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

package com.kandy.rest.api.v2010.account.address;

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
public class DependentPhoneNumber extends Resource {
    private static final long serialVersionUID = 170982689441309L;

    public static DependentPhoneNumberReader reader(final String pathAddressSid) {
        return new DependentPhoneNumberReader(pathAddressSid);
    }

    public static DependentPhoneNumberReader reader(final String pathAccountSid, final String pathAddressSid) {
        return new DependentPhoneNumberReader(pathAccountSid, pathAddressSid);
    }

    /**
     * Converts a JSON String into a DependentPhoneNumber object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return DependentPhoneNumber object represented by the provided JSON
     */
    public static DependentPhoneNumber fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DependentPhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a DependentPhoneNumber object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return DependentPhoneNumber object represented by the provided JSON
     */
    public static DependentPhoneNumber fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DependentPhoneNumber.class);
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

    public enum EmergencyStatus {
        ACTIVE("Active"),
        INACTIVE("Inactive");

        private final String value;

        private EmergencyStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static EmergencyStatus forValue(final String value) {
            return Promoter.enumFromString(value, EmergencyStatus.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final com.kandy.type.PhoneNumber friendlyName;
    private final com.kandy.type.PhoneNumber phoneNumber;
    private final URI voiceUrl;
    private final HttpMethod voiceMethod;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final Boolean voiceCallerIdLookup;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final DependentPhoneNumber.AddressRequirement addressRequirements;
    private final Map<String, Object> capabilities;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String apiVersion;
    private final String smsApplicationSid;
    private final String voiceApplicationSid;
    private final String trunkSid;
    private final DependentPhoneNumber.EmergencyStatus emergencyStatus;
    private final String emergencyAddressSid;
    private final String uri;

    @JsonCreator
    private DependentPhoneNumber(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("friendly_name") final com.kandy.type.PhoneNumber friendlyName,

            @JsonProperty("phone_number") final com.kandy.type.PhoneNumber phoneNumber,

            @JsonProperty("voice_url") final URI voiceUrl,

            @JsonProperty("voice_method") final HttpMethod voiceMethod,

            @JsonProperty("voice_fallback_method") final HttpMethod voiceFallbackMethod,

            @JsonProperty("voice_fallback_url") final URI voiceFallbackUrl,

            @JsonProperty("voice_caller_id_lookup") final Boolean voiceCallerIdLookup,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("sms_fallback_method") final HttpMethod smsFallbackMethod,

            @JsonProperty("sms_fallback_url") final URI smsFallbackUrl,

            @JsonProperty("sms_method") final HttpMethod smsMethod,

            @JsonProperty("sms_url") final URI smsUrl,

            @JsonProperty("address_requirements") final DependentPhoneNumber.AddressRequirement addressRequirements,

            @JsonProperty("capabilities") final Map<String, Object> capabilities,

            @JsonProperty("status_callback") final URI statusCallback,

            @JsonProperty("status_callback_method") final HttpMethod statusCallbackMethod,

            @JsonProperty("api_version") final String apiVersion,

            @JsonProperty("sms_application_sid") final String smsApplicationSid,

            @JsonProperty("voice_application_sid") final String voiceApplicationSid,

            @JsonProperty("trunk_sid") final String trunkSid,

            @JsonProperty("emergency_status") final DependentPhoneNumber.EmergencyStatus emergencyStatus,

            @JsonProperty("emergency_address_sid") final String emergencyAddressSid,

            @JsonProperty("uri") final String uri) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.phoneNumber = phoneNumber;
        this.voiceUrl = voiceUrl;
        this.voiceMethod = voiceMethod;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.addressRequirements = addressRequirements;
        this.capabilities = capabilities;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.apiVersion = apiVersion;
        this.smsApplicationSid = smsApplicationSid;
        this.voiceApplicationSid = voiceApplicationSid;
        this.trunkSid = trunkSid;
        this.emergencyStatus = emergencyStatus;
        this.emergencyAddressSid = emergencyAddressSid;
        this.uri = uri;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final com.kandy.type.PhoneNumber getFriendlyName() {
        return this.friendlyName;
    }

    public final com.kandy.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
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

    public final DependentPhoneNumber.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    public final Map<String, Object> getCapabilities() {
        return this.capabilities;
    }

    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    public final String getTrunkSid() {
        return this.trunkSid;
    }

    public final DependentPhoneNumber.EmergencyStatus getEmergencyStatus() {
        return this.emergencyStatus;
    }

    public final String getEmergencyAddressSid() {
        return this.emergencyAddressSid;
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

        DependentPhoneNumber other = (DependentPhoneNumber) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(voiceUrl, other.voiceUrl) && Objects.equals(voiceMethod, other.voiceMethod)
                && Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod)
                && Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl)
                && Objects.equals(voiceCallerIdLookup, other.voiceCallerIdLookup)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(smsFallbackMethod, other.smsFallbackMethod)
                && Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && Objects.equals(smsMethod, other.smsMethod)
                && Objects.equals(smsUrl, other.smsUrl)
                && Objects.equals(addressRequirements, other.addressRequirements)
                && Objects.equals(capabilities, other.capabilities)
                && Objects.equals(statusCallback, other.statusCallback)
                && Objects.equals(statusCallbackMethod, other.statusCallbackMethod)
                && Objects.equals(apiVersion, other.apiVersion)
                && Objects.equals(smsApplicationSid, other.smsApplicationSid)
                && Objects.equals(voiceApplicationSid, other.voiceApplicationSid)
                && Objects.equals(trunkSid, other.trunkSid) && Objects.equals(emergencyStatus, other.emergencyStatus)
                && Objects.equals(emergencyAddressSid, other.emergencyAddressSid) && Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, friendlyName, phoneNumber, voiceUrl, voiceMethod, voiceFallbackMethod,
                voiceFallbackUrl, voiceCallerIdLookup, dateCreated, dateUpdated, smsFallbackMethod, smsFallbackUrl,
                smsMethod, smsUrl, addressRequirements, capabilities, statusCallback, statusCallbackMethod, apiVersion,
                smsApplicationSid, voiceApplicationSid, trunkSid, emergencyStatus, emergencyAddressSid, uri);
    }

}
