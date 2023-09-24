package com.ticketing.model.factory;

import com.ticketing.model.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class EventFactoryForTY implements EventFactory {

    @Override
    public Event createCinemaEvent(String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price, boolean threeDim, String genre, String language) {
        Random random = new Random();
        Event event = new Cinema(random.nextInt(), name, description, date, totalNumberOfSeats,
                duration, location, price, threeDim, genre, language);
        createTickets(event);
        return event;
    }

    @Override
    public Event createConcertEvent(String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price, List<String> bands, List<String> performance) {
        Random random = new Random();
        Event event = new Concert(random.nextInt(), name, description, date, totalNumberOfSeats,
                duration, location, price, bands, performance);

        return event;
    }

    @Override
    public Location createLocation() {
        return null;
    }

    private void createTickets(Event event) {
        Random random = new Random();
        int numberOfSeats = event.getTotalNumberOfSeats();
        for (int i = 0; i < numberOfSeats; i++) {
            event.addTicket(new Ticket(random.nextInt(), event, " "));
        }
    }



}
