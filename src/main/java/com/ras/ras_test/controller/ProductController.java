package com.ras.ras_test.controller;

import com.ras.ras_test.configuration.SwaggerConfig;
import com.ras.ras_test.dto.ProductDto;
import com.ras.ras_test.model.ProductModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = SwaggerConfig.PRODUCT)
public interface ProductController {

    @ApiOperation(value = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful product"),
            @ApiResponse(code = 400, message = "Error creating product"),
            @ApiResponse(code = 500, message = "Internal error in the service"),
    })
    ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto);

    @ApiOperation(value = "List all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consultation success"),
            @ApiResponse(code = 500, message = "Internal error in the service"),
    })
    ResponseEntity<List<ProductModel>> readAll();
}
