package com.morphosium.api.exception;


public class CustomServiceException extends RuntimeException {
    private String message;

    public CustomServiceException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
