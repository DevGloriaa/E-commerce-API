package com.example.ecommerceapi.service;

import com.example.ecommerceapi.model.Order;

import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);
    Optional<Order> getOrderById(String id);
    Optional<Order> getOrderByUserId(String userId);
    Optional<Order>  updateOrderStatus(String orderId, String status);
    void deleteOrder(String OrderId);

}
