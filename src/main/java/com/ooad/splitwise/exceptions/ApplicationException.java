package com.ooad.splitwise.exceptions;

public class ApplicationException extends RuntimeException {

    private String code;

    public ApplicationException(String message, String code) {
        super(message);
        this.code = code;
    }
}
