package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.dto.OrderRequest;
import com.example.ecommerceapi.dto.UpdateOrderStatusRequest;
import com.example.ecommerceapi.enums.OrderStatus;
import com.example.ecommerceapi.model.Order;
import com.example.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request.getUserId(), request.getItems());
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable String userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PutMapping("/{orderId}/status")
    public Order updateOrderStatus(@PathVariable String orderId,
                                   @RequestBody UpdateOrderStatusRequest request) {
        return orderService.updateOrderStatus(orderId, request.getStatus());
    }
}
