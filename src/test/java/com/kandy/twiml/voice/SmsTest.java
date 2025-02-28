/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.voice;

import com.kandy.http.HttpMethod;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * Test class for {@link Sms}
 */
public class SmsTest {
    @Test
    public void testElementWithParams() {
        Sms elem = new Sms.Builder("message")
                .to(new com.kandy.type.PhoneNumber("+15558675310"))
                .from(new com.kandy.type.PhoneNumber("+15017122661"))
                .action(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .statusCallback(URI.create("https://example.com"))
                .build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Sms action=\"https://example.com\" from=\"+15017122661\" method=\"GET\" statusCallback=\"https://example.com\" to=\"+15558675310\">message</Sms>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Sms elem = new Sms.Builder("message")
                .to(new com.kandy.type.PhoneNumber("+15558675310"))
                .from(new com.kandy.type.PhoneNumber("+15017122661"))
                .action(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .statusCallback(URI.create("https://example.com"))
                .build();

        Assert.assertEquals(
                Sms.Builder.fromXml(
                        "<Sms action=\"https://example.com\" from=\"+15017122661\" method=\"GET\" statusCallback=\"https://example.com\" to=\"+15558675310\">message</Sms>")
                        .build().toXml(),
                elem.toXml());
    }
}
