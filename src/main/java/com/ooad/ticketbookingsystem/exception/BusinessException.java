package com.ooad.ticketbookingsystem.exception;

public class BusinessException extends RuntimeException {
    private String errorCode;

    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
