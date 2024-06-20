package com.ras.ras_test.service.impl;

import com.ras.ras_test.dto.ProductDto;
import com.ras.ras_test.mapper.ProductMapper;
import com.ras.ras_test.model.ProductModel;
import com.ras.ras_test.repository.ProductRepository;
import com.ras.ras_test.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel create(ProductDto dto) {
        ProductModel model = ProductMapper.fromDtoToModel(dto);
        model.setDtCreation(LocalDate.now());
        return productRepository.save(model);
    }

    @Override
    public List<ProductModel> readAll() {
        return productRepository.findAll();
    }
}
