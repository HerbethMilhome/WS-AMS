package com.ras.ras_test.controller;

import com.ras.ras_test.configuration.SwaggerConfig;
import com.ras.ras_test.dto.PaymentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = SwaggerConfig.PAYMENT)
public interface PaymentController {

    @ApiOperation(value = "Process payment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Payment made successfully"),
            @ApiResponse(code = 400, message = "Error processing payment"),
            @ApiResponse(code = 401, message = "Unauthorized payment"),
            @ApiResponse(code = 500, message = "Internal error in the service"),
    })
    ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto);
}
