/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Lookups
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.lookups.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class PhoneNumber extends Resource {
    private static final long serialVersionUID = 224955107223793L;

    public static PhoneNumberFetcher fetcher(final String pathPhoneNumber) {
        return new PhoneNumberFetcher(pathPhoneNumber);
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

    public enum ValidationError {
        TOO_SHORT("TOO_SHORT"),
        TOO_LONG("TOO_LONG"),
        INVALID_BUT_POSSIBLE("INVALID_BUT_POSSIBLE"),
        INVALID_COUNTRY_CODE("INVALID_COUNTRY_CODE"),
        INVALID_LENGTH("INVALID_LENGTH"),
        NOT_A_NUMBER("NOT_A_NUMBER");

        private final String value;

        private ValidationError(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ValidationError forValue(final String value) {
            return Promoter.enumFromString(value, ValidationError.values());
        }
    }

    private final String callingCountryCode;
    private final String countryCode;
    private final com.kandy.type.PhoneNumber phoneNumber;
    private final String nationalFormat;
    private final Boolean valid;
    private final List<PhoneNumber.ValidationError> validationErrors;
    private final Map<String, Object> callerName;
    private final Map<String, Object> simSwap;
    private final Map<String, Object> callForwarding;
    private final Map<String, Object> liveActivity;
    private final Map<String, Object> lineTypeIntelligence;
    private final Map<String, Object> identityMatch;
    private final Map<String, Object> smsPumpingRisk;
    private final URI url;

    @JsonCreator
    private PhoneNumber(
            @JsonProperty("calling_country_code") final String callingCountryCode,

            @JsonProperty("country_code") final String countryCode,

            @JsonProperty("phone_number") final com.kandy.type.PhoneNumber phoneNumber,

            @JsonProperty("national_format") final String nationalFormat,

            @JsonProperty("valid") final Boolean valid,

            @JsonProperty("validation_errors") final List<PhoneNumber.ValidationError> validationErrors,

            @JsonProperty("caller_name") final Map<String, Object> callerName,

            @JsonProperty("sim_swap") final Map<String, Object> simSwap,

            @JsonProperty("call_forwarding") final Map<String, Object> callForwarding,

            @JsonProperty("live_activity") final Map<String, Object> liveActivity,

            @JsonProperty("line_type_intelligence") final Map<String, Object> lineTypeIntelligence,

            @JsonProperty("identity_match") final Map<String, Object> identityMatch,

            @JsonProperty("sms_pumping_risk") final Map<String, Object> smsPumpingRisk,

            @JsonProperty("url") final URI url) {
        this.callingCountryCode = callingCountryCode;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.nationalFormat = nationalFormat;
        this.valid = valid;
        this.validationErrors = validationErrors;
        this.callerName = callerName;
        this.simSwap = simSwap;
        this.callForwarding = callForwarding;
        this.liveActivity = liveActivity;
        this.lineTypeIntelligence = lineTypeIntelligence;
        this.identityMatch = identityMatch;
        this.smsPumpingRisk = smsPumpingRisk;
        this.url = url;
    }

    public final String getCallingCountryCode() {
        return this.callingCountryCode;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final com.kandy.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getNationalFormat() {
        return this.nationalFormat;
    }

    public final Boolean getValid() {
        return this.valid;
    }

    public final List<PhoneNumber.ValidationError> getValidationErrors() {
        return this.validationErrors;
    }

    public final Map<String, Object> getCallerName() {
        return this.callerName;
    }

    public final Map<String, Object> getSimSwap() {
        return this.simSwap;
    }

    public final Map<String, Object> getCallForwarding() {
        return this.callForwarding;
    }

    public final Map<String, Object> getLiveActivity() {
        return this.liveActivity;
    }

    public final Map<String, Object> getLineTypeIntelligence() {
        return this.lineTypeIntelligence;
    }

    public final Map<String, Object> getIdentityMatch() {
        return this.identityMatch;
    }

    public final Map<String, Object> getSmsPumpingRisk() {
        return this.smsPumpingRisk;
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

        PhoneNumber other = (PhoneNumber) o;

        return Objects.equals(callingCountryCode, other.callingCountryCode)
                && Objects.equals(countryCode, other.countryCode) && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(nationalFormat, other.nationalFormat) && Objects.equals(valid, other.valid)
                && Objects.equals(validationErrors, other.validationErrors)
                && Objects.equals(callerName, other.callerName) && Objects.equals(simSwap, other.simSwap)
                && Objects.equals(callForwarding, other.callForwarding)
                && Objects.equals(liveActivity, other.liveActivity)
                && Objects.equals(lineTypeIntelligence, other.lineTypeIntelligence)
                && Objects.equals(identityMatch, other.identityMatch)
                && Objects.equals(smsPumpingRisk, other.smsPumpingRisk) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callingCountryCode, countryCode, phoneNumber, nationalFormat, valid, validationErrors,
                callerName, simSwap, callForwarding, liveActivity, lineTypeIntelligence, identityMatch, smsPumpingRisk,
                url);
    }

}
