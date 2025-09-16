package com.example.ecommerceapi.service;

import com.example.ecommerceapi.enums.OrderStatus;
import com.example.ecommerceapi.model.Order;
import com.example.ecommerceapi.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(String userId, List<OrderItem> items);
    List<Order> getOrdersByUser(String userId);
    Order updateOrderStatus(String orderId, OrderStatus status);
}
