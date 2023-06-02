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
 * Test class for {@link Conversation}
 */
public class ConversationTest {
    @Test
    public void testEmptyElement() {
        Conversation elem = new Conversation.Builder().build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Conversation/>",
                elem.toXml());
    }

    @Test
    public void testEmptyElementUrl() {
        Conversation elem = new Conversation.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CConversation%2F%3E",
                elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Conversation elem = new Conversation.Builder()
                .serviceInstanceSid("service_instance_sid")
                .inboundAutocreation(true)
                .routingAssignmentTimeout(1)
                .inboundTimeout(1)
                .url(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .record(Conversation.Record.DO_NOT_RECORD)
                .trim(Conversation.Trim.TRIM_SILENCE)
                .recordingStatusCallback(URI.create("https://example.com"))
                .recordingStatusCallbackMethod(HttpMethod.GET)
                .recordingStatusCallbackEvents(Promoter.listOfOne(Conversation.RecordingEvent.IN_PROGRESS))
                .statusCallback(URI.create("https://example.com"))
                .statusCallbackMethod(HttpMethod.GET)
                .statusCallbackEvents(Promoter.listOfOne(Conversation.Event.CALL_INITIATED))
                .build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Conversation inboundAutocreation=\"true\" inboundTimeout=\"1\" method=\"GET\" record=\"do-not-record\" recordingStatusCallback=\"https://example.com\" recordingStatusCallbackEvent=\"in-progress\" recordingStatusCallbackMethod=\"GET\" routingAssignmentTimeout=\"1\" serviceInstanceSid=\"service_instance_sid\" statusCallback=\"https://example.com\" statusCallbackEvent=\"call-initiated\" statusCallbackMethod=\"GET\" trim=\"trim-silence\" url=\"https://example.com\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithExtraAttributes() {
        Conversation elem = new Conversation.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Conversation a=\"b\" foo=\"bar\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithTextNode() {
        Conversation.Builder builder = new Conversation.Builder();

        builder.addText("Hey no tags!");

        Conversation elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Conversation>" +
                        "Hey no tags!" +
                        "</Conversation>",
                elem.toXml());
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Conversation.Builder builder = new Conversation.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Conversation>" +
                        "before" +
                        "<Child>content</Child>" +
                        "after" +
                        "</Conversation>",
                builder.build().toXml());
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Conversation.Builder builder = new Conversation.Builder();
        Conversation elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Conversation>" +
                        "<genericTag>" +
                        "Some text" +
                        "</genericTag>" +
                        "</Conversation>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Conversation elem = new Conversation.Builder()
                .serviceInstanceSid("service_instance_sid")
                .inboundAutocreation(true)
                .routingAssignmentTimeout(1)
                .inboundTimeout(1)
                .url(URI.create("https://example.com"))
                .method(HttpMethod.GET)
                .record(Conversation.Record.DO_NOT_RECORD)
                .trim(Conversation.Trim.TRIM_SILENCE)
                .recordingStatusCallback(URI.create("https://example.com"))
                .recordingStatusCallbackMethod(HttpMethod.GET)
                .recordingStatusCallbackEvents(Promoter.listOfOne(Conversation.RecordingEvent.IN_PROGRESS))
                .statusCallback(URI.create("https://example.com"))
                .statusCallbackMethod(HttpMethod.GET)
                .statusCallbackEvents(Promoter.listOfOne(Conversation.Event.CALL_INITIATED))
                .build();

        Assert.assertEquals(
                Conversation.Builder.fromXml(
                        "<Conversation inboundAutocreation=\"true\" inboundTimeout=\"1\" method=\"GET\" record=\"do-not-record\" recordingStatusCallback=\"https://example.com\" recordingStatusCallbackEvent=\"in-progress\" recordingStatusCallbackMethod=\"GET\" routingAssignmentTimeout=\"1\" serviceInstanceSid=\"service_instance_sid\" statusCallback=\"https://example.com\" statusCallbackEvent=\"call-initiated\" statusCallbackMethod=\"GET\" trim=\"trim-silence\" url=\"https://example.com\"/>")
                        .build().toXml(),
                elem.toXml());
    }
}
