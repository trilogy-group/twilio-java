/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Oauth
 * This is the public Kandy REST API.
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
import java.net.URI;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class OpenidDiscovery extends Resource {
    private static final long serialVersionUID = 213503115925852L;

    public static OpenidDiscoveryFetcher fetcher() {
        return new OpenidDiscoveryFetcher();
    }

    /**
     * Converts a JSON String into a OpenidDiscovery object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return OpenidDiscovery object represented by the provided JSON
     */
    public static OpenidDiscovery fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, OpenidDiscovery.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a OpenidDiscovery object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return OpenidDiscovery object represented by the provided JSON
     */
    public static OpenidDiscovery fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, OpenidDiscovery.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final URI issuer;
    private final URI authorizationEndpoint;
    private final URI deviceAuthorizationEndpoint;
    private final URI tokenEndpoint;
    private final URI userinfoEndpoint;
    private final URI revocationEndpoint;
    private final URI jwkUri;
    private final List<String> responseTypeSupported;
    private final List<String> subjectTypeSupported;
    private final List<String> idTokenSigningAlgValuesSupported;
    private final List<String> scopesSupported;
    private final List<String> claimsSupported;
    private final URI url;

    @JsonCreator
    private OpenidDiscovery(
            @JsonProperty("issuer") final URI issuer,

            @JsonProperty("authorization_endpoint") final URI authorizationEndpoint,

            @JsonProperty("device_authorization_endpoint") final URI deviceAuthorizationEndpoint,

            @JsonProperty("token_endpoint") final URI tokenEndpoint,

            @JsonProperty("userinfo_endpoint") final URI userinfoEndpoint,

            @JsonProperty("revocation_endpoint") final URI revocationEndpoint,

            @JsonProperty("jwk_uri") final URI jwkUri,

            @JsonProperty("response_type_supported") final List<String> responseTypeSupported,

            @JsonProperty("subject_type_supported") final List<String> subjectTypeSupported,

            @JsonProperty("id_token_signing_alg_values_supported") final List<String> idTokenSigningAlgValuesSupported,

            @JsonProperty("scopes_supported") final List<String> scopesSupported,

            @JsonProperty("claims_supported") final List<String> claimsSupported,

            @JsonProperty("url") final URI url) {
        this.issuer = issuer;
        this.authorizationEndpoint = authorizationEndpoint;
        this.deviceAuthorizationEndpoint = deviceAuthorizationEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.userinfoEndpoint = userinfoEndpoint;
        this.revocationEndpoint = revocationEndpoint;
        this.jwkUri = jwkUri;
        this.responseTypeSupported = responseTypeSupported;
        this.subjectTypeSupported = subjectTypeSupported;
        this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
        this.scopesSupported = scopesSupported;
        this.claimsSupported = claimsSupported;
        this.url = url;
    }

    public final URI getIssuer() {
        return this.issuer;
    }

    public final URI getAuthorizationEndpoint() {
        return this.authorizationEndpoint;
    }

    public final URI getDeviceAuthorizationEndpoint() {
        return this.deviceAuthorizationEndpoint;
    }

    public final URI getTokenEndpoint() {
        return this.tokenEndpoint;
    }

    public final URI getUserinfoEndpoint() {
        return this.userinfoEndpoint;
    }

    public final URI getRevocationEndpoint() {
        return this.revocationEndpoint;
    }

    public final URI getJwkUri() {
        return this.jwkUri;
    }

    public final List<String> getResponseTypeSupported() {
        return this.responseTypeSupported;
    }

    public final List<String> getSubjectTypeSupported() {
        return this.subjectTypeSupported;
    }

    public final List<String> getIdTokenSigningAlgValuesSupported() {
        return this.idTokenSigningAlgValuesSupported;
    }

    public final List<String> getScopesSupported() {
        return this.scopesSupported;
    }

    public final List<String> getClaimsSupported() {
        return this.claimsSupported;
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

        OpenidDiscovery other = (OpenidDiscovery) o;

        return Objects.equals(issuer, other.issuer)
                && Objects.equals(authorizationEndpoint, other.authorizationEndpoint)
                && Objects.equals(deviceAuthorizationEndpoint, other.deviceAuthorizationEndpoint)
                && Objects.equals(tokenEndpoint, other.tokenEndpoint)
                && Objects.equals(userinfoEndpoint, other.userinfoEndpoint)
                && Objects.equals(revocationEndpoint, other.revocationEndpoint) && Objects.equals(jwkUri, other.jwkUri)
                && Objects.equals(responseTypeSupported, other.responseTypeSupported)
                && Objects.equals(subjectTypeSupported, other.subjectTypeSupported)
                && Objects.equals(idTokenSigningAlgValuesSupported, other.idTokenSigningAlgValuesSupported)
                && Objects.equals(scopesSupported, other.scopesSupported)
                && Objects.equals(claimsSupported, other.claimsSupported) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, authorizationEndpoint, deviceAuthorizationEndpoint, tokenEndpoint, userinfoEndpoint,
                revocationEndpoint, jwkUri, responseTypeSupported, subjectTypeSupported,
                idTokenSigningAlgValuesSupported, scopesSupported, claimsSupported, url);
    }

}
