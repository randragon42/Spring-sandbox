package com.myretail.models;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    public int id;

    private Item item;
    public Price price;


    public Item getItem(){
        return item;
    }
}
