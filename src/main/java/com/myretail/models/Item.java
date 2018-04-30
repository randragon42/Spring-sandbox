package com.myretail.models;

public class Item {

    private ProductDescription product_description;

    public Item(ProductDescription product_description) {
        this.product_description = product_description;
    }

    public ProductDescription getProduct_description() {
        return product_description;
    }

    public void setProduct_description(ProductDescription product_description) {
        this.product_description = product_description;
    }

}
