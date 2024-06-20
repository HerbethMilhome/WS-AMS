package com.ras.ras_test.service.impl;

import com.ras.ras_test.dto.CustomerDto;
import com.ras.ras_test.mapper.CustomerMapper;
import com.ras.ras_test.model.CustomerModel;
import com.ras.ras_test.repository.CustomerRepository;
import com.ras.ras_test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerModel create(CustomerDto customerDto) {
        return customerRepository.findByEmail(customerDto.getEmail())
                .map(customerByEmail -> customerRepository.save(CustomerMapper.fromModelToModel(customerByEmail, customerDto)))
                .orElseGet(() -> customerRepository.save(CustomerMapper.fromDtoToModel(customerDto)));
    }
}
