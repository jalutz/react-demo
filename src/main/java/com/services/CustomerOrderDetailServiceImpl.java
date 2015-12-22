package com.services;

import com.classes.CustomerOrder;
import com.classes.CustomerOrderDetail;
import com.repositories.CustomerOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jlutz on 12/3/2015.
 */
@Service("customerOrderDetailService")
public class CustomerOrderDetailServiceImpl implements CustomerOrderDetailService {
    @Autowired
    private CustomerOrderDetailRepository customerOrderDetailRepository;

    @Override
    public List<CustomerOrderDetail> getCustomerOrderItems(Integer orderId) {
        return customerOrderDetailRepository.getCustomerOrderItems(orderId);
    }

    @Override
    public void addCustomerOrderItem(CustomerOrderDetail item) {
        customerOrderDetailRepository.saveAndFlush(item);
    }
}
