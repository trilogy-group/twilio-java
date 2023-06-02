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
 * TwiML wrapper for {@code <Siprec>}
 */
@JsonDeserialize(builder = Siprec.Builder.class)
public class Siprec extends TwiML {
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

    private final String name;
    private final String connectorName;
    private final Siprec.Track track;

    /**
     * For XML Serialization/Deserialization
     */
    private Siprec() {
        this(new Builder());
    }

    /**
     * Create a new {@code <Siprec>} element
     */
    private Siprec(Builder b) {
        super("Siprec", b);
        this.name = b.name;
        this.connectorName = b.connectorName;
        this.track = b.track;
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
        if (this.getTrack() != null) {
            attrs.put("track", this.getTrack().toString());
        }

        return attrs;
    }

    /**
     * Friendly name given to SIPREC
     *
     * @return Friendly name given to SIPREC
     */
    public String getName() {
        return name;
    }

    /**
     * Unique name for Connector
     *
     * @return Unique name for Connector
     */
    public String getConnectorName() {
        return connectorName;
    }

    /**
     * Track to be streamed to remote service
     *
     * @return Track to be streamed to remote service
     */
    public Siprec.Track getTrack() {
        return track;
    }

    /**
     * Create a new {@code <Siprec>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <Siprec.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                        "Failed to deserialize a Siprec.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private String name;
        private String connectorName;
        private Siprec.Track track;

        /**
         * Friendly name given to SIPREC
         */
        @JacksonXmlProperty(isAttribute = true, localName = "name")
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Unique name for Connector
         */
        @JacksonXmlProperty(isAttribute = true, localName = "connectorName")
        public Builder connectorName(String connectorName) {
            this.connectorName = connectorName;
            return this;
        }

        /**
         * Track to be streamed to remote service
         */
        @JacksonXmlProperty(isAttribute = true, localName = "track")
        public Builder track(Siprec.Track track) {
            this.track = track;
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
         * Create and return resulting {@code <Siprec>} element
         */
        public Siprec build() {
            return new Siprec(this);
        }
    }
}
