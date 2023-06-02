/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.kandy.twiml.voice;

import com.kandy.converter.Promoter;
import com.kandy.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.List;

/**
 * Test class for {@link Prompt}
 */
public class PromptTest {
    @Test
    public void testEmptyElement() {
        Prompt elem = new Prompt.Builder().build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt/>",
                elem.toXml());
    }

    @Test
    public void testEmptyElementUrl() {
        Prompt elem = new Prompt.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CPrompt%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Prompt elem = new Prompt.Builder()
                .for_(Prompt.For.PAYMENT_CARD_NUMBER)
                .errorTypes(Promoter.listOfOne(Prompt.ErrorType.TIMEOUT))
                .cardTypes(Promoter.listOfOne(Prompt.CardType.VISA))
                .attempts(Promoter.listOfOne(1))
                .requireMatchingInputs(true)
                .build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt attempt=\"1\" cardType=\"visa\" errorType=\"timeout\" for=\"payment-card-number\" requireMatchingInputs=\"true\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithExtraAttributes() {
        Prompt elem = new Prompt.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt a=\"b\" foo=\"bar\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithChildren() {
        Prompt.Builder builder = new Prompt.Builder();

        builder.say(new Say.Builder("message").voice(Say.Voice.MAN).loop(1).language(Say.Language.ARB).build());

        builder.play(new Play.Builder(URI.create("https://example.com")).loop(1).digits("digits").build());

        builder.pause(new Pause.Builder().length(1).build());

        Prompt elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt>" +
                        "<Say language=\"arb\" loop=\"1\" voice=\"man\">message</Say>" +
                        "<Play digits=\"digits\" loop=\"1\">https://example.com</Play>" +
                        "<Pause length=\"1\"/>" +
                        "</Prompt>",
                elem.toXml());
    }

    @Test
    public void testElementWithTextNode() {
        Prompt.Builder builder = new Prompt.Builder();

        builder.addText("Hey no tags!");

        Prompt elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt>" +
                        "Hey no tags!" +
                        "</Prompt>",
                elem.toXml());
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Prompt.Builder builder = new Prompt.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt>" +
                        "before" +
                        "<Child>content</Child>" +
                        "after" +
                        "</Prompt>",
                builder.build().toXml());
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Prompt.Builder builder = new Prompt.Builder();
        Prompt elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt>" +
                        "<genericTag>" +
                        "Some text" +
                        "</genericTag>" +
                        "</Prompt>",
                elem.toXml());
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        Prompt.Builder builder = new Prompt.Builder();
        Prompt elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<Prompt>" +
                        "<genericTag key=\"value\">" +
                        "someText" +
                        "</genericTag>" +
                        "</Prompt>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Prompt elem = new Prompt.Builder()
                .for_(Prompt.For.PAYMENT_CARD_NUMBER)
                .errorTypes(Promoter.listOfOne(Prompt.ErrorType.TIMEOUT))
                .cardTypes(Promoter.listOfOne(Prompt.CardType.VISA))
                .attempts(Promoter.listOfOne(1))
                .requireMatchingInputs(true)
                .build();

        Assert.assertEquals(
                Prompt.Builder.fromXml(
                        "<Prompt attempt=\"1\" cardType=\"visa\" errorType=\"timeout\" for=\"payment-card-number\" requireMatchingInputs=\"true\"/>")
                        .build().toXml(),
                elem.toXml());
    }

    @Test
    public void testXmlChildrenDeserialization() {
        final Prompt.Builder builder = new Prompt.Builder();

        builder.say(new Say.Builder("message").voice(Say.Voice.MAN).loop(1).language(Say.Language.ARB).build());

        builder.play(new Play.Builder(URI.create("https://example.com")).loop(1).digits("digits").build());

        builder.pause(new Pause.Builder().length(1).build());

        final Prompt elem = builder.build();

        Assert.assertEquals(
                Prompt.Builder.fromXml("<Prompt>" +
                        "<Say language=\"arb\" loop=\"1\" voice=\"man\">message</Say>" +
                        "<Play digits=\"digits\" loop=\"1\">https://example.com</Play>" +
                        "<Pause length=\"1\"/>" +
                        "</Prompt>").build().toXml(),
                elem.toXml());
    }

    @Test
    public void testXmlEmptyChildrenDeserialization() {
        final Prompt.Builder builder = new Prompt.Builder();

        builder.say(new Say.Builder().build());

        builder.pause(new Pause.Builder().build());

        final Prompt elem = builder.build();

        Assert.assertEquals(
                Prompt.Builder.fromXml("<Prompt>" +
                        "<Say/>" +
                        "<Pause/>" +
                        "</Prompt>").build().toXml(),
                elem.toXml());
    }
}
