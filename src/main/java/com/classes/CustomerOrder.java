package com.classes;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jlutz on 12/2/2015.
 */

@Entity
@Table(name = "customerorder")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerorder_orderid_seq")
    @SequenceGenerator(name = "customerorder_orderid_seq", sequenceName = "customerorder_orderid_seq", allocationSize = 1)
    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "createddate")
    private Date createdDate;

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
