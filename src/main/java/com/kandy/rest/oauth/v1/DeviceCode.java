/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Oauth
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.oauth.v1;

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

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DeviceCode extends Resource {
    private static final long serialVersionUID = 153107871213953L;

    public static DeviceCodeCreator creator(final String clientSid, final List<String> scopes) {
        return new DeviceCodeCreator(clientSid, scopes);
    }

    /**
     * Converts a JSON String into a DeviceCode object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return DeviceCode object represented by the provided JSON
     */
    public static DeviceCode fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DeviceCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a DeviceCode object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return DeviceCode object represented by the provided JSON
     */
    public static DeviceCode fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DeviceCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String deviceCode;
    private final String userCode;
    private final String verificationUri;
    private final String verificationUriComplete;
    private final Long expiresIn;
    private final Integer interval;

    @JsonCreator
    private DeviceCode(
            @JsonProperty("device_code") final String deviceCode,

            @JsonProperty("user_code") final String userCode,

            @JsonProperty("verification_uri") final String verificationUri,

            @JsonProperty("verification_uri_complete") final String verificationUriComplete,

            @JsonProperty("expires_in") final Long expiresIn,

            @JsonProperty("interval") final Integer interval) {
        this.deviceCode = deviceCode;
        this.userCode = userCode;
        this.verificationUri = verificationUri;
        this.verificationUriComplete = verificationUriComplete;
        this.expiresIn = expiresIn;
        this.interval = interval;
    }

    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final String getUserCode() {
        return this.userCode;
    }

    public final String getVerificationUri() {
        return this.verificationUri;
    }

    public final String getVerificationUriComplete() {
        return this.verificationUriComplete;
    }

    public final Long getExpiresIn() {
        return this.expiresIn;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DeviceCode other = (DeviceCode) o;

        return Objects.equals(deviceCode, other.deviceCode) && Objects.equals(userCode, other.userCode)
                && Objects.equals(verificationUri, other.verificationUri)
                && Objects.equals(verificationUriComplete, other.verificationUriComplete)
                && Objects.equals(expiresIn, other.expiresIn) && Objects.equals(interval, other.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceCode, userCode, verificationUri, verificationUriComplete, expiresIn, interval);
    }

}
