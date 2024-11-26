package com.example.tienda_emazon.application.handler;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;

public interface ISuppliedHandler {

    GenericResponse addSupplied(SuppliedRequestDto suppliedRequestDto);

}
