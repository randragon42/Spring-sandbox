package com.myretail.models;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class Product {

//    @Id
//    private BigInteger MongoId;

    @Id
    public String id;

    private Item item;
    public Price price;


    public Item getItem(){
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
