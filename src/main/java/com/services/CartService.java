package com.services;

import com.classes.Cart;

/**
 * Created by jlutz on 12/2/2015.
 */
public interface CartService {

    Cart getCart(Integer customerId);

    Cart addCart(Integer customerId);
}
