/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Video
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.video.v1;

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
import java.net.URI;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class RecordingSettings extends Resource {
    private static final long serialVersionUID = 265748091067113L;

    public static RecordingSettingsCreator creator(final String friendlyName) {
        return new RecordingSettingsCreator(friendlyName);
    }

    public static RecordingSettingsFetcher fetcher() {
        return new RecordingSettingsFetcher();
    }

    /**
     * Converts a JSON String into a RecordingSettings object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return RecordingSettings object represented by the provided JSON
     */
    public static RecordingSettings fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RecordingSettings.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a RecordingSettings object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return RecordingSettings object represented by the provided JSON
     */
    public static RecordingSettings fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RecordingSettings.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String friendlyName;
    private final String awsCredentialsSid;
    private final URI awsS3Url;
    private final Boolean awsStorageEnabled;
    private final String encryptionKeySid;
    private final Boolean encryptionEnabled;
    private final URI url;

    @JsonCreator
    private RecordingSettings(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("aws_credentials_sid") final String awsCredentialsSid,

            @JsonProperty("aws_s3_url") final URI awsS3Url,

            @JsonProperty("aws_storage_enabled") final Boolean awsStorageEnabled,

            @JsonProperty("encryption_key_sid") final String encryptionKeySid,

            @JsonProperty("encryption_enabled") final Boolean encryptionEnabled,

            @JsonProperty("url") final URI url) {
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.awsCredentialsSid = awsCredentialsSid;
        this.awsS3Url = awsS3Url;
        this.awsStorageEnabled = awsStorageEnabled;
        this.encryptionKeySid = encryptionKeySid;
        this.encryptionEnabled = encryptionEnabled;
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getAwsCredentialsSid() {
        return this.awsCredentialsSid;
    }

    public final URI getAwsS3Url() {
        return this.awsS3Url;
    }

    public final Boolean getAwsStorageEnabled() {
        return this.awsStorageEnabled;
    }

    public final String getEncryptionKeySid() {
        return this.encryptionKeySid;
    }

    public final Boolean getEncryptionEnabled() {
        return this.encryptionEnabled;
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

        RecordingSettings other = (RecordingSettings) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(awsCredentialsSid, other.awsCredentialsSid)
                && Objects.equals(awsS3Url, other.awsS3Url)
                && Objects.equals(awsStorageEnabled, other.awsStorageEnabled)
                && Objects.equals(encryptionKeySid, other.encryptionKeySid)
                && Objects.equals(encryptionEnabled, other.encryptionEnabled) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, friendlyName, awsCredentialsSid, awsS3Url, awsStorageEnabled, encryptionKeySid,
                encryptionEnabled, url);
    }

}
