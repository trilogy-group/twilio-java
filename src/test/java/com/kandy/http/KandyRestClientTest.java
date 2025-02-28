package com.kandy.http;

import com.kandy.rest.Domains;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class KandyRestClientTest {
        private KandyRestClient kandyRestClient;
        @Mock
        private HttpClient httpClient;

        private KandyRestClient kandyRestClientExtension;

        private List<String> userAgentStringExtensions = Arrays.asList("ce-appointment-reminders/1.0.0",
                        "code-exchange");

        private static final String USER_NAME = "AC123";

        private static final String TOKEN = "AUTH TOKEN";

        private static final String URI = "/2010-04-01/Accounts/AC123/Messages/MM123.json";

        @Before
        public void setUp() throws Exception {
                MockitoAnnotations.initMocks(this);
                kandyRestClient = new KandyRestClient(
                                new KandyRestClient.Builder("AC123", "AUTH TOKEN").httpClient(httpClient));
        }

        @Test
        public void testRequest() {
                Request request = new Request(
                                HttpMethod.GET,
                                Domains.API.toString(),
                                URI);
                when(httpClient.reliableRequest(request)).thenReturn(new Response("", 200));

                Response resp = kandyRestClient.request(request);
                assertNotNull(resp);
        }

        @Test
        public void testRequestWithExtension() {
                Request request = new Request(
                                HttpMethod.GET,
                                Domains.API.toString(),
                                URI);
                kandyRestClientExtension = new KandyRestClient.Builder(USER_NAME, TOKEN)
                                .userAgentExtensions(userAgentStringExtensions)
                                .build();
                kandyRestClientExtension.request(request);
                assertEquals(userAgentStringExtensions, request.getUserAgentExtensions());
        }

        @Test
        public void testRequestWithExtensionEmpty() {
                Request request = new Request(
                                HttpMethod.GET,
                                Domains.API.toString(),
                                URI);
                kandyRestClientExtension = new KandyRestClient.Builder(USER_NAME, TOKEN)
                                .userAgentExtensions(Collections.emptyList())
                                .build();
                kandyRestClientExtension.request(request);
                assertNull(request.getUserAgentExtensions());
        }

        @Test
        public void testRequestWithExtensionNull() {
                Request request = new Request(
                                HttpMethod.GET,
                                Domains.API.toString(),
                                URI);
                kandyRestClientExtension = new KandyRestClient.Builder(USER_NAME, TOKEN)
                                .userAgentExtensions(null)
                                .build();
                kandyRestClientExtension.request(request);
                assertNull(request.getUserAgentExtensions());
        }
}
