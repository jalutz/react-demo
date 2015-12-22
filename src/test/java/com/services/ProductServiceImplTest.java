package com.services;

import com.StoreDemoIntellijApplication;
import com.classes.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by jlutz on 12/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StoreDemoIntellijApplication.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testGetProductShouldReturnProduct() throws Exception {
        Product product = productService.GetProduct(1);
        Assert.assertNotNull(product);
    }

    @Test
    public void testGetProductShouldReturnNull() throws Exception {
        Product product = productService.GetProduct(0);
        Assert.assertNull(product);
    }
}