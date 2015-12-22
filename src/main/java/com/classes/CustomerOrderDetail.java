package com.classes;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jlutz on 12/2/2015.
 */
@Entity
@Table(name = "customerorderdetail")
public class CustomerOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerorderdetail_orderdetailid_seq")
    @SequenceGenerator(name = "customerorderdetail_orderdetailid_seq", sequenceName = "customerorderdetail_orderdetailid_seq", allocationSize = 1)
    @Column(name = "orderdetailid")
    private Integer orderDetailId;

    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productprice" )
    private BigDecimal productPrice;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
