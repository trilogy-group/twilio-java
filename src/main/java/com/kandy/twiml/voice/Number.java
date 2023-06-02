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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Number>}
 */
@JsonDeserialize(builder = Number.Builder.class)
public class Number extends TwiML {
    public enum Event {
        INITIATED("initiated"),
        RINGING("ringing"),
        ANSWERED("answered"),
        COMPLETED("completed");

        private final String value;

        private Event(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final String sendDigits;
    private final URI url;
    private final HttpMethod method;
    private final List<Number.Event> statusCallbackEvent;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String byoc;
    private final String machineDetection;
    private final HttpMethod amdStatusCallbackMethod;
    private final String amdStatusCallback;
    private final Integer machineDetectionTimeout;
    private final Integer machineDetectionSpeechThreshold;
    private final Integer machineDetectionSpeechEndThreshold;
    private final Integer machineDetectionSilenceTimeout;
    private final com.kandy.type.PhoneNumber phoneNumber;

    /**
     * For XML Serialization/Deserialization
     */
    private Number() {
        this(new Builder((com.kandy.type.PhoneNumber) null));
    }

    /**
     * Create a new {@code <Number>} element
     */
    private Number(Builder b) {
        super("Number", b);
        this.sendDigits = b.sendDigits;
        this.url = b.url;
        this.method = b.method;
        this.statusCallbackEvent = b.statusCallbackEvent;
        this.statusCallback = b.statusCallback;
        this.statusCallbackMethod = b.statusCallbackMethod;
        this.byoc = b.byoc;
        this.machineDetection = b.machineDetection;
        this.amdStatusCallbackMethod = b.amdStatusCallbackMethod;
        this.amdStatusCallback = b.amdStatusCallback;
        this.machineDetectionTimeout = b.machineDetectionTimeout;
        this.machineDetectionSpeechThreshold = b.machineDetectionSpeechThreshold;
        this.machineDetectionSpeechEndThreshold = b.machineDetectionSpeechEndThreshold;
        this.machineDetectionSilenceTimeout = b.machineDetectionSilenceTimeout;
        this.phoneNumber = b.phoneNumber;
    }

    /**
     * The body of the TwiML element
     *
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getPhoneNumber() == null ? null : this.getPhoneNumber().toString();
    }

    /**
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getSendDigits() != null) {
            attrs.put("sendDigits", this.getSendDigits());
        }
        if (this.getUrl() != null) {
            attrs.put("url", this.getUrl().toString());
        }
        if (this.getMethod() != null) {
            attrs.put("method", this.getMethod().toString());
        }
        if (this.getStatusCallbackEvents() != null) {
            attrs.put("statusCallbackEvent", this.getStatusCallbackEventsAsString());
        }
        if (this.getStatusCallback() != null) {
            attrs.put("statusCallback", this.getStatusCallback().toString());
        }
        if (this.getStatusCallbackMethod() != null) {
            attrs.put("statusCallbackMethod", this.getStatusCallbackMethod().toString());
        }
        if (this.getByoc() != null) {
            attrs.put("byoc", this.getByoc());
        }
        if (this.getMachineDetection() != null) {
            attrs.put("machineDetection", this.getMachineDetection());
        }
        if (this.getAmdStatusCallbackMethod() != null) {
            attrs.put("amdStatusCallbackMethod", this.getAmdStatusCallbackMethod().toString());
        }
        if (this.getAmdStatusCallback() != null) {
            attrs.put("amdStatusCallback", this.getAmdStatusCallback());
        }
        if (this.getMachineDetectionTimeout() != null) {
            attrs.put("machineDetectionTimeout", this.getMachineDetectionTimeout().toString());
        }
        if (this.getMachineDetectionSpeechThreshold() != null) {
            attrs.put("machineDetectionSpeechThreshold", this.getMachineDetectionSpeechThreshold().toString());
        }
        if (this.getMachineDetectionSpeechEndThreshold() != null) {
            attrs.put("machineDetectionSpeechEndThreshold", this.getMachineDetectionSpeechEndThreshold().toString());
        }
        if (this.getMachineDetectionSilenceTimeout() != null) {
            attrs.put("machineDetectionSilenceTimeout", this.getMachineDetectionSilenceTimeout().toString());
        }

        return attrs;
    }

    /**
     * DTMF tones to play when the call is answered
     *
     * @return DTMF tones to play when the call is answered
     */
    public String getSendDigits() {
        return sendDigits;
    }

    /**
     * TwiML URL
     *
     * @return TwiML URL
     */
    public URI getUrl() {
        return url;
    }

    /**
     * TwiML URL method
     *
     * @return TwiML URL method
     */
    public HttpMethod getMethod() {
        return method;
    }

    /**
     * Events to call status callback
     *
     * @return Events to call status callback
     */
    public List<Number.Event> getStatusCallbackEvents() {
        return statusCallbackEvent;
    }

    protected String getStatusCallbackEventsAsString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Number.Event> iter = this.getStatusCallbackEvents().iterator();
        while (iter.hasNext()) {
            sb.append(iter.next().toString());
            if (iter.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * Status callback URL
     *
     * @return Status callback URL
     */
    public URI getStatusCallback() {
        return statusCallback;
    }

    /**
     * Status callback URL method
     *
     * @return Status callback URL method
     */
    public HttpMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    /**
     * BYOC trunk SID (Beta)
     *
     * @return BYOC trunk SID (Beta)
     */
    public String getByoc() {
        return byoc;
    }

    /**
     * Enable machine detection or end of greeting detection
     *
     * @return Enable machine detection or end of greeting detection
     */
    public String getMachineDetection() {
        return machineDetection;
    }

    /**
     * HTTP Method to use with amd_status_callback
     *
     * @return HTTP Method to use with amd_status_callback
     */
    public HttpMethod getAmdStatusCallbackMethod() {
        return amdStatusCallbackMethod;
    }

    /**
     * The URL we should call to send amd status information to your application
     *
     * @return The URL we should call to send amd status information to your
     *         application
     */
    public String getAmdStatusCallback() {
        return amdStatusCallback;
    }

    /**
     * Number of seconds to wait for machine detection
     *
     * @return Number of seconds to wait for machine detection
     */
    public Integer getMachineDetectionTimeout() {
        return machineDetectionTimeout;
    }

    /**
     * Number of milliseconds for measuring stick for the length of the speech
     * activity
     *
     * @return Number of milliseconds for measuring stick for the length of the
     *         speech activity
     */
    public Integer getMachineDetectionSpeechThreshold() {
        return machineDetectionSpeechThreshold;
    }

    /**
     * Number of milliseconds of silence after speech activity
     *
     * @return Number of milliseconds of silence after speech activity
     */
    public Integer getMachineDetectionSpeechEndThreshold() {
        return machineDetectionSpeechEndThreshold;
    }

    /**
     * Number of milliseconds of initial silence
     *
     * @return Number of milliseconds of initial silence
     */
    public Integer getMachineDetectionSilenceTimeout() {
        return machineDetectionSilenceTimeout;
    }

    /**
     * Phone Number to dial
     *
     * @return Phone Number to dial
     */
    public com.kandy.type.PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Create a new {@code <Number>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <Number.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                        "Failed to deserialize a Number.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private String sendDigits;
        private URI url;
        private HttpMethod method;
        private List<Number.Event> statusCallbackEvent;
        private URI statusCallback;
        private HttpMethod statusCallbackMethod;
        private String byoc;
        private String machineDetection;
        private HttpMethod amdStatusCallbackMethod;
        private String amdStatusCallback;
        private Integer machineDetectionTimeout;
        private Integer machineDetectionSpeechThreshold;
        private Integer machineDetectionSpeechEndThreshold;
        private Integer machineDetectionSilenceTimeout;
        private com.kandy.type.PhoneNumber phoneNumber;

        /**
         * Create a {@code <Number>} with phoneNumber
         */
        public Builder(com.kandy.type.PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        /**
         * Create a {@code <Number>} with phoneNumber
         */
        public Builder(String phoneNumber) {
            this.phoneNumber = Promoter.phoneNumberFromString(phoneNumber);
        }

        /**
         * Create a {@code <Number>} (for XML deserialization)
         */
        private Builder() {
        }

        /**
         * DTMF tones to play when the call is answered
         */
        @JacksonXmlProperty(isAttribute = true, localName = "sendDigits")
        public Builder sendDigits(String sendDigits) {
            this.sendDigits = sendDigits;
            return this;
        }

        /**
         * TwiML URL
         */
        @JacksonXmlProperty(isAttribute = true, localName = "url")
        public Builder url(URI url) {
            this.url = url;
            return this;
        }

        /**
         * TwiML URL
         */
        public Builder url(String url) {
            this.url = Promoter.uriFromString(url);
            return this;
        }

        /**
         * TwiML URL method
         */
        @JacksonXmlProperty(isAttribute = true, localName = "method")
        public Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        /**
         * Events to call status callback
         */
        @JacksonXmlProperty(isAttribute = true, localName = "statusCallbackEvent")
        public Builder statusCallbackEvents(List<Number.Event> statusCallbackEvent) {
            this.statusCallbackEvent = statusCallbackEvent;
            return this;
        }

        /**
         * Events to call status callback
         */
        public Builder statusCallbackEvents(Number.Event statusCallbackEvent) {
            this.statusCallbackEvent = Promoter.listOfOne(statusCallbackEvent);
            return this;
        }

        /**
         * Status callback URL
         */
        @JacksonXmlProperty(isAttribute = true, localName = "statusCallback")
        public Builder statusCallback(URI statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        /**
         * Status callback URL
         */
        public Builder statusCallback(String statusCallback) {
            this.statusCallback = Promoter.uriFromString(statusCallback);
            return this;
        }

        /**
         * Status callback URL method
         */
        @JacksonXmlProperty(isAttribute = true, localName = "statusCallbackMethod")
        public Builder statusCallbackMethod(HttpMethod statusCallbackMethod) {
            this.statusCallbackMethod = statusCallbackMethod;
            return this;
        }

        /**
         * BYOC trunk SID (Beta)
         */
        @JacksonXmlProperty(isAttribute = true, localName = "byoc")
        public Builder byoc(String byoc) {
            this.byoc = byoc;
            return this;
        }

        /**
         * Enable machine detection or end of greeting detection
         */
        @JacksonXmlProperty(isAttribute = true, localName = "machineDetection")
        public Builder machineDetection(String machineDetection) {
            this.machineDetection = machineDetection;
            return this;
        }

        /**
         * HTTP Method to use with amd_status_callback
         */
        @JacksonXmlProperty(isAttribute = true, localName = "amdStatusCallbackMethod")
        public Builder amdStatusCallbackMethod(HttpMethod amdStatusCallbackMethod) {
            this.amdStatusCallbackMethod = amdStatusCallbackMethod;
            return this;
        }

        /**
         * The URL we should call to send amd status information to your application
         */
        @JacksonXmlProperty(isAttribute = true, localName = "amdStatusCallback")
        public Builder amdStatusCallback(String amdStatusCallback) {
            this.amdStatusCallback = amdStatusCallback;
            return this;
        }

        /**
         * Number of seconds to wait for machine detection
         */
        @JacksonXmlProperty(isAttribute = true, localName = "machineDetectionTimeout")
        public Builder machineDetectionTimeout(Integer machineDetectionTimeout) {
            this.machineDetectionTimeout = machineDetectionTimeout;
            return this;
        }

        /**
         * Number of milliseconds for measuring stick for the length of the speech
         * activity
         */
        @JacksonXmlProperty(isAttribute = true, localName = "machineDetectionSpeechThreshold")
        public Builder machineDetectionSpeechThreshold(Integer machineDetectionSpeechThreshold) {
            this.machineDetectionSpeechThreshold = machineDetectionSpeechThreshold;
            return this;
        }

        /**
         * Number of milliseconds of silence after speech activity
         */
        @JacksonXmlProperty(isAttribute = true, localName = "machineDetectionSpeechEndThreshold")
        public Builder machineDetectionSpeechEndThreshold(Integer machineDetectionSpeechEndThreshold) {
            this.machineDetectionSpeechEndThreshold = machineDetectionSpeechEndThreshold;
            return this;
        }

        /**
         * Number of milliseconds of initial silence
         */
        @JacksonXmlProperty(isAttribute = true, localName = "machineDetectionSilenceTimeout")
        public Builder machineDetectionSilenceTimeout(Integer machineDetectionSilenceTimeout) {
            this.machineDetectionSilenceTimeout = machineDetectionSilenceTimeout;
            return this;
        }

        /**
         * Create and return resulting {@code <Number>} element
         */
        public Number build() {
            return new Number(this);
        }
    }
}
