package com.ras.ras_test.controller.impl;

import com.ras.ras_test.controller.PaymentController;
import com.ras.ras_test.dto.PaymentDto;
import com.ras.ras_test.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
public class PaymentControllerImpl implements PaymentController {

    private final PaymentService paymentService;

    @Autowired
    PaymentControllerImpl(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/credit-card/")
    public ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.process(dto));
    }

}
