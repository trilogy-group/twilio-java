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
 * Test class for {@link Identity}
 */
public class IdentityTest {
    @Test
    public void testElementWithParams() {
        Identity elem = new Identity.Builder("client_identity").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Identity>client_identity</Identity>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Identity elem = new Identity.Builder("client_identity").build();

        Assert.assertEquals(
                Identity.Builder.fromXml("<Identity>client_identity</Identity>").build().toXml(),
                elem.toXml());
    }
}
