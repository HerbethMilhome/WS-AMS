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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    private Long id;

    private String name;

    private String description;


}
