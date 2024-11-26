package com.example.tienda_emazon.application.handler;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

public interface ISupplyHandler {

    GenericResponse saveSupply(SupplyRequestDto requestDto);
    CustomPage<SupplyModel> getSuppliesPaginated(PageRequestDomain pageRequest);

    GenericResponse addSupplied(SuppliedRequestDto suppliedRequestDto);
}
