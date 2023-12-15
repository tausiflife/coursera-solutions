package com.ooad.ticketbookingsystem.model;

import java.time.LocalDateTime;

public class Show {
    private String id;
    private int durationInSecs;
    private LocalDateTime showTime;
    private Movie movie;
    private Screen screen;

    public Show(String id, int durationInSecs, LocalDateTime showTime, Movie movie, Screen screen) {
        this.id = id;
        this.durationInSecs = durationInSecs;
        this.showTime = showTime;
        this.movie = movie;
        this.screen = screen;
    }

    public String getId() {
        return id;
    }

    public int getDurationInSecs() {
        return durationInSecs;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }
}
