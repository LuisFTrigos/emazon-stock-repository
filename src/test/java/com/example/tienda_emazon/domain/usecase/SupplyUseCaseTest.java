package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.exception.SupplyAlreadyExistsException;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class SupplyUseCaseTest {

    @InjectMocks
    public SupplyUseCase toTest;
    @Mock
    private ISupplyPersistencePort iSupplyPersistencePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenValidSupplyWhenSavingThenShouldSaveSupplySuccessfully() {
        SupplyModel supplyModel = new SupplyModel();
        supplyModel.setSupplyName("Supply Test");

        Mockito.when(iSupplyPersistencePort.findBySupplyName
                (supplyModel.getSupplyName())).thenReturn(null);

        toTest.createSupply(supplyModel);

        verify(iSupplyPersistencePort,
                times(1))
                .saveSupply(supplyModel);
        assertEquals("Supply Test", supplyModel.getSupplyName());
    }

    @Test
    void givenSupplyWhenSupplyAlreadyExistThenShouldThrowException() {
        SupplyModel supplyModel = new SupplyModel();
        supplyModel.setSupplyName("Supply Test");

        Mockito.when(iSupplyPersistencePort.findBySupplyName
                (supplyModel.getSupplyName())).thenReturn(Optional.of(supplyModel) );

        assertThrows(SupplyAlreadyExistsException.class,
                () -> toTest.createSupply(supplyModel));
        verify(iSupplyPersistencePort,
                Mockito.never())
                .saveSupply(any(SupplyModel.class));
    }

}
