package com.ticketing.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Concert extends Event {
    protected List<String> bands;
    protected List<String> performer;

    public Concert(int id, String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price, List<String> bands, List<String> performer) {
        super(id, name, description, date, totalNumberOfSeats, duration, location, price);
        this.bands = bands;
        this.performer = performer;
    }

    public Concert(int id, String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price, List<String> bands) {
        super(id, name, description, date, totalNumberOfSeats, duration, location, price);
        this.bands = bands;
    }
}
