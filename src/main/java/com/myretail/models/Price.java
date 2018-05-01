package com.myretail.models;

public class Price {

    private double value;
    private String currency_code;

    public Price(){}

    public Price(double value, String currency_code) {
        this.value = value;
        this.currency_code = currency_code;
    }

    public double getValue() {
        return value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }
}
