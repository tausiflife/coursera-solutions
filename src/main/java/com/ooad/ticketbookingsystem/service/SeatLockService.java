package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.model.Seat;
import com.ooad.ticketbookingsystem.model.Show;
import com.ooad.ticketbookingsystem.model.User;

import java.util.List;

public interface SeatLockService {
    void lockSeats(Show show, List<Seat> seats, User user);
    void unlockSeats(Show show, List<Seat> seats, User user);
    boolean validateLock(Show show, Seat seat, User user);
    List<Seat> getLockedSeats(Show show);
}
