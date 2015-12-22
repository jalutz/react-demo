package com.controllers;

import com.classes.Product;
import com.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jlutz on 11/20/2015.
 */

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getproducts")
    public List<Product> GetProducts()
    {
        return productService.GetAll();
    }

    @RequestMapping("/getProd")
    public Product getProduct(@RequestParam("id") Integer id)
    {
        return productService.GetProduct(id);
    }
}
