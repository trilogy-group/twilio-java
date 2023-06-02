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
 * TwiML wrapper for {@code <phoneme>}
 */
@JsonDeserialize(builder = SsmlPhoneme.Builder.class)
public class SsmlPhoneme extends TwiML {
    public enum Alphabet {
        IPA("ipa"),
        X_SAMPA("x-sampa"),
        X_AMAZON_JYUTPING("x-amazon-jyutping"),
        X_AMAZON_PINYIN("x-amazon-pinyin"),
        X_AMAZON_PRON_KANA("x-amazon-pron-kana"),
        X_AMAZON_YOMIGANA("x-amazon-yomigana");

        private final String value;

        private Alphabet(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final SsmlPhoneme.Alphabet alphabet;
    private final String ph;
    private final String words;

    /**
     * For XML Serialization/Deserialization
     */
    private SsmlPhoneme() {
        this(new Builder((String) null));
    }

    /**
     * Create a new {@code <phoneme>} element
     */
    private SsmlPhoneme(Builder b) {
        super("phoneme", b);
        this.alphabet = b.alphabet;
        this.ph = b.ph;
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
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getAlphabet() != null) {
            attrs.put("alphabet", this.getAlphabet().toString());
        }
        if (this.getPh() != null) {
            attrs.put("ph", this.getPh());
        }

        return attrs;
    }

    /**
     * Specify the phonetic alphabet
     *
     * @return Specify the phonetic alphabet
     */
    public SsmlPhoneme.Alphabet getAlphabet() {
        return alphabet;
    }

    /**
     * Specifiy the phonetic symbols for pronunciation
     *
     * @return Specifiy the phonetic symbols for pronunciation
     */
    public String getPh() {
        return ph;
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
     * Create a new {@code <phoneme>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <SsmlPhoneme.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                        "Failed to deserialize a SsmlPhoneme.Builder from the provided XML string: "
                                + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private SsmlPhoneme.Alphabet alphabet;
        private String ph;
        private String words;

        /**
         * Create a {@code <phoneme>} with words
         */
        public Builder(String words) {
            this.words = words;
        }

        /**
         * Create a {@code <phoneme>} (for XML deserialization)
         */
        private Builder() {
        }

        /**
         * Specify the phonetic alphabet
         */
        @JacksonXmlProperty(isAttribute = true, localName = "alphabet")
        public Builder alphabet(SsmlPhoneme.Alphabet alphabet) {
            this.alphabet = alphabet;
            return this;
        }

        /**
         * Specifiy the phonetic symbols for pronunciation
         */
        @JacksonXmlProperty(isAttribute = true, localName = "ph")
        public Builder ph(String ph) {
            this.ph = ph;
            return this;
        }

        /**
         * Create and return resulting {@code <phoneme>} element
         */
        public SsmlPhoneme build() {
            return new SsmlPhoneme(this);
        }
    }
}
