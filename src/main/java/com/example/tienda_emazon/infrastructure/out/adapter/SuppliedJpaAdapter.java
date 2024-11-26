package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.SuppliedModel;
import com.example.tienda_emazon.domain.spi.ISuppliedPersistencePort;
import com.example.tienda_emazon.infrastructure.out.entity.SuppliedEntity;
import com.example.tienda_emazon.infrastructure.out.mapper.SuppliedEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.JpaSuppliedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SuppliedJpaAdapter implements ISuppliedPersistencePort {

    private final JpaSuppliedRepository suppliedRepository;
    private final SuppliedEntityMapper suppliedEntityMapper;

    @Override
    public SuppliedModel saveSupplied(SuppliedModel suppliedModel) {
        SuppliedEntity suppliedEntity = suppliedEntityMapper.modelToEntity(suppliedModel);
        suppliedEntity = suppliedRepository.save(suppliedEntity);
        return suppliedEntityMapper.entityToModel(suppliedEntity);
    }

    @Override
    public Optional<SuppliedModel> obtainSuppliedByName(String suppliedName) {
        return suppliedRepository.findBySuppliedName(suppliedName);  //.map(suppliedEntityMapper::entityToModel);
    }
}
