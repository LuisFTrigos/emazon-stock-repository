package com.example.tienda_emazon.application.mapper;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.CategoryInfo;
import com.example.tienda_emazon.domain.model.SuppliedModel;
import com.example.tienda_emazon.domain.model.SupplyModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyDtoMapper {

    SupplyRequestDto modelToDto (SupplyModel supplyModel);
    SupplyModel dtoToModel(SupplyRequestDto supplyRequestDto);
    SuppliedModel dtoToModel(SuppliedRequestDto suppliedRequestDto);

    default List<String> mapToCategoryInfo(List<CategoryInfo> categoryInfos) {
        if (categoryInfos == null) {
            return null;
        }
        List<String> categoryNames = new ArrayList<>();
        for (CategoryInfo categoryInfo : categoryInfos) {
            categoryNames.add(categoryInfo.getCategoryName());
        }
        return categoryNames;
    }

    default List<CategoryInfo> mapToCategoryInfoStrings(List<String> categoryNames) {
        if (categoryNames == null) {
            return null;
        }
        List<CategoryInfo> categoryInfos = new ArrayList<>();
        for (String categoryName : categoryNames) {
            categoryInfos.add(new CategoryInfo(1L,categoryName));
        }
        return categoryInfos;
    }

}
