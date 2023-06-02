package com.kandy.http;

import com.kandy.jwt.Jwt;
import com.kandy.jwt.validation.ValidationToken;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.List;

public class ValidationInterceptor implements HttpRequestInterceptor {

    private static final List<String> HEADERS = Arrays.asList("authorization", "host");

    private final String accountSid;
    private final String credentialSid;
    private final String signingKeySid;
    private final PrivateKey privateKey;

    /**
     * Create a new ValidationInterceptor.
     *
     * @param accountSid    Kandy Acocunt SID
     * @param credentialSid Kandy Credential SID
     * @param signingKeySid Kandy Signing Key
     * @param privateKey    Private Key
     */
    public ValidationInterceptor(String accountSid, String credentialSid, String signingKeySid, PrivateKey privateKey) {
        this.accountSid = accountSid;
        this.credentialSid = credentialSid;
        this.signingKeySid = signingKeySid;
        this.privateKey = privateKey;
    }

    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        Jwt jwt = ValidationToken.fromHttpRequest(
                accountSid,
                credentialSid,
                signingKeySid,
                privateKey,
                request,
                HEADERS);
        request.addHeader("Kandy-Client-Validation", jwt.toJwt());
    }
}
