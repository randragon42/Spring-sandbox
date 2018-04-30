package com.myretail.services;

import com.mongodb.WriteResult;
import com.myretail.data.ProductRepository;
import com.myretail.models.Price;
import com.myretail.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class MongoService {

    @Autowired
    private ProductRepository productRepository;

    public Price getProductPrice(Product product){
        Optional<Product> dbProduct = productRepository.findById(product.id);
        Price price;
        if(dbProduct.isPresent()){
            price = dbProduct.get().price;
        }
        else {
            price = new Price(getRandomPrice(), "USD");
            product.price = price;
            productRepository.save(product);
        }

        return price;
    }

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
