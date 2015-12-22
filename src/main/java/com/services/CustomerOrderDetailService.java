package com.services;

import com.classes.CustomerOrderDetail;

import java.util.List;

/**
 * Created by jlutz on 12/3/2015.
 */
public interface CustomerOrderDetailService {
    List<CustomerOrderDetail> getCustomerOrderItems(Integer orderId);
    void addCustomerOrderItem(CustomerOrderDetail item);
}
