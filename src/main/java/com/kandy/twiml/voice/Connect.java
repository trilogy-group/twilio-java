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
import com.kandy.converter.Promoter;
import com.kandy.http.HttpMethod;
import com.kandy.twiml.TwiML;
import com.kandy.twiml.TwiMLException;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Connect>}
 */
@JsonDeserialize(builder = Connect.Builder.class)
public class Connect extends TwiML {
    private final URI action;
    private final HttpMethod method;

    /**
     * For XML Serialization/Deserialization
     */
    private Connect() {
        this(new Builder());
    }

    /**
     * Create a new {@code <Connect>} element
     */
    private Connect(Builder b) {
        super("Connect", b);
        this.action = b.action;
        this.method = b.method;
    }

    /**
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getAction() != null) {
            attrs.put("action", this.getAction().toString());
        }
        if (this.getMethod() != null) {
            attrs.put("method", this.getMethod().toString());
        }

        return attrs;
    }

    /**
     * Action URL
     *
     * @return Action URL
     */
    public URI getAction() {
        return action;
    }

    /**
     * Action URL method
     *
     * @return Action URL method
     */
    public HttpMethod getMethod() {
        return method;
    }

    /**
     * Create a new {@code <Connect>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <Connect.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                        "Failed to deserialize a Connect.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private URI action;
        private HttpMethod method;

        /**
         * Action URL
         */
        @JacksonXmlProperty(isAttribute = true, localName = "action")
        public Builder action(URI action) {
            this.action = action;
            return this;
        }

        /**
         * Action URL
         */
        public Builder action(String action) {
            this.action = Promoter.uriFromString(action);
            return this;
        }

        /**
         * Action URL method
         */
        @JacksonXmlProperty(isAttribute = true, localName = "method")
        public Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        /**
         * Add a child {@code <Room>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "Room")
        public Builder room(Room room) {
            this.children.add(room);
            return this;
        }

        /**
         * Add a child {@code <Stream>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "Stream")
        public Builder stream(Stream stream) {
            this.children.add(stream);
            return this;
        }

        /**
         * Add a child {@code <VirtualAgent>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "VirtualAgent")
        public Builder virtualAgent(VirtualAgent virtualAgent) {
            this.children.add(virtualAgent);
            return this;
        }

        /**
         * Add a child {@code <Conversation>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "Conversation")
        public Builder conversation(Conversation conversation) {
            this.children.add(conversation);
            return this;
        }

        /**
         * Create and return resulting {@code <Connect>} element
         */
        public Connect build() {
            return new Connect(this);
        }
    }
}
