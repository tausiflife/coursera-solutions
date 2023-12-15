package com.ooad.ticketbookingsystem.controller;

import com.ooad.ticketbookingsystem.model.Seat;
import com.ooad.ticketbookingsystem.model.Show;
import com.ooad.ticketbookingsystem.service.BookingService;
import com.ooad.ticketbookingsystem.service.ShowService;
import com.ooad.ticketbookingsystem.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private BookingService bookingService;
    private ShowService showService;
    private UserService userService;

    public BookingController(BookingService bookingService, ShowService showService, UserService userService) {
        this.bookingService = bookingService;
        this.showService = showService;
        this.userService = userService;
    }

    public String createBooking(String showId, String userId, List<String> seatIds) {
        Show show = showService.getShow(showId);
        List<Seat> seats = show.getScreen().getSeats().stream().filter(s -> seatIds.contains(s.getSeatNo()))
                .collect(Collectors.toList());
        return bookingService.createBooking(show, seats, userService.getUser(userId)).getId();
    }

}
