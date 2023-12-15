package com.ooad.ticketbookingsystem.controller;

import com.ooad.ticketbookingsystem.service.BookingService;
import com.ooad.ticketbookingsystem.service.PaymentService;
import com.ooad.ticketbookingsystem.service.UserService;

public class PaymentController {
    private final PaymentService paymentService;
    private final BookingService bookingService;
    private final UserService userService;

    public PaymentController(PaymentService paymentService, BookingService bookingService, UserService userService) {
        this.paymentService = paymentService;
        this.bookingService = bookingService;
        this.userService = userService;
    }

    public void bookingFailed(String bookingId) {
        bookingService.failedBooking(bookingId);
    }

    public void paymentSuccess(String bookingId, String userId) {
        bookingService.confirmBooking(bookingId);
    }
}
