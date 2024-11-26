package com.example.tienda_emazon.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Builder
@Table(name = "supplied")
public class SuppliedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suppliedId;
    @Column(name = "supplied_name")
    private String suppliedName;
    @Column(name = "supplied_amount")
    private int suppliedAmount;
}
