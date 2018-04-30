package com.myretail.services;

import com.myretail.models.Product;
import com.myretail.models.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RedSkyService {

    private String endpoint = "https://redsky.target.com/v2/pdp/tcin/";
    private String excludes = "?excludes=taxonomy," +
                                    "price," +
                                    "promotion," +
                                    "bulk_ship," +
                                    "rating_and_review_reviews," +
                                    "rating_and_review_statistics," +
                                    "question_answer_statistics," +
                                    "deep_red_labels," +
                                    "available_to_promise_network,";

    /**
     *
     * @param id the ID of a product to lookup
     * @return A Product if one with id is found, else null
     */
    public Product getProduct(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = endpoint + id + excludes;

        Product product = null;
        try {
            ResponseEntity<Response> response = restTemplate.getForEntity(resourceUrl, Response.class);
            product = response.getBody().product;
            product.id = id;
        } catch (HttpClientErrorException e) {
            // TODO: what is the correct behavior if a product is not found?
            Logger log = LoggerFactory.getLogger(this.getClass());
            log.error(e.toString());
        }

        return product;
    }
}
