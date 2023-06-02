/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Kandy - Pricing
 * This is the public Kandy REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.pricing.v2.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kandy.base.Resource;
import java.util.Currency;
import com.kandy.converter.CurrencyDeserializer;
import com.kandy.exception.ApiConnectionException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.kandy.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.List;
import java.util.Objects;

import com.kandy.type.InboundCallPrice;
import com.kandy.type.OutboundPrefixPriceWithOrigin;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Country extends Resource {
    private static final long serialVersionUID = 141644803807942L;

    public static CountryFetcher fetcher(final String pathIsoCountry) {
        return new CountryFetcher(pathIsoCountry);
    }

    public static CountryReader reader() {
        return new CountryReader();
    }

    /**
     * Converts a JSON String into a Country object using the provided ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Country object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String country;
    private final String isoCountry;
    private final List<OutboundPrefixPriceWithOrigin> outboundPrefixPrices;
    private final List<InboundCallPrice> inboundCallPrices;
    private final Currency priceUnit;
    private final URI url;

    @JsonCreator
    private Country(
            @JsonProperty("country") final String country,

            @JsonProperty("iso_country") final String isoCountry,

            @JsonProperty("outbound_prefix_prices") final List<OutboundPrefixPriceWithOrigin> outboundPrefixPrices,

            @JsonProperty("inbound_call_prices") final List<InboundCallPrice> inboundCallPrices,

            @JsonProperty("price_unit") @JsonDeserialize(using = com.kandy.converter.CurrencyDeserializer.class) final Currency priceUnit,

            @JsonProperty("url") final URI url) {
        this.country = country;
        this.isoCountry = isoCountry;
        this.outboundPrefixPrices = outboundPrefixPrices;
        this.inboundCallPrices = inboundCallPrices;
        this.priceUnit = priceUnit;
        this.url = url;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getIsoCountry() {
        return this.isoCountry;
    }

    public final List<OutboundPrefixPriceWithOrigin> getOutboundPrefixPrices() {
        return this.outboundPrefixPrices;
    }

    public final List<InboundCallPrice> getInboundCallPrices() {
        return this.inboundCallPrices;
    }

    public final Currency getPriceUnit() {
        return this.priceUnit;
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

        Country other = (Country) o;

        return Objects.equals(country, other.country) && Objects.equals(isoCountry, other.isoCountry)
                && Objects.equals(outboundPrefixPrices, other.outboundPrefixPrices)
                && Objects.equals(inboundCallPrices, other.inboundCallPrices)
                && Objects.equals(priceUnit, other.priceUnit) && Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, isoCountry, outboundPrefixPrices, inboundCallPrices, priceUnit, url);
    }

}
