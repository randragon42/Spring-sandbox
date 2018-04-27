package com.myretail.services;

import com.myretail.models.Price;
import com.myretail.models.Product;
import com.myretail.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {


    public Product getProduct(int id) {
        RestTemplate restTemplate = new RestTemplate();
        // TODO: move into fancy string concatenation
        String excludes = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels,available_to_promise_network";
        String resourceUrl = "https://redsky.target.com/v2/pdp/tcin/" + id + excludes;

        ResponseEntity<Response> response = restTemplate.getForEntity(resourceUrl, Response.class);

        Product product = response.getBody().product;
        product.id = id;

        // Get Product price from NoSQL data store

        return product;
    }




    public void setProductPrice(int id, double price) {

    }
}
