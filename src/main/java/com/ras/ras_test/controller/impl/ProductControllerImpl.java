package com.ras.ras_test.controller.impl;

import com.ras.ras_test.controller.ProductController;
import com.ras.ras_test.dto.ProductDto;
import com.ras.ras_test.model.ProductModel;
import com.ras.ras_test.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(dto));
    }

    @GetMapping()
    public ResponseEntity<List<ProductModel>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.readAll());
    }

}
