package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.model.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieService {
    private final Map<String, Movie> movies;
    private final IdGenerator idGenerator;

    public MovieService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        movies = new HashMap<>();
    }

    public Movie createMovie(String name, String description, String genre, String language, int durationInSecs) {
        String id = this.idGenerator.generate();
        Movie movie = new Movie(id, name, description, genre, language, durationInSecs);
        this.movies.put(id, movie);
        return movie;
    }

    public Movie getMovie(String movieId) {
        return movies.get(movieId);
    }
}
