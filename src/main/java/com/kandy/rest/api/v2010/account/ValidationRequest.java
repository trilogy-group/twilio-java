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

package com.kandy.rest.api.v2010.account;

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
public class ValidationRequest extends Resource {
    private static final long serialVersionUID = 159203610764140L;

    public static ValidationRequestCreator creator(final com.kandy.type.PhoneNumber phoneNumber) {
        return new ValidationRequestCreator(phoneNumber);
    }

    public static ValidationRequestCreator creator(final String pathAccountSid,
            final com.kandy.type.PhoneNumber phoneNumber) {
        return new ValidationRequestCreator(pathAccountSid, phoneNumber);
    }

    /**
     * Converts a JSON String into a ValidationRequest object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ValidationRequest object represented by the provided JSON
     */
    public static ValidationRequest fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ValidationRequest.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ValidationRequest object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ValidationRequest object represented by the provided JSON
     */
    public static ValidationRequest fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ValidationRequest.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String callSid;
    private final String friendlyName;
    private final com.kandy.type.PhoneNumber phoneNumber;
    private final String validationCode;

    @JsonCreator
    private ValidationRequest(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("call_sid") final String callSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("phone_number") final com.kandy.type.PhoneNumber phoneNumber,

            @JsonProperty("validation_code") final String validationCode) {
        this.accountSid = accountSid;
        this.callSid = callSid;
        this.friendlyName = friendlyName;
        this.phoneNumber = phoneNumber;
        this.validationCode = validationCode;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getCallSid() {
        return this.callSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final com.kandy.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getValidationCode() {
        return this.validationCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ValidationRequest other = (ValidationRequest) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(callSid, other.callSid)
                && Objects.equals(friendlyName, other.friendlyName) && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(validationCode, other.validationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, callSid, friendlyName, phoneNumber, validationCode);
    }

}
