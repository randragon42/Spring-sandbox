package com.myretail.services;

import com.myretail.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private MongoService mongoService;

    @Autowired
    private RedSkyService redSkyService;

    public Product getProduct(int id) {
        Product product = redSkyService.getProduct(id);
        if(product == null) {
            return null;
        }

        // Get Product price from NoSQL data store
        product.price = mongoService.getProductPrice(product);

        return product;
    }

    public Product saveProduct(Product product) {
        return mongoService.saveProduct(product);
    }
}
