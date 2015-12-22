package com.classes;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jlutz on 11/20/2015.
 */

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_cartid_seq")
    @SequenceGenerator(name = "cart_cartid_seq", sequenceName = "cart_cartid_seq", allocationSize = 1)
    @Column(name = "cartid")
    private Integer cartId;

    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    public Integer getCartId() {
        return cartId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
