package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ISuppliedHandler;
import com.example.tienda_emazon.application.mapper.SuppliedDtoMapper;
import com.example.tienda_emazon.domain.api.ISuppliedServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.tienda_emazon.domain.util.Constants.SUPPLIED_CREATED_SUCCESSFULLY;

@Service
@RequiredArgsConstructor
public class SuppliedHandlerImpl implements ISuppliedHandler {

    private final ISuppliedServicePort suppliedServicePort;
    private final SuppliedDtoMapper suppliedDtoMapper;

    @Override
    public GenericResponse addSupplied(SuppliedRequestDto suppliedRequestDto) {
            suppliedServicePort.addSupplied(suppliedDtoMapper.dtoToModel(suppliedRequestDto));
            return GenericResponse.builder()
                    .message(SUPPLIED_CREATED_SUCCESSFULLY)
                    .date(LocalDateTime.now())
                    .build();
    }
}
