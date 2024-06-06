package com.ras.ras_test.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriptions_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    private Long id;

    @NonNull
    private String name;

    @Column(name = "access_months")
    private Long accessMonths;

    @NonNull
    private BigDecimal price;

    @Column(name = "product_key", unique = true)
    private String productKey;


}
