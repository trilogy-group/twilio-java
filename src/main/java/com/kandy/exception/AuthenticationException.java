package com.kandy.exception;

public class AuthenticationException extends KandyException {

    private static final long serialVersionUID = -7779574072471080781L;

    public AuthenticationException(final String message) {
        super(message);
    }
}
