package com.services;

import com.classes.Product;

import java.util.List;

/**
 * Created by jlutz on 11/20/2015.
 */
public interface ProductService {

    List<Product> GetAll();
    Product GetProduct(Integer id);
}
