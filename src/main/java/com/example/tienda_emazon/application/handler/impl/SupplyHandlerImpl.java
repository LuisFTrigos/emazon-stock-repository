package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ISupplyHandler;
import com.example.tienda_emazon.application.mapper.SupplyDtoMapper;
import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.tienda_emazon.domain.util.Constants.SUPPLIED_CREATED_SUCCESSFULLY;
import static com.example.tienda_emazon.domain.util.Constants.SUPPLY_CREATED_SUCCESSFULLY;

@Service
@RequiredArgsConstructor
public class SupplyHandlerImpl implements ISupplyHandler {

    private final ISupplyServicePort supplyServicePort;
    private final SupplyDtoMapper supplyDtoMapper;

    @Override
    public GenericResponse saveSupply(SupplyRequestDto requestDto) {
        supplyServicePort.createSupply(supplyDtoMapper.dtoToModel(requestDto));
        return GenericResponse.builder()
                .message(SUPPLY_CREATED_SUCCESSFULLY)
                .date(LocalDateTime.now())
                .build();
    }

    @Override
    public CustomPage<SupplyModel> getSuppliesPaginated(PageRequestDomain pageRequest) {
        return supplyServicePort.getSuppliesPaginated(pageRequest);
    }

    @Override
    public GenericResponse addSupplied(SuppliedRequestDto suppliedRequestDto) {
        supplyServicePort.addSupplied(supplyDtoMapper.dtoToModel(suppliedRequestDto));
        return GenericResponse.builder()
                .message(SUPPLIED_CREATED_SUCCESSFULLY)
                .date(LocalDateTime.now())
                .build();
    }
}
