/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.voice;

import com.kandy.http.HttpMethod;
import com.kandy.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * Test class for {@link Refer}
 */
public class ReferTest {
    @Test
    public void testEmptyElement() {
        Refer elem = new Refer.Builder().build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer/>",
                elem.toXml());
    }

    @Test
    public void testEmptyElementUrl() {
        Refer elem = new Refer.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CRefer%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Refer elem = new Refer.Builder().action(URI.create("https://example.com")).method(HttpMethod.GET).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer action=\"https://example.com\" method=\"GET\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithExtraAttributes() {
        Refer elem = new Refer.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer a=\"b\" foo=\"bar\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithChildren() {
        Refer.Builder builder = new Refer.Builder();

        builder.sip(new ReferSip.Builder(URI.create("https://example.com")).build());

        Refer elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer>" +
                        "<Sip>https://example.com</Sip>" +
                        "</Refer>",
                elem.toXml());
    }

    @Test
    public void testElementWithTextNode() {
        Refer.Builder builder = new Refer.Builder();

        builder.addText("Hey no tags!");

        Refer elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer>" +
                        "Hey no tags!" +
                        "</Refer>",
                elem.toXml());
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Refer.Builder builder = new Refer.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer>" +
                        "before" +
                        "<Child>content</Child>" +
                        "after" +
                        "</Refer>",
                builder.build().toXml());
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Refer.Builder builder = new Refer.Builder();
        Refer elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer>" +
                        "<genericTag>" +
                        "Some text" +
                        "</genericTag>" +
                        "</Refer>",
                elem.toXml());
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        Refer.Builder builder = new Refer.Builder();
        Refer elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Refer>" +
                        "<genericTag key=\"value\">" +
                        "someText" +
                        "</genericTag>" +
                        "</Refer>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Refer elem = new Refer.Builder().action(URI.create("https://example.com")).method(HttpMethod.GET).build();

        Assert.assertEquals(
                Refer.Builder.fromXml("<Refer action=\"https://example.com\" method=\"GET\"/>").build().toXml(),
                elem.toXml());
    }

    @Test
    public void testXmlChildrenDeserialization() {
        final Refer.Builder builder = new Refer.Builder();

        builder.sip(new ReferSip.Builder(URI.create("https://example.com")).build());

        final Refer elem = builder.build();

        Assert.assertEquals(
                Refer.Builder.fromXml("<Refer>" +
                        "<Sip>https://example.com</Sip>" +
                        "</Refer>").build().toXml(),
                elem.toXml());
    }
}
