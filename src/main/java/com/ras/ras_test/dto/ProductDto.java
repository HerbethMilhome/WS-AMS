package com.ras.ras_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String id;

    @NotBlank(message = "acronym is requered")
    @Size(min = 6,max = 20)
    private String acronym;

    @NotBlank(message = "name is requered")
    private String name;

    @NotNull
    @JsonProperty("current_price")
    private BigDecimal currentPrice;

    @JsonProperty(value = "dt_creation")
    private LocalDate dtCreation;

}
