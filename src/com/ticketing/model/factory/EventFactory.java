package com.ticketing.model.factory;

import com.ticketing.model.Event;
import com.ticketing.model.Location;
import com.ticketing.model.Price;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public interface EventFactory {
    Event createCinemaEvent(String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price, boolean threeDim, String genre, String language);

    Event createConcertEvent(String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price, List<String> bands, List<String> performance);
    Location createLocation();
}