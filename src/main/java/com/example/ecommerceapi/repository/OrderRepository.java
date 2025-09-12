package com.example.ecommerceapi.repository;

import com.example.ecommerceapi.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
    Optional<Order> findByUserId(String userId);
}
