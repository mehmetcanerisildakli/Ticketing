package com.ticketing.model.exeptions;

public class TicketNotAvailable extends Exception{

    public TicketNotAvailable(String message) {
        super(message);
    }
}