package com.myretail.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private Item item;
    public Price price;
    public int id;

    public Item getItem(){
        return item;
    }
}
