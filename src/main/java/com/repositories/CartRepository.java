package com.repositories;

import com.classes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jlutz on 11/20/2015.
 */

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("SELECT c FROM Cart c WHERE c.customerId = :customerId")
    public Cart GetCartByCustomerId(@Param("customerId") Integer customerId);
}
