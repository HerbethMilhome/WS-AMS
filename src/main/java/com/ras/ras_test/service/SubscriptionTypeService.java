package com.ras.ras_test.service;

import com.ras.ras_test.dto.SubscriptionTypeDTO;
import com.ras.ras_test.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionTypeDTO dto);

    SubscriptionType update(Long id, SubscriptionTypeDTO dto);

    void delete(Long id);

}
