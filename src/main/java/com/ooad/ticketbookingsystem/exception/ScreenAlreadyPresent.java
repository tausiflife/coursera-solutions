package com.ooad.ticketbookingsystem.exception;

public class ScreenAlreadyPresent extends BusinessException {
    public ScreenAlreadyPresent(String message, String errorCode) {
        super(message, errorCode);
    }
}
