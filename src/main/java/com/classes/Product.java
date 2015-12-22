package com.classes;

import javax.persistence.*;

/**
 * Created by jlutz on 11/20/2015.
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_productid_seq")
    @SequenceGenerator(name = "product_productid_seq", sequenceName = "product_productid_seq", allocationSize = 1)
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productpath")
    private String productPath;

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductPath() {
        return productPath;
    }

    public void setProductPath(String productPath) {
        this.productPath = productPath;
    }
}
