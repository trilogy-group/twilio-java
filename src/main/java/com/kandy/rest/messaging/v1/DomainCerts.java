/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Messaging
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.messaging.v1;

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
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DomainCerts extends Resource {
    private static final long serialVersionUID = 200335100401859L;

    public static DomainCertsDeleter deleter(final String pathDomainSid) {
        return new DomainCertsDeleter(pathDomainSid);
    }

    public static DomainCertsFetcher fetcher(final String pathDomainSid) {
        return new DomainCertsFetcher(pathDomainSid);
    }

    public static DomainCertsUpdater updater(final String pathDomainSid, final String tlsCert) {
        return new DomainCertsUpdater(pathDomainSid, tlsCert);
    }

    /**
     * Converts a JSON String into a DomainCerts object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return DomainCerts object represented by the provided JSON
     */
    public static DomainCerts fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DomainCerts.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a DomainCerts object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return DomainCerts object represented by the provided JSON
     */
    public static DomainCerts fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DomainCerts.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String domainSid;
    private final ZonedDateTime dateUpdated;
    private final ZonedDateTime dateExpires;
    private final ZonedDateTime dateCreated;
    private final URI domainName;
    private final String certificateSid;
    private final URI url;
    private final Map<String, Object> certInValidation;

    @JsonCreator
    private DomainCerts(
            @JsonProperty("domain_sid") final String domainSid,

            @JsonProperty("date_updated") final String dateUpdated,

            @JsonProperty("date_expires") final String dateExpires,

            @JsonProperty("date_created") final String dateCreated,

            @JsonProperty("domain_name") final URI domainName,

            @JsonProperty("certificate_sid") final String certificateSid,

            @JsonProperty("url") final URI url,

            @JsonProperty("cert_in_validation") final Map<String, Object> certInValidation) {
        this.domainSid = domainSid;
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.dateExpires = DateConverter.iso8601DateTimeFromString(dateExpires);
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.domainName = domainName;
        this.certificateSid = certificateSid;
        this.url = url;
        this.certInValidation = certInValidation;
    }

    public final String getDomainSid() {
        return this.domainSid;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final ZonedDateTime getDateExpires() {
        return this.dateExpires;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final URI getDomainName() {
        return this.domainName;
    }

    public final String getCertificateSid() {
        return this.certificateSid;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Map<String, Object> getCertInValidation() {
        return this.certInValidation;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DomainCerts other = (DomainCerts) o;

        return Objects.equals(domainSid, other.domainSid) && Objects.equals(dateUpdated, other.dateUpdated)
                && Objects.equals(dateExpires, other.dateExpires) && Objects.equals(dateCreated, other.dateCreated)
                && Objects.equals(domainName, other.domainName) && Objects.equals(certificateSid, other.certificateSid)
                && Objects.equals(url, other.url) && Objects.equals(certInValidation, other.certInValidation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domainSid, dateUpdated, dateExpires, dateCreated, domainName, certificateSid, url,
                certInValidation);
    }

}
