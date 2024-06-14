package com.ras.ras_test.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDTO {

    private Long id;

    @NotBlank(message = "Field cannot be is empty or null")
    @Size(min = 5, max = 50, message = "Field name between 5 and 15")
    private String name;

    @Max(value = 12, message = "Field cannot be greater than 12")
    private Long accessMonths;

    @NotNull(message = "Field cannot be is empty or null")
    private BigDecimal price;

    @NotBlank(message = "Field productKey cannot be is empty or null")
    @Size(min = 5, max = 15, message = "Field between 5 and 15")
    private String productKey;
}
