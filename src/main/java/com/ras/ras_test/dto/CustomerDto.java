package com.ras.ras_test.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String id;

    @NotBlank(message = "firstName is requered")
    private String firstName;

    @NotBlank(message = "lastName is requered")
    private String lastName;

    @Email(message = "email needs to be valid")
    private String email;

    @NotBlank(message = "cpf must be filled")
    @CPF(message = "cpf needs to be valid")
    private String cpf;
}
