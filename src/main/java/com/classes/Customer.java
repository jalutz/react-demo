package com.classes;

import javax.persistence.*;

/**
 * Created by jlutz on 11/20/2015.
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_customerid_seq")
    @SequenceGenerator(name = "customer_customerid_seq", sequenceName = "customer_customerid_seq", allocationSize = 1)
    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "loginname")
    private String customerLogin;

    @Column(name = "customerpassword")
    private String customerPassword;

    @Column(name = "firstname")
    private String customerFirstName;

    @Column(name = "lastname")
    private String customerLastName;

    @Column(name = "email")
    private String customerEmail;

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
