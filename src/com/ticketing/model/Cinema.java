package com.ticketing.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cinema extends Event {
    protected boolean threeDim;
    protected String genre;
    protected String language;

    public Cinema(int id, String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price, boolean threeDim, String genre, String language) {
        super(id, name, description, date, totalNumberOfSeats, duration, location, price);
        this.threeDim = threeDim;
        this.genre = genre;
        this.language = language;
    }
}
