package com.myretail.controllers;

import com.myretail.exceptions.ResourceNotFoundException;
import com.myretail.models.Product;
import com.myretail.models.Response;
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

    @GetMapping("/{id}")
    public Product products(@PathVariable int id){

        Product product = productService.getProduct(id);
        if(product == null) {
            throw new ResourceNotFoundException();
        }

        return product;
    }

    // TODO: differentiate between 201 and 204
    @PutMapping("/{id}")
    public ResponseEntity<?> putProduct(@RequestBody Product product) {
        Product result = productService.saveProduct(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.id).toUri();

        return ResponseEntity.created(location).build();
    }

}
