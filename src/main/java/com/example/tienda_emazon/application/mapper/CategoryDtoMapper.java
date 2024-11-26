package com.example.tienda_emazon.application.mapper;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {

    CategoryRequestDto modelToDto(CategoryModel categoryModel);
    CategoryModel dtoToModel(CategoryRequestDto categoryRequestDto);

    default List<GenericResponse> toResponseList(List<CategoryModel> modelList) {
        return modelList.stream().map(categoryModel -> {
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setDate(LocalDateTime.now());
        genericResponse.setMessage(categoryModel.getCategoryDescription());
        return genericResponse;
        }).toList();
    }


}


