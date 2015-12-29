package com.services;

import com.classes.CartDetail;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by jlutz on 12/2/2015.
 */
public interface CartDetailService {

    List<CartDetail> getCartItems(Integer cartId);
    CartDetail getCartItem(Integer cartid, Integer productId);
    void updateCartItem(CartDetail cartDetail);
    void addCartItem(CartDetail item);
    void removeCartItem(Integer cartDetailId);
}
