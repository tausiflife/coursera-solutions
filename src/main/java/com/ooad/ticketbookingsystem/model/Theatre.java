package com.ooad.ticketbookingsystem.model;

import com.ooad.ticketbookingsystem.exception.ErrorCodes;
import com.ooad.ticketbookingsystem.exception.ScreenAlreadyPresent;
import com.ooad.ticketbookingsystem.exception.ScreenNotPresentException;

import java.util.*;

public class Theatre {
    private String id;
    private String name;
    private Map<String, Screen> screens;

    public Theatre(String id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addScreen(Screen screen) {
        if(this.screens.containsKey(screen.getId()))
            throw new ScreenAlreadyPresent("Screen present in theatre",ErrorCodes.SCREEN_ALREADY_PRESENT);
        this.screens.put(screen.getId(), screen);
    }

    public void addSeatInScreen(Seat seat, String screenId) {
        validateScreenPresence(screenId);
        this.screens.get(screenId).addSeat(seat);
    }

    public void addShow(Show show, String screenId) {
        validateScreenPresence(screenId);
        this.screens.get(screenId).addShow(show);
    }

    private void validateScreenPresence(String screenId) {
        if(!this.screens.containsKey(screenId))
            throw new ScreenNotPresentException("Screen not present in this theatre", ErrorCodes.SCREEN_ABSENT);
    }

    public List<Show> getShowsForScreen(Screen screen) {
        return this.screens.get(screen.getId()).getShows();
    }

    public List<Seat> getSeatsInScreen(Screen screen) {
        return this.screens.get(screen.getId()).getSeats();
    }
}
