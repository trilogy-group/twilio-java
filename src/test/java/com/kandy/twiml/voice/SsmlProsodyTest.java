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
 * Test class for {@link SsmlProsody}
 */
public class SsmlProsodyTest {
    @Test
    public void testEmptyElement() {
        SsmlProsody elem = new SsmlProsody.Builder().build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody/>",
                elem.toXml());
    }

    @Test
    public void testEmptyElementUrl() {
        SsmlProsody elem = new SsmlProsody.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3Cprosody%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        SsmlProsody elem = new SsmlProsody.Builder("words").volume("volume").rate("rate").pitch("pitch").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody pitch=\"pitch\" rate=\"rate\" volume=\"volume\">words</prosody>",
                elem.toXml());
    }

    @Test
    public void testElementWithExtraAttributes() {
        SsmlProsody elem = new SsmlProsody.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody a=\"b\" foo=\"bar\"/>",
                elem.toXml());
    }

    @Test
    public void testElementWithChildren() {
        SsmlProsody.Builder builder = new SsmlProsody.Builder();

        builder.break_(new SsmlBreak.Builder().strength(SsmlBreak.Strength.NONE).time("time").build());

        builder.emphasis(new SsmlEmphasis.Builder("words").level(SsmlEmphasis.Level.STRONG).build());

        builder.lang(new SsmlLang.Builder("words").xmlLang(SsmlLang.XmlLang.ARB).build());

        builder.p(new SsmlP.Builder("words").build());

        builder.phoneme(new SsmlPhoneme.Builder("words").alphabet(SsmlPhoneme.Alphabet.IPA).ph("ph").build());

        builder.prosody(new SsmlProsody.Builder("words").volume("volume").rate("rate").pitch("pitch").build());

        builder.s(new SsmlS.Builder("words").build());

        builder.sayAs(new SsmlSayAs.Builder("words")
                .interpretAs(SsmlSayAs.InterpretAs.CHARACTERS)
                .format(SsmlSayAs.Format.MDY)
                .build());

        builder.sub(new SsmlSub.Builder("words").alias("alias").build());

        builder.w(new SsmlW.Builder("words").role("role").build());

        SsmlProsody elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody>" +
                        "<break strength=\"none\" time=\"time\"/>" +
                        "<emphasis level=\"strong\">words</emphasis>" +
                        "<lang xml:lang=\"arb\">words</lang>" +
                        "<p>words</p>" +
                        "<phoneme alphabet=\"ipa\" ph=\"ph\">words</phoneme>" +
                        "<prosody pitch=\"pitch\" rate=\"rate\" volume=\"volume\">words</prosody>" +
                        "<s>words</s>" +
                        "<say-as format=\"mdy\" interpret-as=\"characters\">words</say-as>" +
                        "<sub alias=\"alias\">words</sub>" +
                        "<w role=\"role\">words</w>" +
                        "</prosody>",
                elem.toXml());
    }

    @Test
    public void testElementWithTextNode() {
        SsmlProsody.Builder builder = new SsmlProsody.Builder();

        builder.addText("Hey no tags!");

        SsmlProsody elem = builder.build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody>" +
                        "Hey no tags!" +
                        "</prosody>",
                elem.toXml());
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        SsmlProsody.Builder builder = new SsmlProsody.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody>" +
                        "before" +
                        "<Child>content</Child>" +
                        "after" +
                        "</prosody>",
                builder.build().toXml());
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        SsmlProsody.Builder builder = new SsmlProsody.Builder();
        SsmlProsody elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody>" +
                        "<genericTag>" +
                        "Some text" +
                        "</genericTag>" +
                        "</prosody>",
                elem.toXml());
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        SsmlProsody.Builder builder = new SsmlProsody.Builder();
        SsmlProsody elem = builder.addChild(node).build();

        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<prosody>" +
                        "<genericTag key=\"value\">" +
                        "someText" +
                        "</genericTag>" +
                        "</prosody>",
                elem.toXml());
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final SsmlProsody elem = new SsmlProsody.Builder("words").volume("volume").rate("rate").pitch("pitch").build();

        Assert.assertEquals(
                SsmlProsody.Builder.fromXml("<prosody pitch=\"pitch\" rate=\"rate\" volume=\"volume\">words</prosody>")
                        .build().toXml(),
                elem.toXml());
    }

    @Test
    public void testXmlChildrenDeserialization() {
        final SsmlProsody.Builder builder = new SsmlProsody.Builder();

        builder.break_(new SsmlBreak.Builder().strength(SsmlBreak.Strength.NONE).time("time").build());

        builder.emphasis(new SsmlEmphasis.Builder("words").level(SsmlEmphasis.Level.STRONG).build());

        builder.lang(new SsmlLang.Builder("words").xmlLang(SsmlLang.XmlLang.ARB).build());

        builder.p(new SsmlP.Builder("words").build());

        builder.phoneme(new SsmlPhoneme.Builder("words").alphabet(SsmlPhoneme.Alphabet.IPA).ph("ph").build());

        builder.prosody(new SsmlProsody.Builder("words").volume("volume").rate("rate").pitch("pitch").build());

        builder.s(new SsmlS.Builder("words").build());

        builder.sayAs(new SsmlSayAs.Builder("words")
                .interpretAs(SsmlSayAs.InterpretAs.CHARACTERS)
                .format(SsmlSayAs.Format.MDY)
                .build());

        builder.sub(new SsmlSub.Builder("words").alias("alias").build());

        builder.w(new SsmlW.Builder("words").role("role").build());

        final SsmlProsody elem = builder.build();

        Assert.assertEquals(
                SsmlProsody.Builder.fromXml("<prosody>" +
                        "<break strength=\"none\" time=\"time\"/>" +
                        "<emphasis level=\"strong\">words</emphasis>" +
                        "<lang xml:lang=\"arb\">words</lang>" +
                        "<p>words</p>" +
                        "<phoneme alphabet=\"ipa\" ph=\"ph\">words</phoneme>" +
                        "<prosody pitch=\"pitch\" rate=\"rate\" volume=\"volume\">words</prosody>" +
                        "<s>words</s>" +
                        "<say-as format=\"mdy\" interpret-as=\"characters\">words</say-as>" +
                        "<sub alias=\"alias\">words</sub>" +
                        "<w role=\"role\">words</w>" +
                        "</prosody>").build().toXml(),
                elem.toXml());
    }

    @Test
    public void testXmlEmptyChildrenDeserialization() {
        final SsmlProsody.Builder builder = new SsmlProsody.Builder();

        builder.break_(new SsmlBreak.Builder().build());

        builder.emphasis(new SsmlEmphasis.Builder().build());

        builder.lang(new SsmlLang.Builder().build());

        builder.p(new SsmlP.Builder().build());

        builder.prosody(new SsmlProsody.Builder().build());

        builder.s(new SsmlS.Builder().build());

        builder.w(new SsmlW.Builder().build());

        final SsmlProsody elem = builder.build();

        Assert.assertEquals(
                SsmlProsody.Builder.fromXml("<prosody>" +
                        "<break/>" +
                        "<emphasis/>" +
                        "<lang/>" +
                        "<p/>" +
                        "<prosody/>" +
                        "<s/>" +
                        "<w/>" +
                        "</prosody>").build().toXml(),
                elem.toXml());
    }
}
