package com.example.tienda_emazon.infrastructure.out.mapper;

import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.infrastructure.out.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandEntityMapper {

    BrandEntity modelToEntity(BrandModel brandModel);
    BrandModel entityToModel(BrandEntity brandEntity);
    List<BrandModel> entityListToModelList(List<BrandEntity> brandEntityList);
}
