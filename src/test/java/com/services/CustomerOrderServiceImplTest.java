package com.services;

import com.StoreDemoIntellijApplication;
import com.classes.CustomerOrder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jlutz on 12/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StoreDemoIntellijApplication.class)
public class CustomerOrderServiceImplTest {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetCustomerOrdersShouldReturnSome() throws Exception {
        List<CustomerOrder> customerOrders = customerOrderService.getCustomerOrders(3);
        Assert.assertTrue(customerOrders.size() > 0);
    }

    @Test
    public void testGetCustomerOrdersShouldReturnNone() throws Exception {
        List<CustomerOrder> customerOrders = customerOrderService.getCustomerOrders(0);
        Assert.assertTrue(customerOrders.size() == 0);
    }

    @Test
    public void testAddCustomerOrderIdShouldBeOneOrGreater() throws Exception {
        Integer addedId = customerOrderService.addCustomerOrder(3);
        Assert.assertTrue(addedId > 0);
    }

    @Test
    public void testAddCustomerOrderIdShouldThrowException() throws Exception {
        exception.expect(DataIntegrityViolationException.class);
        Integer addedId = customerOrderService.addCustomerOrder(0);
    }
}