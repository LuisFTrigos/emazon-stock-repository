package com.example.tienda_emazon.infrastructure.out.respository;

import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaSupplyRepository extends JpaRepository<SupplyEntity, Long> {

    boolean existsBySupplyName(String name);
    Optional<SupplyEntity> findBySupplyName(String supplyName);
}
