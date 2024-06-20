package com.ras.ras_test.controller.impl;

import com.ras.ras_test.controller.CustomerController;
import com.ras.ras_test.dto.CustomerDto;
import com.ras.ras_test.model.CustomerModel;
import com.ras.ras_test.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/customer")
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @Autowired
    CustomerControllerImpl(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.create(customerDto));
    }
}
