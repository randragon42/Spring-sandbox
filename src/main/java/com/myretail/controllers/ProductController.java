package com.myretail.controllers;

import com.myretail.exceptions.ResourceNotFoundException;
import com.myretail.models.Product;
import com.myretail.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product products(@PathVariable int id){

        Product product = productService.getProduct(id);
        if(product == null) {
            throw new ResourceNotFoundException();
        }

        return product;
    }

}
