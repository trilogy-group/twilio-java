package com.kandy.exception;

import com.kandy.http.Request;
import com.kandy.http.Response;

public class CertificateValidationException extends KandyException {

    private final Request request;
    private final Response response;

    public CertificateValidationException(final String message, final Request request, final Response response) {
        super(message);

        this.request = request;
        this.response = response;
    }

    public CertificateValidationException(final String message, final Request request) {
        this(message, request, null);
    }

    public Request getRequest() {
        return this.request;
    }

    public Response getResponse() {
        return this.response;
    }
}
