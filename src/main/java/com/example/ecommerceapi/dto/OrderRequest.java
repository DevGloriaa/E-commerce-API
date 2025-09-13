package com.example.ecommerceapi.dto;

import com.example.ecommerceapi.model.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String userId;
    private List<OrderItem> items;
}