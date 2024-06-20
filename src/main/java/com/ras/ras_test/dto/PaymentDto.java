package com.ras.ras_test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    @NotBlank(message = "customerId is requered")
    private String customerId;

    @NotBlank(message = "orderId is requered")
    private String orderId;

    @NotNull(message = "creditCard is requered")
    private CreditCardDto creditCard;
}
