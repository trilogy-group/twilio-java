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

import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class CompositionHook extends Resource {
    private static final long serialVersionUID = 233336557322533L;

    public static CompositionHookCreator creator(final String friendlyName) {
        return new CompositionHookCreator(friendlyName);
    }

    public static CompositionHookDeleter deleter(final String pathSid) {
        return new CompositionHookDeleter(pathSid);
    }

    public static CompositionHookFetcher fetcher(final String pathSid) {
        return new CompositionHookFetcher(pathSid);
    }

    public static CompositionHookReader reader() {
        return new CompositionHookReader();
    }

    public static CompositionHookUpdater updater(final String pathSid, final String friendlyName) {
        return new CompositionHookUpdater(pathSid, friendlyName);
    }

    /**
     * Converts a JSON String into a CompositionHook object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return CompositionHook object represented by the provided JSON
     */
    public static CompositionHook fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CompositionHook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a CompositionHook object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return CompositionHook object represented by the provided JSON
     */
    public static CompositionHook fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CompositionHook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Format {
        MP4("mp4"),
        WEBM("webm");

        private final String value;

        private Format(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Format forValue(final String value) {
            return Promoter.enumFromString(value, Format.values());
        }
    }

    private final String accountSid;
    private final String friendlyName;
    private final Boolean enabled;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String sid;
    private final List<String> audioSources;
    private final List<String> audioSourcesExcluded;
    private final Map<String, Object> videoLayout;
    private final String resolution;
    private final Boolean trim;
    private final CompositionHook.Format format;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final URI url;

    @JsonCreator
    private CompositionHook(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("friendly_name") final String friendlyName,

            @JsonProperty("enabled") final Boolean enabled,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("sid") final String sid,

            @JsonProperty("audio_sources") final List<String> audioSources,

            @JsonProperty("audio_sources_excluded") final List<String> audioSourcesExcluded,

            @JsonProperty("video_layout") final Map<String, Object> videoLayout,

            @JsonProperty("resolution") final String resolution,

            @JsonProperty("trim") final Boolean trim,

            @JsonProperty("format") final CompositionHook.Format format,

            @JsonProperty("status_callback") final URI statusCallback,

            @JsonProperty("status_callback_method") final HttpMethod statusCallbackMethod,

            @JsonProperty("url") final URI url) {
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.enabled = enabled;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.sid = sid;
        this.audioSources = audioSources;
        this.audioSourcesExcluded = audioSourcesExcluded;
        this.videoLayout = videoLayout;
        this.resolution = resolution;
        this.trim = trim;
        this.format = format;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getSid() {
        return this.sid;
    }

    public final List<String> getAudioSources() {
        return this.audioSources;
    }

    public final List<String> getAudioSourcesExcluded() {
        return this.audioSourcesExcluded;
    }

    public final Map<String, Object> getVideoLayout() {
        return this.videoLayout;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final Boolean getTrim() {
        return this.trim;
    }

    public final CompositionHook.Format getFormat() {
        return this.format;
    }

    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
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

        CompositionHook other = (CompositionHook) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(friendlyName, other.friendlyName)
                && Objects.equals(enabled, other.enabled) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(sid, other.sid)
                && Objects.equals(audioSources, other.audioSources)
                && Objects.equals(audioSourcesExcluded, other.audioSourcesExcluded)
                && Objects.equals(videoLayout, other.videoLayout) && Objects.equals(resolution, other.resolution)
                && Objects.equals(trim, other.trim) && Objects.equals(format, other.format)
                && Objects.equals(statusCallback, other.statusCallback)
                && Objects.equals(statusCallbackMethod, other.statusCallbackMethod) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, friendlyName, enabled, dateCreated, dateUpdated, sid, audioSources,
                audioSourcesExcluded, videoLayout, resolution, trim, format, statusCallback, statusCallbackMethod, url);
    }

}
