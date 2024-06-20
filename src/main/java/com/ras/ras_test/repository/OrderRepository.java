package com.ras.ras_test.repository;

import com.ras.ras_test.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderModel, String> {
}
