package com.repositories;

import com.classes.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jlutz on 12/2/2015.
 */
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query("SELECT co FROM CustomerOrder co WHERE co.customerId = :customerId")
    public List<CustomerOrder> getCustomerOrders(@Param("customerId") Integer customerId);
}
