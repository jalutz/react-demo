package com.repositories;

import com.classes.CustomerOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jlutz on 12/2/2015.
 */
@Repository
public interface CustomerOrderDetailRepository extends JpaRepository<CustomerOrderDetail, Integer> {
    @Query("SELECT cod FROM CustomerOrderDetail cod WHERE cod.orderId = :orderId")
    public List<CustomerOrderDetail> getCustomerOrderItems(@Param("orderId") Integer orderId);
}
