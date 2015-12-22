package com.services;

import com.StoreDemoIntellijApplication;
import com.classes.CustomerOrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jlutz on 12/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StoreDemoIntellijApplication.class)
public class CustomerOrderDetailServiceImplTest {

    @Autowired
    private CustomerOrderDetailService customerOrderDetailService;


    @Test
    public void testGetCustomerOrderItemsReturnsSome() throws Exception {
        List<CustomerOrderDetail> customerOrderDetails = customerOrderDetailService.getCustomerOrderItems(1);
        Assert.assertTrue(customerOrderDetails.size() > 0);
    }

    @Test
    public void testGetCustomerOrderItemsReturnsNone() throws Exception {
        List<CustomerOrderDetail> customerOrderDetails = customerOrderDetailService.getCustomerOrderItems(0);
        Assert.assertTrue(customerOrderDetails.size() == 0);
    }

    @Test
    public void testAddCustomerOrderItem() throws Exception {

    }
}