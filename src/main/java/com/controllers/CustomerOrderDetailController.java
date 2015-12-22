package com.controllers;

import com.classes.CustomerOrderDetail;
import com.services.CustomerOrderDetailService;
import com.services.CustomerOrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jlutz on 12/3/2015.
 */

@RestController
public class CustomerOrderDetailController {

    @Autowired
    private CustomerOrderDetailService customerOrderDetailService;

    @RequestMapping("/getcustomerorderitems")
    public List<CustomerOrderDetail> GetCustomerOrderItems(@RequestParam("orderId") Integer orderId)
    {
        return customerOrderDetailService.getCustomerOrderItems(orderId);
    }

    @RequestMapping("/addcustomerorderitem")
    public void AddCustomerOrderItem(@RequestParam("item") CustomerOrderDetail item)
    {
        customerOrderDetailService.addCustomerOrderItem(item);
    }
}
