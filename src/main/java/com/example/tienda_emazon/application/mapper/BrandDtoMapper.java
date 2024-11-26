package com.example.tienda_emazon.application.mapper;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.BrandModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandDtoMapper {

    BrandRequestDto modelToDto (BrandModel brandModel);
    BrandModel dtoToModel(BrandRequestDto brandRequestDto);

    default List<GenericResponse> toResponseList(List<BrandModel> modelList){
        return modelList.stream().map(brandModel-> {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setDate(LocalDateTime.now());
            genericResponse.setMessage(brandModel.getBrandDescription());
            return genericResponse;
        }).toList();
    }


}
