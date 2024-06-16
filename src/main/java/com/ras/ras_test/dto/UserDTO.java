package com.ras.ras_test.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    @NotBlank(message = "Field cannot null or empty")
    @Size(min = 5, max = 50, message = "Field name between 5 and 15")
    private String name;

    @Email(message = "Invalid")
    private String email;

    @Size(min = 11, message = "Minimum field value 11")
    private String phone;

    @CPF(message = "Invalid")
    private String cpf;

    private LocalDate dtSubscription = LocalDate.now();

    private LocalDate dtExpiration = LocalDate.now();

    @NotNull
    private Long idUserType;

    private Long idSubscriptionsType;

}
