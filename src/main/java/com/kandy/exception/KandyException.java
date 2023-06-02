package com.kandy.exception;

public abstract class KandyException extends RuntimeException {

    private static final long serialVersionUID = 2516935680980388130L;

    public KandyException(final String message) {
        this(message, null);
    }

    public KandyException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
