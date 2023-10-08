package com.ticketing.model.repo;

import com.ticketing.model.Customer;
import com.ticketing.model.Event;
import com.ticketing.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface EventRepository {

    void save(Event event);
    Optional<Event> find(int eventId);
    List<Event> allEvents();
    List<Ticket> allTicketsForEvent(Event event);
    List<Ticket> allTickets(Event event);
    List<Customer> allCustomersForEvent(int eventId);
    Customer owner(int ticketId);
    int eventCountForCustomer(Customer customer);

}
