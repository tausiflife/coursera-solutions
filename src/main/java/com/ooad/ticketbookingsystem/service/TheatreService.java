package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.exception.ErrorCodes;
import com.ooad.ticketbookingsystem.exception.TheatreNotPresentException;
import com.ooad.ticketbookingsystem.model.Screen;
import com.ooad.ticketbookingsystem.model.Seat;
import com.ooad.ticketbookingsystem.model.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {
    private final Map<String, Theatre> theatres;
    private final IdGenerator idGenerator;

    public TheatreService(IdGenerator idGenerator) {
        this.theatres = new HashMap<>();
        this.idGenerator = idGenerator;
    }

    public Theatre createTheatre(String name) {
        String id = this.idGenerator.generate();
        Theatre theatre = new Theatre(id, name);
        this.theatres.put(id, theatre);
        return theatre;
    }

    public Theatre getTheatre(String theatreId) {
        validateTheatre(theatreId);
        return theatres.get(theatreId);
    }

    public Screen createScreenInTheatre(String screenName, String theatreId) {
        validateTheatre(theatreId);
        String id = this.idGenerator.generate();
        Theatre theatre = theatres.get(theatreId);
        Screen screen = new Screen(id, screenName, theatre);
        theatre.addScreen(screen);
        return screen;
    }

    public Seat createSeatInScreen(String theatreId, String screenId, int row, int seatNo) {
        validateTheatre(theatreId);
        Theatre theatre = this.theatres.get(theatreId);
        String id = this.idGenerator.generate();
        Seat seat = new Seat(id, row, seatNo);
        theatre.addSeatInScreen(seat, screenId);
        return seat;
    }

    private void validateTheatre(String theatreId ){
        if(!this.theatres.containsKey(theatreId))
            throw new TheatreNotPresentException("Theatre absent", ErrorCodes.THEATRE_ABSENT);
    }
}
