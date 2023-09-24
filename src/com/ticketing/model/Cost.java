package com.ticketing.model;

public class Cost {
    private double ticketCost;
    private double tax;
    private Currency currency;
    private double discount;

    public Cost(Price price, double tax, double discount) {
        this.ticketCost = price.getAmount();
        this.tax = tax;
        this.currency = price.getCurrency();
        this.discount = discount;
    }

    public double getAmount(){
        return ticketCost - discount;
    }

}
