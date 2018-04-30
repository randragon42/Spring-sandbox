package com.myretail;

import com.myretail.controllers.ProductController;
import com.myretail.data.ProductRepository;
import com.myretail.exceptions.ResourceNotFoundException;
import com.myretail.models.Price;
import com.myretail.models.Product;
import com.myretail.services.MongoService;
import com.myretail.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;


    @Test
    public void getProductsTest_ProductServiceReturnsValidProduct() throws Exception {
        Product product = new Product();
        product.price = new Price(42, "USD");
        product.id = 42;

        Mockito.when(productService.getProduct(product.id)).thenReturn(product);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/42");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":42,\"item\":null,\"price\":{\"value\":42,\"currencyCode\":\"USD\"}}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getProductsTest_ProductServiceReturnsNull() throws Exception {
        Mockito.when(productService.getProduct(Mockito.anyInt())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/42");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals(result.getResponse().getStatus(), 404);
    }

}
