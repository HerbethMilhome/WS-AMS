package com.ras.ras_test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Document("products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    @Size(min = 6,max = 20)
    private String acronym;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal currentPrice;

    @NotNull
    @JsonIgnore
    private LocalDate dtCreation = LocalDate.now();

}
