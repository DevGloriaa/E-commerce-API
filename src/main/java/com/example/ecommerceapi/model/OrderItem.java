package com.example.ecommerceapi.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "order_items")
public class OrderItem {
    @Id
    private String id;

    private Integer quantity;
    private Double price;

}
