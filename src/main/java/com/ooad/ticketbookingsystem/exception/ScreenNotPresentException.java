package com.ooad.ticketbookingsystem.exception;

public class ScreenNotPresentException extends BusinessException {

    public ScreenNotPresentException(String message, String errorCode) {
        super(message, errorCode);
    }
}
