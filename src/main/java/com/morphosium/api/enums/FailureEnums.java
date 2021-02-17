package com.morphosium.api.enums;

public enum FailureEnums {

    FAILURE("FAILURE"),
    INVALID_AUTHORIZATION("INVALID_AUTHORIZATION"),
    INVALID_USER("INVALID_USER"),
    INVALID_CREDENTIALS("INVALID_CREDENTIALS"),
    USER_NOT_FOUND("USER_NOT_FOUND");

    private final String message;

    FailureEnums(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}