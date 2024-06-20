package com.ras.ras_test.service;

import com.ras.ras_test.dto.CustomerDto;
import com.ras.ras_test.model.CustomerModel;

public interface CustomerService {

    CustomerModel create(CustomerDto customerDto);
}
