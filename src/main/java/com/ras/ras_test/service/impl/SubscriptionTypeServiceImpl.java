package com.ras.ras_test.service.impl;

import com.ras.ras_test.dto.SubscriptionTypeDTO;
import com.ras.ras_test.exception.NotFoundException;
import com.ras.ras_test.model.SubscriptionType;
import com.ras.ras_test.repository.SubscriptionTypeRepository;
import com.ras.ras_test.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        SubscriptionType subscriptionType = SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMonths(dto.getAccessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();

        return repository.save(subscriptionType);
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDTO dto) {
        SubscriptionType subscriptionType = SubscriptionType.builder()
                .id(id)
                .name(dto.getName())
                .accessMonths(dto.getAccessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();

        return repository.save(subscriptionType);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
