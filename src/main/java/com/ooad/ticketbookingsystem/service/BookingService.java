package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.exception.BookingNotFoundException;
import com.ooad.ticketbookingsystem.exception.ErrorCodes;
import com.ooad.ticketbookingsystem.model.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingService {
    private final Map<String, Booking> bookings;
    private final IdGenerator idGenerator;
    private final SeatLockService lockService;
    public BookingService(IdGenerator idGenerator, SeatLockService seatLockService) {
        this.idGenerator = idGenerator;
        bookings = new HashMap<>();
        lockService = seatLockService;
    }

    public Booking createBooking(Show show, List<Seat> seats, User user) {
        String id = this.idGenerator.generate();
        lockService.lockSeats(show, seats, user);
        Booking booking = new Booking(id, show, seats, user, BookingStatus.PENDING);
        this.bookings.put(id, booking);
        return booking;
    }

    public Booking getBooking(String bookingId) {
        validateBookingId(bookingId);
        return bookings.get(bookingId);
    }

    public boolean confirmBooking(String bookingId) {
        validateBookingId(bookingId);
        Booking booking = bookings.get(bookingId);
        for(Seat seat : booking.getSeats()) {
            if(!lockService.validateLock(booking.getShow(), seat, booking.getUser()));
        }
        booking.confirmBooking();
        return true;
    }

    public void failedBooking(String bookingId) {
        validateBookingId(bookingId);
        Booking booking = bookings.get(bookingId);
        booking.failedBooking();
    }
    public List<Seat> getAllBookedSeats(Show show){
        return this.bookings.values().stream()
                .filter(booking -> booking.getShow().equals(show))
                .filter(Booking::isConfirmed)
                .map(Booking::getSeats)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }
    private void validateBookingId(String bookingId) {
        if(!bookings.containsKey(bookingId))
            throw new BookingNotFoundException("Booking not found", ErrorCodes.BOOKING_NOT_FOUND);
    }
}
