/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.voice;

import com.kandy.converter.Promoter;
import com.kandy.http.HttpMethod;
import com.kandy.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.List;

/**
 * Test class for {@link Application}
 */
public class ApplicationTest {
    @Test
    public void testEmptyElement() {
        Application elem = new Application.Builder().build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application/>",
                elem.toXml());
    }

    @Test
    public void testEmptyElementUrl() {
        Application elem = new Application.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CApplication%2F%3E",
                elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Application elem = new Application.Builder("application_sid")
                .url(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .statusCallbackEvents(Promoter.listOfOne(Application.Event.INITIATED))
                .statusCallback(URI.create("https://example.com"))
                .statusCallbackMethod(HttpMethod.GET)
                .customerId("customer_id")
                .copyParentTo(true)
                .build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application copyParentTo=\"true\" customerId=\"customer_id\" method=\"GET\" statusCallback=\"https://example.com\" statusCallbackEvent=\"initiated\" statusCallbackMethod=\"GET\" url=\"https://example.com\">application_sid</Application>",
                elem.toXml());
    }

    @Test
    public void testElementWithExtraAttributes() {
        Application elem = new Application.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application a=\"b\" foo=\"bar\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithChildren() {
        Application.Builder builder = new Application.Builder();

        builder.applicationSid(new ApplicationSid.Builder("sid").build());

        builder.parameter(new Parameter.Builder().name("name").value("value").build());

        Application elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application>" +
                        "<ApplicationSid>sid</ApplicationSid>" +
                        "<Parameter name=\"name\" value=\"value\"/>" +
                        "</Application>",
                elem.toXml());
    }

    @Test
    public void testElementWithTextNode() {
        Application.Builder builder = new Application.Builder();

        builder.addText("Hey no tags!");

        Application elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application>" +
                        "Hey no tags!" +
                        "</Application>",
                elem.toXml());
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Application.Builder builder = new Application.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application>" +
                        "before" +
                        "<Child>content</Child>" +
                        "after" +
                        "</Application>",
                builder.build().toXml());
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Application.Builder builder = new Application.Builder();
        Application elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application>" +
                        "<genericTag>" +
                        "Some text" +
                        "</genericTag>" +
                        "</Application>",
                elem.toXml());
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        Application.Builder builder = new Application.Builder();
        Application elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Application>" +
                        "<genericTag key=\"value\">" +
                        "someText" +
                        "</genericTag>" +
                        "</Application>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Application elem = new Application.Builder("application_sid")
                .url(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .statusCallbackEvents(Promoter.listOfOne(Application.Event.INITIATED))
                .statusCallback(URI.create("https://example.com"))
                .statusCallbackMethod(HttpMethod.GET)
                .customerId("customer_id")
                .copyParentTo(true)
                .build();

        Assert.assertEquals(
                Application.Builder.fromXml(
                        "<Application copyParentTo=\"true\" customerId=\"customer_id\" method=\"GET\" statusCallback=\"https://example.com\" statusCallbackEvent=\"initiated\" statusCallbackMethod=\"GET\" url=\"https://example.com\">application_sid</Application>")
                        .build().toXml(),
                elem.toXml());
    }

    @Test
    public void testXmlChildrenDeserialization() {
        final Application.Builder builder = new Application.Builder();

        builder.applicationSid(new ApplicationSid.Builder("sid").build());

        builder.parameter(new Parameter.Builder().name("name").value("value").build());

        final Application elem = builder.build();

        Assert.assertEquals(
                Application.Builder.fromXml("<Application>" +
                        "<ApplicationSid>sid</ApplicationSid>" +
                        "<Parameter name=\"name\" value=\"value\"/>" +
                        "</Application>").build().toXml(),
                elem.toXml());
    }

    @Test
    public void testXmlEmptyChildrenDeserialization() {
        final Application.Builder builder = new Application.Builder();

        builder.parameter(new Parameter.Builder().build());

        final Application elem = builder.build();

        Assert.assertEquals(
                Application.Builder.fromXml("<Application>" +
                        "<Parameter/>" +
                        "</Application>").build().toXml(),
                elem.toXml());
    }
}
