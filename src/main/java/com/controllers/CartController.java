package com.controllers;

import com.classes.Cart;
import com.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jlutz on 12/2/2015.
 */
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/getcart")
    public Cart getCart(@RequestParam("customerId") Integer customerId)
    {
        return cartService.getCart(customerId);
    }
}
