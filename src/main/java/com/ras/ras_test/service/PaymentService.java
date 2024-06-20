package com.ras.ras_test.service;

import com.ras.ras_test.dto.PaymentDto;

public interface PaymentService {
    Boolean process(PaymentDto paymentDto);
}
