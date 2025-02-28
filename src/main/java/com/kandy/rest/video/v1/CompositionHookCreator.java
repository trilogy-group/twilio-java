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

import com.kandy.base.Creator;
import com.kandy.converter.Promoter;
import com.kandy.exception.ApiConnectionException;
import com.kandy.converter.Converter;
import com.kandy.exception.ApiException;
import com.kandy.exception.RestException;
import com.kandy.http.HttpMethod;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;
import com.kandy.rest.Domains;
import java.util.List;
import java.util.Map;
import com.kandy.converter.Converter;
import java.net.URI;

import java.util.List;
import java.util.Map;

import java.net.URI;

public class CompositionHookCreator extends Creator<CompositionHook> {
    private String friendlyName;
    private Boolean enabled;
    private Map<String, Object> videoLayout;
    private List<String> audioSources;
    private List<String> audioSourcesExcluded;
    private String resolution;
    private CompositionHook.Format format;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private Boolean trim;

    public CompositionHookCreator(final String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public CompositionHookCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public CompositionHookCreator setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public CompositionHookCreator setVideoLayout(final Map<String, Object> videoLayout) {
        this.videoLayout = videoLayout;
        return this;
    }

    public CompositionHookCreator setAudioSources(final List<String> audioSources) {
        this.audioSources = audioSources;
        return this;
    }

    public CompositionHookCreator setAudioSources(final String audioSources) {
        return setAudioSources(Promoter.listOfOne(audioSources));
    }

    public CompositionHookCreator setAudioSourcesExcluded(final List<String> audioSourcesExcluded) {
        this.audioSourcesExcluded = audioSourcesExcluded;
        return this;
    }

    public CompositionHookCreator setAudioSourcesExcluded(final String audioSourcesExcluded) {
        return setAudioSourcesExcluded(Promoter.listOfOne(audioSourcesExcluded));
    }

    public CompositionHookCreator setResolution(final String resolution) {
        this.resolution = resolution;
        return this;
    }

    public CompositionHookCreator setFormat(final CompositionHook.Format format) {
        this.format = format;
        return this;
    }

    public CompositionHookCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public CompositionHookCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    public CompositionHookCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public CompositionHookCreator setTrim(final Boolean trim) {
        this.trim = trim;
        return this;
    }

    @Override
    public CompositionHook create(final KandyRestClient client) {
        String path = "/v1/CompositionHooks";

        path = path.replace("{" + "FriendlyName" + "}", this.friendlyName.toString());

        Request request = new Request(
                HttpMethod.POST,
                Domains.VIDEO.toString(),
                path);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("CompositionHook creation failed: Unable to connect to server");
        } else if (!KandyRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return CompositionHook.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);

        }
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());

        }
        if (videoLayout != null) {
            request.addPostParam("VideoLayout", Converter.mapToJson(videoLayout));

        }
        if (audioSources != null) {
            for (String prop : audioSources) {
                request.addPostParam("AudioSources", prop);
            }

        }
        if (audioSourcesExcluded != null) {
            for (String prop : audioSourcesExcluded) {
                request.addPostParam("AudioSourcesExcluded", prop);
            }

        }
        if (resolution != null) {
            request.addPostParam("Resolution", resolution);

        }
        if (format != null) {
            request.addPostParam("Format", format.toString());

        }
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());

        }
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());

        }
        if (trim != null) {
            request.addPostParam("Trim", trim.toString());

        }
    }
}
