package com.example.tienda_emazon.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brandName;
    private String brandDescription;
    @OneToMany(mappedBy = "supplyBrand", fetch = FetchType.EAGER)
    private Set<SupplyEntity> supplies = new HashSet<>();


}
