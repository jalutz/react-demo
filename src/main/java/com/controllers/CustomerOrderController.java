package com.controllers;

import com.classes.CartDetail;
import com.classes.CustomerOrder;
import com.classes.CustomerOrderDetail;
import com.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jlutz on 12/3/2015.
 */

@RestController
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private CustomerOrderDetailService customerOrderDetailService;

    @RequestMapping("/getcustomerorders")
    public List<CustomerOrder> GetCustomerOrders(@RequestParam("customerId") Integer customerId)
    {
        return customerOrderService.getCustomerOrders(customerId);
    }

    @RequestMapping("/getallorders")
    public List<CustomerOrder> GetCustomerOrders()
    {
        return customerOrderService.getAllOrders();
    }

    @RequestMapping("/submitorder")
    public Integer AddCustomerOrder(@RequestParam("customerId") Integer customerId)
    {
        Integer customerOrderId = customerOrderService.addCustomerOrder(customerId);

        Integer cartId = cartService.getCart(customerId).getCartId();

        List<CartDetail> cartItems = cartDetailService.getCartItems(cartId);

        for(CartDetail item : cartItems){
            CustomerOrderDetail orderDetailItem = new CustomerOrderDetail();
            orderDetailItem.setProductPrice(item.getProductPrice());
            orderDetailItem.setOrderId(customerOrderId);
            orderDetailItem.setQuantity(item.getQuantity());
            orderDetailItem.setProductId(item.getProductId());
            customerOrderDetailService.addCustomerOrderItem(orderDetailItem);

            cartDetailService.removeCartItem(item.getCartDetailId());
        }

        return customerOrderId;
    }
}
