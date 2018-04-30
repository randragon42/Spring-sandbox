package com.myretail;

import com.myretail.models.Product;
import com.myretail.services.RedSkyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RedSkyService.class, secure = false)
public class RedSkyServiceTests {

    @Autowired
    RedSkyService redSkyService;

    /**
     * When Red Sky returns a valid product, it should be parsed into a Product object
     */
    @Test
    public void getProduct_RedSkyReturnsValidProduct() {
        int id = 13860428;

        Product product = redSkyService.getProduct(id);

        Assert.assertNotNull(product);
    }

    /**
     * When Red Sky does not returns a 404, the product returned should be null to
     * signify to the controller that the product does not exist
     */
    @Test
    public void getProduct_RedSkyReturns404() {
        int id = 15117729;

        Product product = redSkyService.getProduct(id);

        Assert.assertNull(product);
    }

}
