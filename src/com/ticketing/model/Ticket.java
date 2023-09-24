package com.ticketing.model;

import com.ticketing.model.exeptions.TicketNotAvailable;

public class Ticket extends Entity {
    private Cost cost;
    private Event event;
    private Customer customer;
    private String seat;
    private TicketState state = TicketState.AVAILABLE;

    public Ticket(int id, Event event, String seat) {
        super(id);
        this.event = event;
        this.seat = seat;
    }

    public Cost calculateCost() {
        Cost cost = new Cost(event.getPrice(), 0.18, 0);
        return cost;
    }

    public Cost calculateCostForCustomer(Customer customer, Currency currency) {
        Cost cost = new Cost(event.getPrice(), 0.18, customer.getDiscount());
        return cost;
    }

    public void sell(Customer customer, Currency currency) throws TicketNotAvailable {

        if (state == TicketState.AVAILABLE || state == TicketState.CANCELLED) {
            calculateCostForCustomer(customer, currency);
            state = TicketState.SOLD;
            event.ticketSold(this);
        } else {
            throw new TicketNotAvailable("All tickets are sold");
        }
    }

    public void cancel() {
        if (state == TicketState.SOLD || state == TicketState.RESERVED) {
            state = TicketState.CANCELLED;
            event.ticketCancelled(this);
        }
    }

    public Cost getCost() {
        return cost;
    }
}
