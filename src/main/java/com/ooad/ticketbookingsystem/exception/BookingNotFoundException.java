package com.ooad.ticketbookingsystem.exception;

public class BookingNotFoundException extends BusinessException{
    public BookingNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }
}
