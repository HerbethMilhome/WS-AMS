package com.ras.ras_test.repository;

import com.ras.ras_test.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerModel, String> {

    Optional<CustomerModel> findByEmail(String email);

    Optional<CustomerModel> findByCpf(String cpf);
}
