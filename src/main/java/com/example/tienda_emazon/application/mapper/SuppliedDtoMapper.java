package com.example.tienda_emazon.application.mapper;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.domain.model.SuppliedModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SuppliedDtoMapper {

    SuppliedRequestDto modelToDto(SuppliedModel suppliedModel);
    SuppliedModel dtoToModel(SuppliedRequestDto suppliedRequestDto);
}
