/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.messaging;

import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * Test class for {@link Media}
 */
public class MediaTest {
    @Test
    public void testElementWithParams() {
        Media elem = new Media.Builder(URI.create("https://example.com")).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Media>https://example.com</Media>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Media elem = new Media.Builder(URI.create("https://example.com")).build();

        Assert.assertEquals(
                Media.Builder.fromXml("<Media>https://example.com</Media>").build().toXml(),
                elem.toXml());
    }
}
