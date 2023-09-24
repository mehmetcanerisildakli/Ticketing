package com.ticketing.model;

public class Customer {
    private String tckn;
    private Status status;

    public double getDiscount() {
        return status.getDiscount();
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
    }

    public Customer(String tckn, Status status) {
        this.tckn = tckn;
        this.status = status;
    }
}
