package com.controllers;

import com.classes.Customer;
import com.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by jlutz on 11/20/2015.
 */

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/addcustomer")
    @ResponseBody
    public void AddCustomer(@RequestBody Customer customer)
    {
        customerService.AddCustomer(customer);
    }


    @RequestMapping("/findcustomerbyusername")
    public Customer FindCustomerByUsername(@RequestParam("customerLogin") String customerLogin){
        return customerService.GetCustomerByUsername(customerLogin);
    }

    @RequestMapping("/findcustomerbyemail")
    public Customer FindCustomerByEmail(@RequestParam("customerEmail") String customerEmail){
        return customerService.GetCustomerByEmail(customerEmail);
    }

    @RequestMapping("/customers")
    public List<Customer> GetAllCustomers()
    {
        return customerService.GetAllCustomers();
    }


}
