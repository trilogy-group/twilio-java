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

/**
 * TwiML wrapper for {@code <s>}
 */
@JsonDeserialize(builder = SsmlS.Builder.class)
public class SsmlS extends TwiML {
    private final String words;

    /**
     * For XML Serialization/Deserialization
     */
    private SsmlS() {
        this(new Builder());
    }

    /**
     * Create a new {@code <s>} element
     */
    private SsmlS(Builder b) {
        super("s", b);
        this.words = b.words;
    }

    /**
     * The body of the TwiML element
     *
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getWords() == null ? null : this.getWords();
    }

    /**
     * Words to speak
     *
     * @return Words to speak
     */
    public String getWords() {
        return words;
    }

    /**
     * Create a new {@code <s>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <SsmlS.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                        "Failed to deserialize a SsmlS.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private String words;

        /**
         * Create a {@code <s>} with words
         */
        public Builder(String words) {
            this.words = words;
        }

        /**
         * Create a {@code <s>} with child elements
         */
        public Builder() {
        }

        /**
         * Add a child {@code <break>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "break")
        public Builder break_(SsmlBreak ssmlBreak) {
            this.children.add(ssmlBreak);
            return this;
        }

        /**
         * Add a child {@code <emphasis>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "emphasis")
        public Builder emphasis(SsmlEmphasis ssmlEmphasis) {
            this.children.add(ssmlEmphasis);
            return this;
        }

        /**
         * Add a child {@code <lang>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "lang")
        public Builder lang(SsmlLang ssmlLang) {
            this.children.add(ssmlLang);
            return this;
        }

        /**
         * Add a child {@code <phoneme>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "phoneme")
        public Builder phoneme(SsmlPhoneme ssmlPhoneme) {
            this.children.add(ssmlPhoneme);
            return this;
        }

        /**
         * Add a child {@code <prosody>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "prosody")
        public Builder prosody(SsmlProsody ssmlProsody) {
            this.children.add(ssmlProsody);
            return this;
        }

        /**
         * Add a child {@code <say-as>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "say-as")
        public Builder sayAs(SsmlSayAs ssmlSayAs) {
            this.children.add(ssmlSayAs);
            return this;
        }

        /**
         * Add a child {@code <sub>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "sub")
        public Builder sub(SsmlSub ssmlSub) {
            this.children.add(ssmlSub);
            return this;
        }

        /**
         * Add a child {@code <w>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "w")
        public Builder w(SsmlW ssmlW) {
            this.children.add(ssmlW);
            return this;
        }

        /**
         * Create and return resulting {@code <s>} element
         */
        public SsmlS build() {
            return new SsmlS(this);
        }
    }
}
