package com.services;

import com.classes.Product;
import com.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jlutz on 11/20/2015.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> GetAll()
    {
        return productRepository.findAll();
    }

    public Product GetProduct(Integer id)
    {
        return productRepository.findOne(id);
    }
}
