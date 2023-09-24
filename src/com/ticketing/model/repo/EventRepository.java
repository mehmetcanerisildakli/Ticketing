package com.ticketing.model.repo;

import com.ticketing.model.Customer;
import com.ticketing.model.Event;
import com.ticketing.model.Ticket;

import java.util.List;

public interface EventRepository {

    void save(Event event);
    Event find(int eventId);
    List<Event> allEvents();
    List<Ticket> allTicketsForEvent(Event event);
    List<Ticket> allTickets(Event event);
    List<Customer> allCustomersForEvent(int eventId);
    Customer owner(int ticketId);

}
