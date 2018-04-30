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

    public static void main(String[] args) {
        SpringApplication.run(MyRetailRestfulServiceApplication.class, args);
    }

}
