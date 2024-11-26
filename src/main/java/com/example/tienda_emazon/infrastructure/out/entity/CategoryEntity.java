package com.example.tienda_emazon.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String categoryDescription;
    @ManyToMany(mappedBy = "supplyCategories", fetch = FetchType.EAGER)
    private Set<SupplyEntity> supplies = new HashSet<>();
}
