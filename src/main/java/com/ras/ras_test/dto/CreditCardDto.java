package com.ras.ras_test.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardDto {

    @NotBlank(message = "number is requered")
    @Size(min = 16,max = 16,message = "Card invalid")
    private String number;

    @Size(min = 3,max = 3,message = "cvv must contain 3 numbers")
    private Long cvv;

    @Min(value = 1,message = "month cannot be less than 1")
    @Max(value = 2,message = "month cannot be greater than 12")
    private Long month;

    @Size(min = 2,max = 2,message = "year must contain 2 numbers")
    private Long year;

    @CPF(message = "CPF nedds to be valid")
    private String documentNumber;

    private Long installments;

}
