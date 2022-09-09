package com.diego.bookstore.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6243055675932809135L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
