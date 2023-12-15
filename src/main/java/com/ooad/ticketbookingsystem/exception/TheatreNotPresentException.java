package com.ooad.ticketbookingsystem.exception;

public class TheatreNotPresentException extends BusinessException {
    public TheatreNotPresentException(String message, String errorCode) {
        super(message, errorCode);
    }
}
