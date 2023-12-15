package com.ooad.ticketbookingsystem.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Screen {
    private String id;
    private String name;
    private List<Show> shows;
    private Theatre theatre;
    private List<Seat> seats;

    public Screen(String id, String name, Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.shows = new ArrayList<>();
        this.seats = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Show> getShows() {
        return Collections.unmodifiableList(shows);
    }

    public List<Seat> getSeats() {
        return Collections.unmodifiableList(seats);
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }
}
