package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.model.Seat;
import com.ooad.ticketbookingsystem.model.Show;
import com.ooad.ticketbookingsystem.model.User;

import java.util.List;

public class InMemorySeatLockService implements SeatLockService {
    @Override
    public synchronized void lockSeats(Show show, List<Seat> seats, User user) {

    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, User user) {

    }

    @Override
    public boolean validateLock(Show show, Seat seat, User user) {
        return false;
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        return null;
    }
}
