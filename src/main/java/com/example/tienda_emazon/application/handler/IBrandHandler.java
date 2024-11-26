package com.example.tienda_emazon.application.handler;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

public interface IBrandHandler {
    
    GenericResponse saveBrand(BrandRequestDto requestDto);
    CustomPage<BrandModel> getBrandsPaginated(PageRequestDomain pageRequest);
}
