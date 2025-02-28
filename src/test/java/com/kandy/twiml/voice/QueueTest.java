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
 * Test class for {@link Queue}
 */
public class QueueTest {
    @Test
    public void testElementWithParams() {
        Queue elem = new Queue.Builder("name")
                .url(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .reservationSid("reservation_sid")
                .postWorkActivitySid("post_work_activity_sid")
                .build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Queue method=\"GET\" postWorkActivitySid=\"post_work_activity_sid\" reservationSid=\"reservation_sid\" url=\"https://example.com\">name</Queue>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Queue elem = new Queue.Builder("name")
                .url(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .reservationSid("reservation_sid")
                .postWorkActivitySid("post_work_activity_sid")
                .build();

        Assert.assertEquals(
                Queue.Builder.fromXml(
                        "<Queue method=\"GET\" postWorkActivitySid=\"post_work_activity_sid\" reservationSid=\"reservation_sid\" url=\"https://example.com\">name</Queue>")
                        .build().toXml(),
                elem.toXml());
    }
}
