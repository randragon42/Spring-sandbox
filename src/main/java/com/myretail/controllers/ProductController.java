package com.myretail.controllers;

import com.myretail.models.Price;
import com.myretail.models.Product;
import com.myretail.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method=GET, value="/products/{id}")
    public Product products(@PathVariable int id){
        // TODO: verify parameter and send errors

        Product product = productService.getProduct(id);

        // TODO: check that product is valid
        return product;
    }

}
