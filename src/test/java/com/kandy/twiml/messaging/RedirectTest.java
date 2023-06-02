/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.messaging;

import com.kandy.http.HttpMethod;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * Test class for {@link Redirect}
 */
public class RedirectTest {
    @Test
    public void testElementWithParams() {
        Redirect elem = new Redirect.Builder(URI.create("https://example.com")).method(HttpMethod.GET).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Redirect method=\"GET\">https://example.com</Redirect>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Redirect elem = new Redirect.Builder(URI.create("https://example.com")).method(HttpMethod.GET).build();

        Assert.assertEquals(
                Redirect.Builder.fromXml("<Redirect method=\"GET\">https://example.com</Redirect>").build().toXml(),
                elem.toXml());
    }
}
