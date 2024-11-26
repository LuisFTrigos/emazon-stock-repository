package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.IBrandHandler;
import com.example.tienda_emazon.application.mapper.BrandDtoMapper;
import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.tienda_emazon.domain.util.Constants.BRAND_CREATED_SUCCESSFULLY;

@Service
@RequiredArgsConstructor
public class BrandHandlerImpl implements IBrandHandler {

    private final IBrandServicePort brandServicePort;
    private final BrandDtoMapper brandDtoMapper;

    @Override
    public GenericResponse saveBrand(BrandRequestDto requestDto) {
        brandServicePort.createBrand(brandDtoMapper.dtoToModel(requestDto));
        return GenericResponse.builder()
                .message(BRAND_CREATED_SUCCESSFULLY)
                .date(LocalDateTime.now())
                .build();
    }

    @Override
    public CustomPage<BrandModel> getBrandsPaginated(PageRequestDomain pageRequest) {
        return brandServicePort.findAllPaginatedBrand(pageRequest);
    }

}
