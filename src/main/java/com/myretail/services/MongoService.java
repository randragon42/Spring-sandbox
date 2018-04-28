package com.myretail.services;

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

    private int getRandomPrice() {
        Random rand = new Random();
        return rand.nextInt(1000) + 1;
    }
}
