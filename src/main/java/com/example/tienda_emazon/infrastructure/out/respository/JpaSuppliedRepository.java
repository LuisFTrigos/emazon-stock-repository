package com.example.tienda_emazon.infrastructure.out.respository;

import com.example.tienda_emazon.domain.model.SuppliedModel;
import com.example.tienda_emazon.infrastructure.out.entity.SuppliedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaSuppliedRepository extends JpaRepository<SuppliedEntity, Long> {

    Optional<SuppliedModel> findBySuppliedName(String suppliedName);
}
