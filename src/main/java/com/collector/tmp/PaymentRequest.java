package com.collector.tmp;

public class PaymentRequest {

    private int amount;
    private Currency currency;

    public PaymentRequest(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
