package com.ooad.ticketbookingsystem.model;

import com.ooad.ticketbookingsystem.exception.ErrorCodes;
import com.ooad.ticketbookingsystem.exception.InvalidBookingState;

import java.util.List;

public class Booking {
    private String id;
    private Show show;
    private List<Seat> seats;
    private User user;
    private BookingStatus status;

    public Booking(String id, Show show, List<Seat> seats, User user, BookingStatus status) {
        this.id = id;
        this.show = show;
        this.seats = seats;
        this.user = user;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public User getUser() {
        return user;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public boolean isConfirmed() {
        return this.status == BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if(status != BookingStatus.PENDING)
            throw new InvalidBookingState("Booking either confirmed or expired.",
                    ErrorCodes.INVALID_BOOKING_STATE);
        status = BookingStatus.EXPIRED;
    }

    public void confirmBooking() {
        if(status != BookingStatus.PENDING)
            throw new InvalidBookingState("Booking either confirmed or expired.",
                    ErrorCodes.INVALID_BOOKING_STATE);
        status = BookingStatus.CONFIRMED;
    }

    public void failedBooking() {
        if(status != BookingStatus.PENDING)
            throw new InvalidBookingState("Booking either confirmed or expired.",
                    ErrorCodes.INVALID_BOOKING_STATE);
        status = BookingStatus.FAILED;
    }
}
