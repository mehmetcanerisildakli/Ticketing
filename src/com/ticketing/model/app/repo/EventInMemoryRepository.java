package com.ticketing.model.app.repo;

import com.ticketing.model.Customer;
import com.ticketing.model.Event;
import com.ticketing.model.Ticket;
import com.ticketing.model.repo.EventRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventInMemoryRepository implements EventRepository {

    private Map<Integer, Event> events;

    public  EventInMemoryRepository (){
        events = new HashMap<>();
    }

    @Override
    public void save(Event event) {
        events.put(event.getId(), event);
    }

    @Override
    public Event find(int eventId) {
        return null;
    }

    @Override
    public List<Event> allEvents() {
        return null;
    }

    @Override
    public List<Ticket> allTicketsForEvent(Event event) {
        return null;
    }

    @Override
    public List<Ticket> allTickets(Event event) {
        return null;
    }

    @Override
    public List<Customer> allCustomersForEvent(int eventId) {
        return null;
    }

    @Override
    public Customer owner(int ticketId) {
        return null;
    }
}
