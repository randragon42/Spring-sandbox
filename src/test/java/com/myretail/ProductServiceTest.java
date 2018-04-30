package com.myretail;

import com.myretail.models.Item;
import com.myretail.models.Price;
import com.myretail.models.Product;
import com.myretail.models.ProductDescription;
import com.myretail.services.MongoService;
import com.myretail.services.ProductService;
import com.myretail.services.RedSkyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductService.class, secure = false)
public class ProductServiceTest {

    @MockBean
    private MongoService mongoService;

    @MockBean
    private RedSkyService redSkyService;

    @Autowired
    private ProductService productService;

    /**
     * getProduct() should return the correct product when RedSky and Mongo
     * return valid product and price
     */
    @Test
    public void getProductTest_RedSkyServiceAndMongoServiceReturnValidProduct() {
        Product product = new Product();
        product.id = "42";
        //product.setItem(new Item(new ProductDescription("Towel")));
        Price price = new Price(42, "USD");

        Mockito.when(redSkyService.getProduct(product.id)).thenReturn(product);
        Mockito.when(mongoService.getProductPrice(product)).thenReturn(price);

        Product actualProduct = productService.getProduct(product.id);

        Assert.assertEquals(product, actualProduct);
    }

    /**
     * getProduct() should return null when RedSky is unable to find the product
     * based on the ID passed in
     */
    @Test
    public void getProductTest_RedSkyServiceReturnsNullProduct() {
        Product product = null;

        Mockito.when(redSkyService.getProduct(Mockito.anyString())).thenReturn(product);

        Product actualProduct = productService.getProduct("42");

        Assert.assertEquals(product, actualProduct);
    }

}
