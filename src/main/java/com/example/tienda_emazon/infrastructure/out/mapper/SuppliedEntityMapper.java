package com.example.tienda_emazon.infrastructure.out.mapper;

import com.example.tienda_emazon.domain.model.SuppliedModel;
import com.example.tienda_emazon.infrastructure.out.entity.SuppliedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SuppliedEntityMapper {

    SuppliedEntity modelToEntity(SuppliedModel suppliedModel);
    SuppliedModel entityToModel(SuppliedEntity suppliedEntity);
}
