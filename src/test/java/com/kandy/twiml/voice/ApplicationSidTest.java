/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.voice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ApplicationSid}
 */
public class ApplicationSidTest {
    @Test
    public void testElementWithParams() {
        ApplicationSid elem = new ApplicationSid.Builder("sid").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<ApplicationSid>sid</ApplicationSid>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final ApplicationSid elem = new ApplicationSid.Builder("sid").build();

        Assert.assertEquals(
                ApplicationSid.Builder.fromXml("<ApplicationSid>sid</ApplicationSid>").build().toXml(),
                elem.toXml());
    }
}
