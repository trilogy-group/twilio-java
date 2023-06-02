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
import com.kandy.converter.DateConverter;
import com.kandy.exception.ApiConnectionException;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Token extends Resource {
    private static final long serialVersionUID = 233151022011558L;

    public static TokenCreator creator(final String grantType, final String clientSid) {
        return new TokenCreator(grantType, clientSid);
    }

    /**
     * Converts a JSON String into a Token object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Token object represented by the provided JSON
     */
    public static Token fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Token.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Token object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Token object represented by the provided JSON
     */
    public static Token fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Token.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accessToken;
    private final String refreshToken;
    private final String idToken;
    private final ZonedDateTime refreshTokenExpiresAt;
    private final ZonedDateTime accessTokenExpiresAt;

    @JsonCreator
    private Token(
            @JsonProperty("access_token") final String accessToken,

            @JsonProperty("refresh_token") final String refreshToken,

            @JsonProperty("id_token") final String idToken,

            @JsonProperty("refresh_token_expires_at") final String refreshTokenExpiresAt,

            @JsonProperty("access_token_expires_at") final String accessTokenExpiresAt) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.idToken = idToken;
        this.refreshTokenExpiresAt = DateConverter.iso8601DateTimeFromString(refreshTokenExpiresAt);
        this.accessTokenExpiresAt = DateConverter.iso8601DateTimeFromString(accessTokenExpiresAt);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final ZonedDateTime getRefreshTokenExpiresAt() {
        return this.refreshTokenExpiresAt;
    }

    public final ZonedDateTime getAccessTokenExpiresAt() {
        return this.accessTokenExpiresAt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Token other = (Token) o;

        return Objects.equals(accessToken, other.accessToken) && Objects.equals(refreshToken, other.refreshToken)
                && Objects.equals(idToken, other.idToken)
                && Objects.equals(refreshTokenExpiresAt, other.refreshTokenExpiresAt)
                && Objects.equals(accessTokenExpiresAt, other.accessTokenExpiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, refreshToken, idToken, refreshTokenExpiresAt, accessTokenExpiresAt);
    }

}
