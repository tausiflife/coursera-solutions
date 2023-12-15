package com.ooad.splitwise.exceptions;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException(String message, String code) {
        super(message, code);
    }
}
