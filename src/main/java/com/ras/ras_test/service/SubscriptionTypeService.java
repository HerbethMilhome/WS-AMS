package com.ras.ras_test.service;

import com.ras.ras_test.model.SubscriptionType;

import java.util.List;
import java.util.Optional;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionType subscriptionType);

    SubscriptionType update(Long id, SubscriptionType subscriptionType);

    void delete(Long id);

}
