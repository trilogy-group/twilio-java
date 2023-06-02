/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Wireless
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.kandy.rest.wireless.v1.sim;

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

import java.util.Map;
import java.util.Objects;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DataSession extends Resource {
    private static final long serialVersionUID = 124844690346008L;

    public static DataSessionReader reader(final String pathSimSid) {
        return new DataSessionReader(pathSimSid);
    }

    /**
     * Converts a JSON String into a DataSession object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return DataSession object represented by the provided JSON
     */
    public static DataSession fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DataSession.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a DataSession object using the provided
     * ObjectMapper.
     *
     * @param json         Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return DataSession object represented by the provided JSON
     */
    public static DataSession fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DataSession.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String simSid;
    private final String accountSid;
    private final String radioLink;
    private final String operatorMcc;
    private final String operatorMnc;
    private final String operatorCountry;
    private final String operatorName;
    private final String cellId;
    private final Map<String, Object> cellLocationEstimate;
    private final Integer packetsUploaded;
    private final Integer packetsDownloaded;
    private final ZonedDateTime lastUpdated;
    private final ZonedDateTime start;
    private final ZonedDateTime end;
    private final String imei;

    @JsonCreator
    private DataSession(
            @JsonProperty("sid") final String sid,

            @JsonProperty("sim_sid") final String simSid,

            @JsonProperty("account_sid") final String accountSid,

            @JsonProperty("radio_link") final String radioLink,

            @JsonProperty("operator_mcc") final String operatorMcc,

            @JsonProperty("operator_mnc") final String operatorMnc,

            @JsonProperty("operator_country") final String operatorCountry,

            @JsonProperty("operator_name") final String operatorName,

            @JsonProperty("cell_id") final String cellId,

            @JsonProperty("cell_location_estimate") final Map<String, Object> cellLocationEstimate,

            @JsonProperty("packets_uploaded") final Integer packetsUploaded,

            @JsonProperty("packets_downloaded") final Integer packetsDownloaded,

            @JsonProperty("last_updated") final String lastUpdated,

            @JsonProperty("start") final String start,

            @JsonProperty("end") final String end,

            @JsonProperty("imei") final String imei) {
        this.sid = sid;
        this.simSid = simSid;
        this.accountSid = accountSid;
        this.radioLink = radioLink;
        this.operatorMcc = operatorMcc;
        this.operatorMnc = operatorMnc;
        this.operatorCountry = operatorCountry;
        this.operatorName = operatorName;
        this.cellId = cellId;
        this.cellLocationEstimate = cellLocationEstimate;
        this.packetsUploaded = packetsUploaded;
        this.packetsDownloaded = packetsDownloaded;
        this.lastUpdated = DateConverter.iso8601DateTimeFromString(lastUpdated);
        this.start = DateConverter.iso8601DateTimeFromString(start);
        this.end = DateConverter.iso8601DateTimeFromString(end);
        this.imei = imei;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getSimSid() {
        return this.simSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getRadioLink() {
        return this.radioLink;
    }

    public final String getOperatorMcc() {
        return this.operatorMcc;
    }

    public final String getOperatorMnc() {
        return this.operatorMnc;
    }

    public final String getOperatorCountry() {
        return this.operatorCountry;
    }

    public final String getOperatorName() {
        return this.operatorName;
    }

    public final String getCellId() {
        return this.cellId;
    }

    public final Map<String, Object> getCellLocationEstimate() {
        return this.cellLocationEstimate;
    }

    public final Integer getPacketsUploaded() {
        return this.packetsUploaded;
    }

    public final Integer getPacketsDownloaded() {
        return this.packetsDownloaded;
    }

    public final ZonedDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public final ZonedDateTime getStart() {
        return this.start;
    }

    public final ZonedDateTime getEnd() {
        return this.end;
    }

    public final String getImei() {
        return this.imei;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DataSession other = (DataSession) o;

        return Objects.equals(sid, other.sid) && Objects.equals(simSid, other.simSid)
                && Objects.equals(accountSid, other.accountSid) && Objects.equals(radioLink, other.radioLink)
                && Objects.equals(operatorMcc, other.operatorMcc) && Objects.equals(operatorMnc, other.operatorMnc)
                && Objects.equals(operatorCountry, other.operatorCountry)
                && Objects.equals(operatorName, other.operatorName) && Objects.equals(cellId, other.cellId)
                && Objects.equals(cellLocationEstimate, other.cellLocationEstimate)
                && Objects.equals(packetsUploaded, other.packetsUploaded)
                && Objects.equals(packetsDownloaded, other.packetsDownloaded)
                && Objects.equals(lastUpdated, other.lastUpdated) && Objects.equals(start, other.start)
                && Objects.equals(end, other.end) && Objects.equals(imei, other.imei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, simSid, accountSid, radioLink, operatorMcc, operatorMnc, operatorCountry, operatorName,
                cellId, cellLocationEstimate, packetsUploaded, packetsDownloaded, lastUpdated, start, end, imei);
    }

}
