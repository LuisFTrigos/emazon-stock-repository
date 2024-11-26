package com.example.tienda_emazon.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Builder
@Table(name = "supplies")
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String supplyName;
    private String supplyDescription;
    private long supplyAmount;
    private long supplyPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId")
    private BrandEntity supplyBrand;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "supply_category",
            joinColumns = @JoinColumn(name = "supply_Id"),
            inverseJoinColumns = @JoinColumn(name = "category_Id"))
    private List<CategoryEntity> supplyCategories = new ArrayList<>();


}
