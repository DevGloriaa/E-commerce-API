package com.example.ecommerceapi.repository;

import com.example.ecommerceapi.model.Confirmation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConfirmationRepository extends MongoRepository<Confirmation, String> {
    Optional<Confirmation> findById(String confirmation);
}
