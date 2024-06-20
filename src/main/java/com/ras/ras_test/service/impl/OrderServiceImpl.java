package com.ras.ras_test.service.impl;

import com.ras.ras_test.dto.OrderDto;
import com.ras.ras_test.dto.ProductDto;
import com.ras.ras_test.exception.BusinessException;
import com.ras.ras_test.exception.NotFoundException;
import com.ras.ras_test.mapper.OrderMapper;
import com.ras.ras_test.mapper.ProductMapper;
import com.ras.ras_test.model.CustomerModel;
import com.ras.ras_test.model.OrderModel;
import com.ras.ras_test.model.ProductModel;
import com.ras.ras_test.repository.CustomerRepository;
import com.ras.ras_test.repository.OrderRepository;
import com.ras.ras_test.repository.ProductRepository;
import com.ras.ras_test.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository,
                     ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderModel create(OrderDto orderDto) {
        Optional<CustomerModel> customerModelOpt = customerRepository.findById(orderDto.getCustomerId());

        if (customerModelOpt.isEmpty()) {
            throw new NotFoundException("Cliete não encontrado");
        }

        Optional<ProductModel> productModelOpt = productRepository.findByAcronym(orderDto.getProductAcronym().toUpperCase());
        if (productModelOpt.isEmpty()) {
            throw new NotFoundException("Sigla do produto inexistente");
        }
        ProductDto productDto = ProductMapper.fromModelToDto(productModelOpt.get());
        OrderModel orderModel = OrderMapper.fromDtoToModel(orderDto, productDto);
        if (orderDto.getDiscount().intValue() > 0) {
            if (orderDto.getDiscount().compareTo(productModelOpt.get().getCurrentPrice()) > 0) {
                throw new BusinessException("Desconto não pode ser maior que o valor original",HttpStatus.BAD_REQUEST);
            }
            orderModel.setOriginalPrice(productModelOpt.get().getCurrentPrice().subtract(orderDto.getDiscount()));
        }

        return orderRepository.save(orderModel);
    }
}
