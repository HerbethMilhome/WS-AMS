package com.ras.ras_test.repository;

import com.ras.ras_test.model.CreditCardModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CreditCardRepository extends MongoRepository<CreditCardModel, String> {

    List<CreditCardModel> findByNumber(String number);
}
