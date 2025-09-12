package com.example.ecommerceapi.model;

import lombok.Data;

@Data
public class OrderItem {
    private String productId;
    private int quantity;
    private double price;
    private double subtotal;

    public OrderItem(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = price * quantity;
    }
}
