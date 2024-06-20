package com.ras.ras_test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ras.ras_test.dto.ProductDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("orders")
@Builder
public class OrderModel implements Serializable {

    @Id
    private String id;

    @NotBlank(message = "Customer deve ser informado no pedido")
    private String customerId;

    private BigDecimal originalPrice;

    private BigDecimal discount;

    @JsonIgnore
    private LocalDateTime dtRegistedOrder;

    @JsonProperty("product")
    private ProductDto product;
}
