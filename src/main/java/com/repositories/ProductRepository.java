package com.repositories;

import com.classes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jlutz on 11/20/2015.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
