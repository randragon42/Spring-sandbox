package com.myretail.models;

public class ProductDescription {

    private String title;

    public ProductDescription(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
