package com.ras.ras_test.controller;

import com.ras.ras_test.configuration.SwaggerConfig;
import com.ras.ras_test.dto.OrderDto;
import com.ras.ras_test.model.OrderModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = SwaggerConfig.ORDER)
public interface OrderController {

    @ApiOperation(value = "Register a new order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Order created successfully"),
            @ApiResponse(code = 400, message = "Error in order request"),
            @ApiResponse(code = 500, message = "Internal error in the service"),
    })
    ResponseEntity<OrderModel> create(@Valid @RequestBody OrderDto orderDto);
}
