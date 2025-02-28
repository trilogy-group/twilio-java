/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.voice;

import com.kandy.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Parameter}
 */
public class ParameterTest {
    @Test
    public void testEmptyElement() {
        Parameter elem = new Parameter.Builder().build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Parameter/>",
                elem.toXml());
    }

    @Test
    public void testEmptyElementUrl() {
        Parameter elem = new Parameter.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CParameter%2F%3E",
                elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Parameter elem = new Parameter.Builder().name("name").value("value").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Parameter name=\"name\" value=\"value\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithExtraAttributes() {
        Parameter elem = new Parameter.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Parameter a=\"b\" foo=\"bar\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithTextNode() {
        Parameter.Builder builder = new Parameter.Builder();

        builder.addText("Hey no tags!");

        Parameter elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Parameter>" +
                        "Hey no tags!" +
                        "</Parameter>",
                elem.toXml());
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Parameter.Builder builder = new Parameter.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Parameter>" +
                        "before" +
                        "<Child>content</Child>" +
                        "after" +
                        "</Parameter>",
                builder.build().toXml());
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Parameter.Builder builder = new Parameter.Builder();
        Parameter elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Parameter>" +
                        "<genericTag>" +
                        "Some text" +
                        "</genericTag>" +
                        "</Parameter>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Parameter elem = new Parameter.Builder().name("name").value("value").build();

        Assert.assertEquals(
                Parameter.Builder.fromXml("<Parameter name=\"name\" value=\"value\"/>").build().toXml(),
                elem.toXml());
    }
}
