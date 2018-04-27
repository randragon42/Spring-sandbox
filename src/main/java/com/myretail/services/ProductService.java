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
    private ProductRepository productRepository;

    public Product getProduct(int id) {
        RestTemplate restTemplate = new RestTemplate();
        // TODO: move into fancy string concatenation
        String excludes = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels,available_to_promise_network";
        String resourceUrl = "https://redsky.target.com/v2/pdp/tcin/" + id + excludes;

        ResponseEntity<Response> response = restTemplate.getForEntity(resourceUrl, Response.class);

        Product product = response.getBody().product;
        product.id = id;
        // TODO: handle situation where product is not found

        // Get Product price from NoSQL data store
        //product.price = getPriceFromDataStore(id);
        Optional<Product> dbProduct = productRepository.findById(id);
        if(dbProduct.isPresent()){
            product.price = dbProduct.get().price;
        }
        else {
            product.price = new Price(5000, "USD");
        }

        return product;
    }




    public void setProductPrice(int id, double price) {

    }
}
