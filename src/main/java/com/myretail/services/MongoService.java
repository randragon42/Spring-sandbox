package com.myretail.services;

import com.myretail.data.ProductRepository;
import com.myretail.models.Price;
import com.myretail.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieve a product's price from Mongo Data Store
     * @param product product to retrieve pricing info of
     * @return Price object for this product
     */
    public Price getProductPrice(Product product){
        Optional<Product> dbProduct = productRepository.findById(product.id);
        Price price;
        // If Data Store already contains this product, return its price
        if(dbProduct.isPresent()){
            price = dbProduct.get().price;
        }
        // Generate price of product that does not exist in the data store and then add it into the data store for future use
        else {
            price = new Price(getRandomPrice(), "USD");
            product.price = price;
            productRepository.save(product);
        }

        return price;
    }

    /**
     * Save a product into the data store
     * @param product product to save
     * @return saved product
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     *
     * @return a double with 2 digits to emulate an item's price
     */
    private double getRandomPrice() {
        return (int) ((Math.random() * 900) + 100) / 100.0;
    }
}
