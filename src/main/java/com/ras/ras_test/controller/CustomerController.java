package com.ras.ras_test.controller;

import com.ras.ras_test.configuration.SwaggerConfig;
import com.ras.ras_test.dto.CustomerDto;
import com.ras.ras_test.model.CustomerModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(tags = SwaggerConfig.CUSTOMER)
public interface CustomerController {

    @ApiOperation(value = "Register a new customer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Customer created or updated successfully"),
            @ApiResponse(code = 400, message = "Error in the request sent by the client"),
            @ApiResponse(code = 500, message = "Internal error in the service"),
    })
    ResponseEntity<CustomerModel> createCustomer(CustomerDto customerDto);
}
