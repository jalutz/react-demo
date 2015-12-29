package com.controllers;

import com.classes.Cart;
import com.classes.CartDetail;
import com.classes.ViewModelCartDetail;
import com.services.CartDetailService;
import com.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<ViewModelCartDetail> GetCartItems(@RequestParam("customerId") Integer customerId)
    {
        Cart c = cartService.getCart(customerId);


        return  buildDetailsView(cartDetailService.getCartItems(c.getCartId()));
    }

    @RequestMapping(value = "/addcartitem", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity AddCartItem(@RequestBody CartDetail item, @RequestParam("customerId") Integer customerId)
    {
        ResponseEntity r = new ResponseEntity<String>(HttpStatus.CREATED);
        Cart cart = cartService.getCart(customerId);
        if(cart == null)
        {
            cart = cartService.addCart(customerId);
        }

        item.setCartId(cart.getCartId());
        cartDetailService.addCartItem(item);

        if(item == null){
            r = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return r;
    }

    @RequestMapping(value = "/updatecartitem", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity UpdateCartItem(@RequestBody CartDetail cartDetail){
        ResponseEntity response = new ResponseEntity(HttpStatus.ACCEPTED);

        try{
            cartDetailService.updateCartItem(cartDetail);
        }
        catch(Exception e){
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @RequestMapping(value = "/removecartitem", method = RequestMethod.DELETE)
    public void RemoveCartItem(Integer cartDetailId){
        cartDetailService.removeCartItem(cartDetailId);
    }

    private List<ViewModelCartDetail> buildDetailsView(List<CartDetail> cartDetails){
        List<ViewModelCartDetail> model = new ArrayList<>();
        for(CartDetail theCartDetail : cartDetails ){
            ViewModelCartDetail cartDetail = new ViewModelCartDetail();
            cartDetail.setCartDetailId(theCartDetail.getCartDetailId());
            cartDetail.setCartId(theCartDetail.getCartId());
            cartDetail.setProductId(theCartDetail.getProductId());
            cartDetail.setProductPrice(theCartDetail.getProductPrice());
            cartDetail.setQuantity(theCartDetail.getQuantity());
            cartDetail.setProductName(theCartDetail.getProduct().getProductName());
            model.add(cartDetail);
        }
        return model;
    }
}
