package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.BrandDtoMapper;
import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.exception.InvalidArgumentException;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class BrandServiceImplTest {

    @Mock
    private BrandDtoMapper brandDtoMapper;
    @Mock
    private IBrandServicePort iBrandServicePort;
    @InjectMocks
    private BrandHandlerImpl toTest;

    @Test
    void verifyTheServiceReturnsCorrectResultWhenSaveBrand() {
        BrandRequestDto brandRequestDto = new BrandRequestDto();

        BrandModel testBrandModel = new BrandModel();
        testBrandModel.setBrandDescription(null);

        when(brandDtoMapper.dtoToModel(brandRequestDto))
                .thenReturn(testBrandModel);

        assertThrows(InvalidArgumentException.class, () ->
                toTest.saveBrand(brandRequestDto));
        verify(iBrandServicePort, never()).createBrand(any());

    }

    @Test
    void givenDateWhenBrandSavedSuccessfully() {
        BrandRequestDto brandRequestDto = new BrandRequestDto();

        BrandModel testBrandModel = new BrandModel();
        testBrandModel.setBrandDescription("Description Text");

        when(brandDtoMapper.dtoToModel(brandRequestDto))
                .thenReturn(testBrandModel);
        GenericResponse genericResponse = toTest.saveBrand(brandRequestDto);
        assertNotNull(genericResponse);
        assertEquals(Constants.BRAND_CREATED_SUCCESSFULLY,
                genericResponse.getMessage());
        assertNotNull(genericResponse.getDate());

    }

}
