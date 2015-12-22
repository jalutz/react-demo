package com.services;

import com.StoreDemoIntellijApplication;
import com.classes.Customer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jlutz on 12/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StoreDemoIntellijApplication.class)
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetCustomerByUsernameShouldReturnCustomer() throws Exception {
        Customer c = customerService.GetCustomerByUsername("jlutz");
        Assert.assertNotNull(c);
    }

    @Test
    public void testGetCustomerByUsernameShouldReturnNull() throws Exception {
        Customer c = customerService.GetCustomerByUsername("imanullcust404");
        Assert.assertNull(c);
    }

    @Test
    public void testGetCustomerByEmailShouldReturnCustomer() throws Exception {
        Customer c = customerService.GetCustomerByEmail("jlutz@masonite2.com");
        Assert.assertNotNull(c);
    }

    @Test
    public void testGetCustomerByEmailShouldReturnNull() throws Exception {
        Customer c = customerService.GetCustomerByEmail("imnull@nullfactory.com");
        Assert.assertNull(c);
    }

    @Test
    public void testAddCustomer() throws Exception {

    }

    @Test
    public void testLoadUserByUsernameReturnsUserDetails() throws Exception {
        UserDetails userDetails = customerService.loadUserByUsername("jlutz");
        Assert.assertNotNull(userDetails);
    }
}