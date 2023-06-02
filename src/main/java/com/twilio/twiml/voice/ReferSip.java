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
import com.kandy.converter.Promoter;
import com.kandy.twiml.TwiML;
import com.kandy.twiml.TwiMLException;

import java.net.URI;

/**
 * TwiML wrapper for {@code <Sip>}
 */
@JsonDeserialize(builder = ReferSip.Builder.class)
public class ReferSip extends TwiML {
    private final URI sipUrl;

    /**
     * For XML Serialization/Deserialization
     */
    private ReferSip() {
        this(new Builder((URI) null));
    }

    /**
     * Create a new {@code <Sip>} element
     */
    private ReferSip(Builder b) {
        super("Sip", b);
        this.sipUrl = b.sipUrl;
    }

    /**
     * The body of the TwiML element
     *
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getSipUrl() == null ? null : this.getSipUrl().toString();
    }

    /**
     * SIP URL
     *
     * @return SIP URL
     */
    public URI getSipUrl() {
        return sipUrl;
    }

    /**
     * Create a new {@code <Sip>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <ReferSip.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                    "Failed to deserialize a ReferSip.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private URI sipUrl;

        /**
         * Create a {@code <Sip>} with sipUrl
         */
        public Builder(URI sipUrl) {
            this.sipUrl = sipUrl;
        }

        /**
         * Create a {@code <Sip>} with sipUrl
         */
        public Builder(String sipUrl) {
            this.sipUrl = Promoter.uriFromString(sipUrl);
        }

        /**
         * Create a {@code <Sip>} (for XML deserialization)
         */
        private Builder() {
        }

        /**
         * Create and return resulting {@code <Sip>} element
         */
        public ReferSip build() {
            return new ReferSip(this);
        }
    }
}
