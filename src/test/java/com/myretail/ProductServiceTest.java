package com.myretail;

import com.myretail.services.MongoService;
import com.myretail.services.ProductService;
import com.myretail.services.RedSkyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductService.class, secure = false)
public class ProductServiceTest {

    @MockBean
    private MongoService mongoService;

    @Mock
    private RedSkyService redSkyService;

    @Test
    public void getProductTest_RedSkyServiceReturnsValidProduct(){

    }

}
