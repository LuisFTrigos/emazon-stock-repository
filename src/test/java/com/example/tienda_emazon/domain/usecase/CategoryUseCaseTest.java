package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CategoryUseCaseTest {

    @InjectMocks
    public CategoryUseCase toTest;
    @Mock
    private ICategoryPersistencePort iCategoryPersistencePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenValidCategoryWhenSavingThenShouldSaveCategorySuccessfully() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName("Category Test");

        Mockito.when(iCategoryPersistencePort.findByCategoryName(categoryModel.getCategoryName())).thenReturn(null);

        toTest.createCategory(categoryModel);

        verify(iCategoryPersistencePort,
                times(1))
                .createCategory(categoryModel);
        assertEquals("Category Test", categoryModel.getCategoryName());
    }

    @Test
    void givenCategoryWhenCategoryAlreadyExistThenShouldThrowException() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName("Category Test");
        //Optional<CategoryModel> categoryModelOptional = Optional.of(categoryModel);

        Mockito.when(iCategoryPersistencePort.findByCategoryName(categoryModel.getCategoryName()))
                .thenReturn(Optional.of(categoryModel));

        assertThrows(CategoryAlreadyExistsException.class,
                () -> toTest.createCategory(categoryModel));
        verify(iCategoryPersistencePort,
                        Mockito.never())
                .createCategory(any(CategoryModel.class));
    }
}