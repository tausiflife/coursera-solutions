package com.ooad.ticketbookingsystem.exception;

public class InvalidBookingState extends BusinessException {
    public InvalidBookingState(String message, String errorCode) {
        super(message, errorCode);
    }
}
