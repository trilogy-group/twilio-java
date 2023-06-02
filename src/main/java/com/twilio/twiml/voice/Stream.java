/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.voice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.kandy.twiml.TwiML;
import com.kandy.twiml.TwiMLException;

import java.util.HashMap;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Stream>}
 */
@JsonDeserialize(builder = Stream.Builder.class)
public class Stream extends TwiML {
    public enum Track {
        INBOUND_TRACK("inbound_track"),
        OUTBOUND_TRACK("outbound_track"),
        BOTH_TRACKS("both_tracks");

        private final String value;

        private Track(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public enum StatusCallbackMethod {
        GET("GET"),
        POST("POST");

        private final String value;

        private StatusCallbackMethod(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final String name;
    private final String connectorName;
    private final String url;
    private final Stream.Track track;
    private final String statusCallback;
    private final Stream.StatusCallbackMethod statusCallbackMethod;

    /**
     * For XML Serialization/Deserialization
     */
    private Stream() {
        this(new Builder());
    }

    /**
     * Create a new {@code <Stream>} element
     */
    private Stream(Builder b) {
        super("Stream", b);
        this.name = b.name;
        this.connectorName = b.connectorName;
        this.url = b.url;
        this.track = b.track;
        this.statusCallback = b.statusCallback;
        this.statusCallbackMethod = b.statusCallbackMethod;
    }

    /**
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getName() != null) {
            attrs.put("name", this.getName());
        }
        if (this.getConnectorName() != null) {
            attrs.put("connectorName", this.getConnectorName());
        }
        if (this.getUrl() != null) {
            attrs.put("url", this.getUrl());
        }
        if (this.getTrack() != null) {
            attrs.put("track", this.getTrack().toString());
        }
        if (this.getStatusCallback() != null) {
            attrs.put("statusCallback", this.getStatusCallback());
        }
        if (this.getStatusCallbackMethod() != null) {
            attrs.put("statusCallbackMethod", this.getStatusCallbackMethod().toString());
        }

        return attrs;
    }

    /**
     * Friendly name given to the Stream
     *
     * @return Friendly name given to the Stream
     */
    public String getName() {
        return name;
    }

    /**
     * Unique name for Stream Connector
     *
     * @return Unique name for Stream Connector
     */
    public String getConnectorName() {
        return connectorName;
    }

    /**
     * URL of the remote service where the Stream is routed
     *
     * @return URL of the remote service where the Stream is routed
     */
    public String getUrl() {
        return url;
    }

    /**
     * Track to be streamed to remote service
     *
     * @return Track to be streamed to remote service
     */
    public Stream.Track getTrack() {
        return track;
    }

    /**
     * Status Callback URL
     *
     * @return Status Callback URL
     */
    public String getStatusCallback() {
        return statusCallback;
    }

    /**
     * Status Callback URL method
     *
     * @return Status Callback URL method
     */
    public Stream.StatusCallbackMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    /**
     * Create a new {@code <Stream>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <Stream.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                    "Failed to deserialize a Stream.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private String name;
        private String connectorName;
        private String url;
        private Stream.Track track;
        private String statusCallback;
        private Stream.StatusCallbackMethod statusCallbackMethod;

        /**
         * Friendly name given to the Stream
         */
        @JacksonXmlProperty(isAttribute = true, localName = "name")
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Unique name for Stream Connector
         */
        @JacksonXmlProperty(isAttribute = true, localName = "connectorName")
        public Builder connectorName(String connectorName) {
            this.connectorName = connectorName;
            return this;
        }

        /**
         * URL of the remote service where the Stream is routed
         */
        @JacksonXmlProperty(isAttribute = true, localName = "url")
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * Track to be streamed to remote service
         */
        @JacksonXmlProperty(isAttribute = true, localName = "track")
        public Builder track(Stream.Track track) {
            this.track = track;
            return this;
        }

        /**
         * Status Callback URL
         */
        @JacksonXmlProperty(isAttribute = true, localName = "statusCallback")
        public Builder statusCallback(String statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        /**
         * Status Callback URL method
         */
        @JacksonXmlProperty(isAttribute = true, localName = "statusCallbackMethod")
        public Builder statusCallbackMethod(Stream.StatusCallbackMethod statusCallbackMethod) {
            this.statusCallbackMethod = statusCallbackMethod;
            return this;
        }

        /**
         * Add a child {@code <Parameter>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "Parameter")
        public Builder parameter(Parameter parameter) {
            this.children.add(parameter);
            return this;
        }

        /**
         * Create and return resulting {@code <Stream>} element
         */
        public Stream build() {
            return new Stream(this);
        }
    }
}
