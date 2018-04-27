package com.myretail;

import com.myretail.data.ProductRepository;
import com.myretail.models.Price;
import com.myretail.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyRetailRestfulServiceApplication {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyRetailRestfulServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner preLoadMongo() throws Exception {
        return args -> {
            Product product = new Product();
            product.id = 16696652;
            product.price = new Price(250, "USD");
            productRepository.save(product);
        };
    }
}
