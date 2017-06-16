package com.pay.model;


public class Product {

    private String name;
    private Long unitPrice;
    private Integer quantity;


    public Product(String name, Long unitPrice, Integer quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
