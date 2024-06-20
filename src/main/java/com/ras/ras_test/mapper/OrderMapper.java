package com.ras.ras_test.mapper;

import com.ras.ras_test.dto.OrderDto;
import com.ras.ras_test.dto.ProductDto;
import com.ras.ras_test.model.OrderModel;

import java.time.LocalDateTime;

public class OrderMapper {

    private OrderMapper(){}

    public static OrderModel fromDtoToModel(OrderDto orderDto, ProductDto productDto) {
        return OrderModel.builder()
                .id(orderDto.getId())
                .customerId(orderDto.getCustomerId())
                .originalPrice(productDto.getCurrentPrice())
                .discount(orderDto.getDiscount())
                .dtRegistedOrder(LocalDateTime.now())
                .product(productDto)
                .build();
    }
}
