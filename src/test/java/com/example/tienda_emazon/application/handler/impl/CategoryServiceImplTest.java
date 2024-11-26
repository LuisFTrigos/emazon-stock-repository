package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.CategoryDtoMapper;
import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.exception.InvalidArgumentException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryDtoMapper categoryDtoMapper;
    @Mock
    private ICategoryServicePort iCategoryServicePort;
    @InjectMocks
    private CategoryHandlerImpl toTest;

    @Test
    void verifyTheServiceReturnsCorrectResultWhenSaveCategory() {
      CategoryRequestDto categoryRequestDto = new CategoryRequestDto();

      CategoryModel testCategoryModel = new CategoryModel();
      testCategoryModel.setCategoryDescription(null);

      when(categoryDtoMapper.dtoToModel(categoryRequestDto))
              .thenReturn(testCategoryModel);

      assertThrows(InvalidArgumentException.class, () ->
              toTest.saveCategory(categoryRequestDto));
      verify(iCategoryServicePort, never()).createCategory(any());

    }

    @Test
    void givenDateWhenCategorySavedSuccessfully() {
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();

        CategoryModel testCategoryModel = new CategoryModel();
        testCategoryModel.setCategoryDescription("Description Text");

        when(categoryDtoMapper.dtoToModel(categoryRequestDto))
                .thenReturn(testCategoryModel);
        GenericResponse genericResponse = toTest.saveCategory(categoryRequestDto);
        assertNotNull(genericResponse);
        assertEquals(Constants.CATEGORY_CREATED_SUCCESSFULLY,
                genericResponse.getMessage());
        assertNotNull(genericResponse.getDate());

    }
}