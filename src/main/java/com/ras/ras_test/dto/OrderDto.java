package com.ras.ras_test.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private String id;

    @NotBlank(message = "customerId is requered")
    private String customerId;

    @NotBlank(message = "productAcronym is requered")
    private String productAcronym;

    private BigDecimal discount;
}
