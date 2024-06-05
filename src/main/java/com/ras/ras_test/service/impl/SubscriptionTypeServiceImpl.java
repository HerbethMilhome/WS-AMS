package com.ras.ras_test.service.impl;

import com.ras.ras_test.exception.NotFoundException;
import com.ras.ras_test.model.SubscriptionType;
import com.ras.ras_test.repository.SubscriptionTypeRepository;
import com.ras.ras_test.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository repository;

    SubscriptionTypeServiceImpl(SubscriptionTypeRepository repository){
        this.repository = repository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return repository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = repository.findById(id);
        if (optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("Subscription not find!");
        }
        return optionalSubscriptionType.get();
    }

    @Override
    public SubscriptionType create(SubscriptionType subscriptionType) {
        return repository.save(subscriptionType);
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
        return repository.save(subscriptionType);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
