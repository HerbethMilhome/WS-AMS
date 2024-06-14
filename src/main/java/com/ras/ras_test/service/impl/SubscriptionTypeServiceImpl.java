package com.ras.ras_test.service.impl;

import com.ras.ras_test.dto.SubscriptionTypeDTO;
import com.ras.ras_test.exception.BadRequestException;
import com.ras.ras_test.exception.NotFoundException;
import com.ras.ras_test.mapper.SubscriptionTypeMapper;
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
        SubscriptionType optionalSubscriptionType = this.getSubscriptionType(id);
        return optionalSubscriptionType;
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID to be null");
        }

        return repository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDTO dto) {
        this.getSubscriptionType(id);
        return repository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        this.getSubscriptionType(id);
        repository.deleteById(id);
    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = repository.findById(id);
        if (optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("Subscription not find!");
        }
        return optionalSubscriptionType.get();
    }
}
