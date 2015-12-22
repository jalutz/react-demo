package com.services;

import com.classes.CustomerOrder;
import com.repositories.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by jlutz on 12/3/2015.
 */
@Service("customerOrderService")
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public List<CustomerOrder> getCustomerOrders(Integer customerId) {
        return customerOrderRepository.getCustomerOrders(customerId);
    }

    @Override
    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    @Override
    public Integer addCustomerOrder(Integer customerId) {
        CustomerOrder co = new CustomerOrder();
        co.setCustomerId(customerId);
        Date date = new Date();
        co.setCreatedDate(date);
        return customerOrderRepository.saveAndFlush(co).getOrderId();
    }
}
