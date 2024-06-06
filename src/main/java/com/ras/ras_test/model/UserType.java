package com.ras.ras_test.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;


}
