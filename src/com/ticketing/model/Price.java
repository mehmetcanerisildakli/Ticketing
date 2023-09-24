package com.ticketing.model;

public class Price {
    private final double amount;
    private final Currency currency;

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Price(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
