package com.services;

import com.classes.Cart;
import com.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jlutz on 12/2/2015.
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCart(Integer customerId) {
        return cartRepository.GetCartByCustomerId(customerId);
    }

    @Override
    public Cart addCart(Integer customerId) {
        Cart c = new Cart();
        c.setCreatedDate(new Date());
        c.setCustomerId(customerId);
        return cartRepository.saveAndFlush(c);
    }
}
