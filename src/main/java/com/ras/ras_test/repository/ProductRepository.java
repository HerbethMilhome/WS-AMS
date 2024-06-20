package com.ras.ras_test.repository;

import com.ras.ras_test.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {

    Optional<ProductModel> findByAcronym(String acronym);

}
