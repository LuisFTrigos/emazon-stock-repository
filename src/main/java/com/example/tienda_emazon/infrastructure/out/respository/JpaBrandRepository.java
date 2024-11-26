package com.example.tienda_emazon.infrastructure.out.respository;

import com.example.tienda_emazon.infrastructure.out.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long> {

    boolean existsByBrandName(String name);
    Optional<BrandEntity> findByBrandName(String brandName);

}
