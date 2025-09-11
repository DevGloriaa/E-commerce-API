package com.example.ecommerceapi.repository;

import com.example.ecommerceapi.model.Order;
import com.example.ecommerceapi.model.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository <Order,String> {
    List<OrderItem> findByUserId(String userId);

}
