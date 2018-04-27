package com.myretail.models;

public class Price {

    private double value;
    private String currency_code;

    public Price(double value, String currency_code) {
        this.value = value;
        this.currency_code = currency_code;
    }

    public double getValue() {
        return value;
    }

    public String getCurrencyCode() {
        return currency_code;
    }
}
