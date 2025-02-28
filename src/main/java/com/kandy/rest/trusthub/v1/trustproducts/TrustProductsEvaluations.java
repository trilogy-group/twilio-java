/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Trusthub
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.trusthub.v1.trustproducts;

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
public class TrustProductsEvaluations extends Resource {
    private static final long serialVersionUID = 86634042597263L;

    public static TrustProductsEvaluationsCreator creator(final String pathTrustProductSid, final String policySid) {
        return new TrustProductsEvaluationsCreator(pathTrustProductSid, policySid);
    }

    public static TrustProductsEvaluationsFetcher fetcher(final String pathTrustProductSid, final String pathSid) {
        return new TrustProductsEvaluationsFetcher(pathTrustProductSid, pathSid);
    }

    public static TrustProductsEvaluationsReader reader(final String pathTrustProductSid) {
        return new TrustProductsEvaluationsReader(pathTrustProductSid);
    }

    /**
     * Converts a JSON String into a TrustProductsEvaluations object using the
     * provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TrustProductsEvaluations object represented by the provided JSON
     */
    public static TrustProductsEvaluations fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProductsEvaluations.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TrustProductsEvaluations object using the
     * provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TrustProductsEvaluations object represented by the provided JSON
     */
    public static TrustProductsEvaluations fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProductsEvaluations.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Status {
        COMPLIANT("compliant"),
        NONCOMPLIANT("noncompliant");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String policySid;
    private final String trustProductSid;
    private final TrustProductsEvaluations.Status status;
    private final List<Map<String, Object>> results;
    private final ZonedDateTime dateCreated;
    private final URI url;

    @JsonCreator
    private TrustProductsEvaluations(
            @JsonProperty("sid") final String sid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("policy_sid") final String policySid,

            @JsonProperty("trust_product_sid") final String trustProductSid,

            @JsonProperty("status") final TrustProductsEvaluations.Status status,

            @JsonProperty("results") final List<Map<String, Object>> results,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("url") final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.policySid = policySid;
        this.trustProductSid = trustProductSid;
        this.status = status;
        this.results = results;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getPolicySid() {
        return this.policySid;
    }

    public final String getTrustProductSid() {
        return this.trustProductSid;
    }

    public final TrustProductsEvaluations.Status getStatus() {
        return this.status;
    }

    public final List<Map<String, Object>> getResults() {
        return this.results;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
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

        TrustProductsEvaluations other = (TrustProductsEvaluations) o;

        return Objects.equals(sid, other.sid) && Objects.equals(accountSid, other.accountSid)
                && Objects.equals(policySid, other.policySid) && Objects.equals(trustProductSid, other.trustProductSid)
                && Objects.equals(status, other.status) && Objects.equals(results, other.results)
                && Objects.equals(dateCreated, other.dateCreated) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, policySid, trustProductSid, status, results, dateCreated, url);
    }

}
