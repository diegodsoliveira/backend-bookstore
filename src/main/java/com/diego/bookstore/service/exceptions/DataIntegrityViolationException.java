package com.diego.bookstore.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 5376985535605064928L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
