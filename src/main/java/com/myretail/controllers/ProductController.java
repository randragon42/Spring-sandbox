package com.myretail.controllers;

import com.myretail.exceptions.ResourceNotFoundException;
import com.myretail.models.Product;
import com.myretail.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *
     * @param id the id of a product to retrieve product details on
     * @return product details if product exists
     */
    @GetMapping("/{id}")
    public Product products(@PathVariable String id){

        Product product = productService.getProduct(id);
        if(product == null) {
            throw new ResourceNotFoundException();
        }

        return product;
    }

    /**
     *
     * @param product the id of a product to update the price of
     * @return status code
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putProduct(@RequestBody Product product) {
        Product result = productService.saveProduct(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.id).toUri();

        return ResponseEntity.created(location).build();
    }

}
