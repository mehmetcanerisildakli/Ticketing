package com.ticketing.model.app.repo;

import com.ticketing.model.Customer;
import com.ticketing.model.Event;
import com.ticketing.model.Ticket;
import com.ticketing.model.repo.EventRepository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EventInMemoryRepository implements EventRepository {

    private Map<Integer, Event> events;

    public EventInMemoryRepository() {
        events = new HashMap<>();
    }

    @Override
    public void save(Event event) {
        events.put(event.getId(), event);
    }

    @Override
    public Optional<Event> find(int eventId) {
        Event event = allEvents().get(eventId);
        Optional optional = Optional.ofNullable(event);
        return optional;
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

    @Override
    public int eventCountForCustomer(Customer customer) {
        Collection coll = events.values();
        Stream<Event> stream = coll.stream();
        Predicate<Event> predicate = e -> {
            List<Ticket> tickets = e.getTicketsSold();
            Stream<Ticket> ticketStream = tickets.stream();
            Predicate<Ticket> ticketPredicate = t -> {
                if (t.getCustomer().equals(customer)){
                    return true;
                } else
                    return false;
            };
            return ticketStream.anyMatch(ticketPredicate);
        };
        long count = stream.filter(predicate).count();
        Stream filteredStream = stream.filter(predicate);
        long count2 = filteredStream.count();
        return (int) count;
    }


}
