package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.model.Booking;
import com.ooad.ticketbookingsystem.model.User;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private final Map<String, Booking> failedBookings;

    public PaymentService() {
        this.failedBookings = new HashMap<>();
    }

    public void processPaymentFailed(Booking booking, User user) {

    }
}
