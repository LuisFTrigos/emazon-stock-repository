package com.example.tienda_emazon.infrastructure.out.mapper;

import com.example.tienda_emazon.domain.model.CategoryInfo;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.infrastructure.out.entity.CategoryEntity;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyEntityMapper {
    @Mapping(target = "supplyCategories", source = "associatedCategories")
    SupplyEntity modelToEntity(SupplyModel supplyModel);
    @Mapping(target = "associatedCategories", source = "supplyCategories")
    SupplyModel entityToModel(SupplyEntity supplyEntity);
    List<SupplyModel> entityListModelList(List<SupplyEntity> supplyEntityList);

    default List<CategoryEntity> mapToCategoryEntities(List<CategoryInfo> associatedCategories) {
        if (associatedCategories == null) {
            return null;
        }
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (CategoryInfo categoryInfo: associatedCategories) {
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(categoryInfo.getId());
            categoryEntity.setCategoryName(categoryInfo.getCategoryName());
            categoryEntities.add(categoryEntity);
        }
        return categoryEntities;
    }

    default List<CategoryInfo> mapToCategoryName(List<CategoryEntity> supplyCategories) {
        if (supplyCategories == null){
            return null;
        }
        List<CategoryInfo> categoryInfos = new ArrayList<>();
        for (CategoryEntity categoryEntity: supplyCategories) {
            categoryInfos.add(new CategoryInfo(categoryEntity.getId(), categoryEntity.getCategoryName()));
        }
        return categoryInfos;
    }


}
