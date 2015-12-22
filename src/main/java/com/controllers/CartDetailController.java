package com.controllers;

import com.classes.Cart;
import com.classes.CartDetail;
import com.services.CartDetailService;
import com.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jlutz on 12/3/2015.
 */
@RestController
public class CartDetailController {
    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private CartService cartService;

    @RequestMapping("/getcartitems")
    public List<CartDetail> GetCartItems(@RequestParam("customerId") Integer customerId)
    {
        Cart c = cartService.getCart(customerId);

        return cartDetailService.getCartItems(c.getCartId());
    }

    @RequestMapping("/addcartitem")
    @ResponseBody
    public void AddCartItem(@RequestBody CartDetail item, @RequestParam("customerId") Integer customerId)
    {
        Cart cart = cartService.getCart(customerId);
        if(cart == null)
        {
            cart = cartService.addCart(customerId);
        }

        item.setCartId(cart.getCartId());
        cartDetailService.addCartItem(item);
    }

    @RequestMapping("/removecartitem")
    public void RemoveCartItem(Integer cartDetailId){
        cartDetailService.removeCartItem(cartDetailId);
    }
}
