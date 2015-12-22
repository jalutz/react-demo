package com.services;

import com.classes.CustomerOrder;

import java.util.List;

/**
 * Created by jlutz on 12/3/2015.
 */
public interface CustomerOrderService{
    List<CustomerOrder> getCustomerOrders(Integer customerId);
    List<CustomerOrder> getAllOrders();
    Integer addCustomerOrder(Integer customerId);
}
