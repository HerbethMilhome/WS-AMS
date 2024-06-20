package com.ras.ras_test.controller.impl;

import com.ras.ras_test.controller.OrderController;
import com.ras.ras_test.dto.OrderDto;
import com.ras.ras_test.model.OrderModel;
import com.ras.ras_test.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    @Autowired
    OrderControllerImpl(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderModel> create(@Valid @RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(orderDto));
    }
}
