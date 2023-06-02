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
 * TwiML wrapper for {@code <break>}
 */
@JsonDeserialize(builder = SsmlBreak.Builder.class)
public class SsmlBreak extends TwiML {
    public enum Strength {
        NONE("none"),
        X_WEAK("x-weak"),
        WEAK("weak"),
        MEDIUM("medium"),
        STRONG("strong"),
        X_STRONG("x-strong");

        private final String value;

        private Strength(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final SsmlBreak.Strength strength;
    private final String time;

    /**
     * For XML Serialization/Deserialization
     */
    private SsmlBreak() {
        this(new Builder());
    }

    /**
     * Create a new {@code <break>} element
     */
    private SsmlBreak(Builder b) {
        super("break", b);
        this.strength = b.strength;
        this.time = b.time;
    }

    /**
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getStrength() != null) {
            attrs.put("strength", this.getStrength().toString());
        }
        if (this.getTime() != null) {
            attrs.put("time", this.getTime());
        }

        return attrs;
    }

    /**
     * Set a pause based on strength
     *
     * @return Set a pause based on strength
     */
    public SsmlBreak.Strength getStrength() {
        return strength;
    }

    /**
     * Set a pause to a specific length of time in seconds or milliseconds,
     * available values: [number]s, [number]ms
     *
     * @return Set a pause to a specific length of time in seconds or milliseconds,
     *         available values: [number]s, [number]ms
     */
    public String getTime() {
        return time;
    }

    /**
     * Create a new {@code <break>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <SsmlBreak.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                    "Failed to deserialize a SsmlBreak.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private SsmlBreak.Strength strength;
        private String time;

        /**
         * Set a pause based on strength
         */
        @JacksonXmlProperty(isAttribute = true, localName = "strength")
        public Builder strength(SsmlBreak.Strength strength) {
            this.strength = strength;
            return this;
        }

        /**
         * Set a pause to a specific length of time in seconds or milliseconds,
         * available values: [number]s, [number]ms
         */
        @JacksonXmlProperty(isAttribute = true, localName = "time")
        public Builder time(String time) {
            this.time = time;
            return this;
        }

        /**
         * Create and return resulting {@code <break>} element
         */
        public SsmlBreak build() {
            return new SsmlBreak(this);
        }
    }
}
