package com.repositories;

import com.classes.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jlutz on 12/2/2015.
 */
@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {

    @Query("SELECT c FROM CartDetail c WHERE c.cartId = :cartId")
    public List<CartDetail> GetCartItems(@Param("cartId") Integer cartId);

    @Query("SELECT c FROM CartDetail c WHERE c.cartId = :cartId AND c.productId = :productId")
    public CartDetail GetCartItem(@Param("cartId") Integer cartId, @Param("productId") Integer productId);
}
