package com.kandy;

import com.kandy.exception.ApiException;
import com.kandy.exception.AuthenticationException;
import com.kandy.exception.CertificateValidationException;
import com.kandy.http.HttpMethod;
import com.kandy.http.NetworkHttpClient;
import com.kandy.http.Request;
import com.kandy.http.Response;
import com.kandy.http.KandyRestClient;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class KandyTest {

    private static final String USER_NAME = "UserName";

    private static final String TOKEN = "Password";

    public static String serialize(Object object) {
        return object.toString();
    }

    public static String serialize(List list) {
        // NOTE: This relies on the fact that integration tests only ever generate
        // single element lists.
        return list.get(0).toString();
    }

    @Mock
    private NetworkHttpClient networkHttpClient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetExecutorService() {
        assertNotNull(Kandy.getExecutorService());
    }

    @Test(expected = AuthenticationException.class)
    public void testGetRestClientNullAccountSid() {
        Kandy.setRestClient(null);
        Kandy.setUsername(null);
        Kandy.setPassword(null);

        Kandy.getRestClient();
        fail("AuthenticationException was expected");
    }

    @Test(expected = AuthenticationException.class)
    public void testSetAccountSidNull() {
        Kandy.setUsername(null);
        fail("AuthenticationException was expected");
    }

    @Test(expected = AuthenticationException.class)
    public void testSetAuthTokenNull() {
        Kandy.setPassword(null);
        fail("AuthenticationException was expected");
    }

    @Test
    public void testUserAgentExtensions() {
        Kandy.setUsername(USER_NAME);
        Kandy.setPassword(TOKEN);
        Kandy.setUserAgentExtensions(Arrays.asList("ce-appointment-reminders/1.0.0", "code-exchange"));
        Kandy.getRestClient();
        assertEquals(Arrays.asList("ce-appointment-reminders/1.0.0", "code-exchange"), Kandy.getUserAgentExtensions());
    }

    @Test
    public void testUserAgentExtensionsEmpty() {
        Kandy.setUsername(USER_NAME);
        Kandy.setPassword(TOKEN);
        Kandy.setUserAgentExtensions(Collections.emptyList()); // Resetting userAgentExtension
        Kandy.getRestClient();
        assertNull(Kandy.getUserAgentExtensions());
    }

    @Test
    public void testUserAgentExtensionsNull() {
        Kandy.setUsername(USER_NAME);
        Kandy.setPassword(TOKEN);
        Kandy.setUserAgentExtensions(null); // Resetting userAgentExtension
        Kandy.getRestClient();
        assertNull(Kandy.getUserAgentExtensions());
    }

    @Test
    public void testSetExecutorService() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Kandy.setExecutorService(executorService);
        assertEquals(executorService, Kandy.getExecutorService());
    }

    @Test
    public void testDestroyExecutorService() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Kandy.setExecutorService(executorService);
        Kandy.destroy();
        assertTrue(Kandy.getExecutorService().isShutdown());
    }

    @Test
    public void testSetRestClient() {
        KandyRestClient kandyRestClient = new KandyRestClient.Builder("AC123", "AUTH TOKEN").build();
        Kandy.setRestClient(kandyRestClient);
        assertEquals(kandyRestClient, Kandy.getRestClient());
    }

    @Test
    public void testValidateSslCertificateError() {
        final Request request = new Request(HttpMethod.GET, "https://api.twilio.com:8443");
        when(networkHttpClient.makeRequest(request)).thenReturn(new Response("", 500));
        try {
            Kandy.validateSslCertificate(networkHttpClient);
            fail("Excepted CertificateValidationException");
        } catch (final CertificateValidationException e) {
            assertEquals("Unexpected response from certificate endpoint", e.getMessage());
        }
    }

    @Test
    public void testValidateSslCertificateException() {
        final Request request = new Request(HttpMethod.GET, "https://api.twilio.com:8443");
        when(networkHttpClient.makeRequest(request)).thenThrow(new ApiException("No"));

        try {
            Kandy.validateSslCertificate(networkHttpClient);
            fail("Excepted CertificateValidationException");
        } catch (final CertificateValidationException e) {
            assertEquals("Could not get response from certificate endpoint", e.getMessage());
        }
    }

    @Test
    public void testValidateSslCertificateSuccess() {
        final Request request = new Request(HttpMethod.GET, "https://api.twilio.com:8443");
        when(networkHttpClient.makeRequest(request)).thenReturn(new Response("", 200));

        Kandy.validateSslCertificate(networkHttpClient);
    }
}
