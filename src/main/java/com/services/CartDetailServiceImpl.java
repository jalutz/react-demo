package com.services;

import com.classes.CartDetail;
import com.repositories.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jlutz on 12/2/2015.
 */
@Service("cartDetailService")
public class CartDetailServiceImpl implements CartDetailService {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public List<CartDetail> getCartItems(Integer cartId) {
        return cartDetailRepository.GetCartItems(cartId);
    }

    @Override
    public CartDetail getCartItem(Integer cartid, Integer productId) {
        return cartDetailRepository.GetCartItem(cartid, productId);
    }

    @Override
    public void updateCartItem(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public void addCartItem(CartDetail item) {

        CartDetail existingItem = getCartItem(item.getCartId(), item.getProductId());
        if(existingItem != null)
        {
            BigDecimal newPrice =  existingItem.getProductPrice().add(item.getProductPrice());
            Integer newQty = existingItem.getQuantity() + item.getQuantity();

            existingItem.setQuantity(newQty);
            existingItem.setProductPrice(newPrice);
            cartDetailRepository.saveAndFlush(existingItem);
        }
        else
        {
            cartDetailRepository.saveAndFlush(item);
        }
    }

    @Override
    public void removeCartItem(Integer cartDetailId) {
        cartDetailRepository.delete(cartDetailId);
    }
}
