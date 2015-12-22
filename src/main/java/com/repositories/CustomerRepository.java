package com.repositories;

import com.classes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by jlutz on 11/20/2015.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    @Query("SELECT c FROM Customer c WHERE LOWER(c.customerLogin) = LOWER(:customerLogin) AND LOWER(c.customerPassword) = LOWER(:customerPassword)")
    public Customer GetCustomerByNameAndCode(@Param("customerLogin") String customerLogin, @Param("customerPassword") String customerPassword);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.customerLogin) = LOWER(:customerLogin)")
    public Customer FindCustomerByUsername(@Param("customerLogin") String customerLogin);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.customerEmail) = LOWER(:customerEmail)")
    public Customer FindCustomerByEmail(@Param("customerEmail") String customerEmail);
}
