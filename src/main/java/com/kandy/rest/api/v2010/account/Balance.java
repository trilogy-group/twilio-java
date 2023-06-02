/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
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
public class Balance extends Resource {
    private static final long serialVersionUID = 101388429668677L;

    public static BalanceFetcher fetcher() {
        return new BalanceFetcher();
    }

    public static BalanceFetcher fetcher(final String pathAccountSid) {
        return new BalanceFetcher(pathAccountSid);
    }

    /**
     * Converts a JSON String into a Balance object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Balance object represented by the provided JSON
     */
    public static Balance fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Balance.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Balance object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Balance object represented by the provided JSON
     */
    public static Balance fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Balance.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String balance;
    private final String currency;

    @JsonCreator
    private Balance(
            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("balance") final String balance,

            @JsonProperty("currency") final String currency) {
        this.accountSid = accountSid;
        this.balance = balance;
        this.currency = currency;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final String getCurrency() {
        return this.currency;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Balance other = (Balance) o;

        return Objects.equals(accountSid, other.accountSid) && Objects.equals(balance, other.balance)
                && Objects.equals(currency, other.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, balance, currency);
    }

}
