package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.exception.BrandAlreadyExistsException;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BrandUseCaseTest {

    @InjectMocks
    public BrandUseCase toTest;
    @Mock
    private IBrandPersistencePort iBrandPersistencePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenValidBrandWhenSavingThenShouldSaveBrandSuccessfully() {
        BrandModel brandModel = new BrandModel();
        brandModel.setBrandName("Brand Test");

        Mockito.when(iBrandPersistencePort.findByBrandName
                (brandModel.getBrandName())).thenReturn(null);

        toTest.createBrand(brandModel);

        verify(iBrandPersistencePort,
                times(1))
                .saveBrand(brandModel);
        assertEquals("Brand Test", brandModel.getBrandName());
    }

    @Test
    void givenBrandWhenBrandAlreadyExistThenShouldThrowException() {
        BrandModel brandModel = new BrandModel();
        brandModel.setBrandName("Brand Test");

        Mockito.when(iBrandPersistencePort.findByBrandName
                (brandModel.getBrandName())).thenReturn(Optional.of(brandModel));

        assertThrows(BrandAlreadyExistsException.class,
                () -> toTest.createBrand(brandModel));
        verify(iBrandPersistencePort,
                Mockito.never())
                .saveBrand(any(BrandModel.class));
    }
}
