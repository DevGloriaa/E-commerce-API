package com.example.ecommerceapi.dto;

import com.example.ecommerceapi.enums.OrderStatus;
import lombok.Data;

@Data
public class UpdateOrderStatusRequest {
    private OrderStatus status;
}
