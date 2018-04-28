package com.myretail.services;

import com.myretail.data.ProductRepository;
import com.myretail.models.Price;
import com.myretail.models.Product;
import com.myretail.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private MongoService mongoService;

    @Autowired
    private RedSkyService redSkyService;

    public Product getProduct(int id) {
        Product product = redSkyService.getProduct(id);
        // TODO: handle situation where product is not found
        // Get Product price from NoSQL data store
        product.price = mongoService.getProductPrice(product);

        return product;
    }

    public void setProductPrice(int id, double price) {

    }
}
