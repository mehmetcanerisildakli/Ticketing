package com.ticketing.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public abstract class Event extends Entity {
    protected String name;
    protected String description;
    protected LocalDateTime date;
    protected int totalNumberOfSeats;
    protected Duration duration;
    protected Location location;
    private Price price;
    private List<Ticket> ticketsAvailable;
    private List<Ticket> ticketsSold;
    private double totalIncome;

    public Event(int id, String name, String description, LocalDateTime date, int totalNumberOfSeats, Duration duration, Location location, Price price) {

        super(id);
        this.name = name;
        this.description = description;
        this.date = date;
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.duration = duration;
        this.location = location;
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public void ticketSold(Ticket ticketSold) {
        ticketsSold.add(ticketSold);
        ticketsAvailable.remove(ticketSold);
    }

    public void ticketCancelled(Ticket ticketSold) {
        ticketsSold.remove(ticketSold);
        ticketsAvailable.add(ticketSold);
    }

    public int availableNumberOfSeats() {
        return ticketsAvailable.size();
    }

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void addTicket(Ticket ticket) {
        ticketsAvailable.add(ticket);
    }
    public double calculateIncome(){
        Iterator<Ticket> it = ticketsSold.iterator();
        double sum = 0;
        while(it.hasNext()){
            Ticket ticket = it.next();
            Cost cost = ticket.getCost();
            double amount = cost.getAmount();
            sum += amount;
        }
//        while(it.hasNext())
//            sum += it.next().getCost().getAmount();

        return sum;
    }

    public List<Ticket> getTicketsSold() {
        return ticketsSold;
    }

    public double calculateIncomeFunctional() {

        Iterator<Ticket> it = ticketsSold.iterator();

        Consumer<Ticket> consumer = (t) -> {
            Cost cost = t.getCost();
            double amount = cost.getAmount();
            totalIncome += amount;
        };
        it.forEachRemaining(consumer);
        return totalIncome;
    }
}
