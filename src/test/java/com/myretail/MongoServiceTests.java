package com.myretail;

import com.mongodb.Mongo;
import com.myretail.data.ProductRepository;
import com.myretail.models.Price;
import com.myretail.models.Product;
import com.myretail.services.MongoService;
import com.myretail.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MongoService.class, secure = false)
public class MongoServiceTests {

    @Autowired
    MongoService mongoService;

    @MockBean
    ProductRepository productRepository;

    @Test
    public void getProductPriceTest_ProductRepositoryReturnsValidPrice() {
        Product product = new Product();
        product.id = 42;

        Price price = new Price(12.00, "USD");
        Product mongoStoredProduct = new Product();
        mongoStoredProduct.price = price;
        mongoStoredProduct.id = 42;
        Optional<Product> mongoReturnedProduct = Optional.of(mongoStoredProduct);

        Mockito.when(productRepository.findById(product.id)).thenReturn(mongoReturnedProduct);

        Price actualPrice = mongoService.getProductPrice(product);

        Assert.assertEquals(price, actualPrice);
    }

    @Test
    public void getProductPriceTest_ProductRepositoryDoesNotContainProduct() {
        Product product = new Product();
        product.id = 42;
        Optional<Product> mongoReturnedProduct = Optional.empty();

        Mockito.when(productRepository.findById(product.id)).thenReturn(mongoReturnedProduct);

        Price actualPrice = mongoService.getProductPrice(product);

        Assert.assertNotNull(actualPrice);
    }
}
