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

    /**
     * Call the Red Sky service to get product information
     * @param id the id of product to query for
     * @return a product if it exists in Red Sky, else null
     */
    public Product getProduct(String id) {
        Product product = redSkyService.getProduct(id);
        if(product == null) {
            return null;
        }

        // Get Product price from Mongo data store
        product.price = mongoService.getProductPrice(product);

        return product;
    }

    public Product saveProduct(Product product) {
        return mongoService.saveProduct(product);
    }
}
