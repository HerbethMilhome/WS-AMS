package com.ras.ras_test.service;

import com.ras.ras_test.dto.OrderDto;
import com.ras.ras_test.model.OrderModel;

public interface OrderService {
    OrderModel create(OrderDto orderDto);
}
