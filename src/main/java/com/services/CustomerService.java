package com.services;

import com.classes.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by jlutz on 11/20/2015.
 */
public interface CustomerService extends UserDetailsService {
    Customer GetCustomerByUsername(String username);
    Customer GetCustomerByEmail(String email);
    void AddCustomer(Customer customer);
    List<Customer> GetAllCustomers();
}
