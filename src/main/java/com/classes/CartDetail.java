package com.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jlutz on 12/2/2015.
 */
@Entity
@Table(name = "cartdetail")
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartdetail_cartdetailid_seq")
    @SequenceGenerator(name = "cartdetail_cartdetailid_seq", sequenceName = "cartdetail_cartdetailid_seq", allocationSize = 1)
    @Column(name = "cartdetailid")
    private Integer cartDetailId;

    @Column(name = "cartid")
    private Integer cartId;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productprice")
    private BigDecimal productPrice;

    @OneToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    private Product product;


    public Integer getCartDetailId() {
        return cartDetailId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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


    public Product getProduct() {
        return product;
    }

}
