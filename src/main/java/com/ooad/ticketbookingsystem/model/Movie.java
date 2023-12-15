package com.ooad.ticketbookingsystem.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Movie {
    private String id;
    private String name;
    private String description;
    private String genre;
    private String language;
    private int durationInSecs;

    public Movie(String id, String name, String description, String genre, String language, int durationInSecs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.language = language;
        this.durationInSecs = durationInSecs;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public int getDurationInSecs() {
        return durationInSecs;
    }
}
