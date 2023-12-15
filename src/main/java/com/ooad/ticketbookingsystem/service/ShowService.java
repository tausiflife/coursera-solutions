package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.model.Movie;
import com.ooad.ticketbookingsystem.model.Screen;
import com.ooad.ticketbookingsystem.model.Show;
import com.ooad.ticketbookingsystem.model.Theatre;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ShowService {
    private final Map<String, Show> shows;
    private final IdGenerator idGenerator;

    public ShowService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        shows = new HashMap<>();
    }

    public Show createShow(int durationInSecs, LocalDateTime showTime, Movie movie, Screen screen) {
        String id = this.idGenerator.generate();
        Show show = new Show(id, durationInSecs, showTime, movie, screen);
        this.shows.put(id, show);
        return show;
    }

    public Show getShow(String showId) {
        return shows.get(showId);
    }

}
