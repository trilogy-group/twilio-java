package com.kandy.type;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Test class for {@link IceServer}.
 */
public class IceServerTest extends TypeTest {

    @Test
    public void testFromJson() throws IOException {
        String json = "{\n" +
                "    \"credential\": \"apn\",\n" +
                "    \"username\": \"kandy\",\n" +
                "    \"url\": \"https://www.kandy.ca\",\n" +
                "    \"urls\": \"https://www.kandy.ca\"\n" +
                "}";

        IceServer is = fromJson(json, IceServer.class);
        Assert.assertEquals("https://www.kandy.ca", is.getUrl());
        Assert.assertEquals("https://www.kandy.ca", is.getUrls());
        Assert.assertEquals(is.getUrls(), is.getUrl());
        Assert.assertEquals("apn", is.getCredential());
        Assert.assertEquals("kandy", is.getUsername());
    }
}
