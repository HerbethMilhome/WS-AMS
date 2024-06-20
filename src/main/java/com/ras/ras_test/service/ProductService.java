package com.ras.ras_test.service;

import com.ras.ras_test.dto.ProductDto;
import com.ras.ras_test.model.ProductModel;

import java.util.List;

public interface ProductService {

    ProductModel create(ProductDto dto);

    List<ProductModel> readAll();
}
