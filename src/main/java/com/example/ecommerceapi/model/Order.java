package com.example.ecommerceapi.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection="orders")
public class Order {
    @Id
    private String id;

    private String userId;
    private List<OrderItem> items;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderDate;
}
