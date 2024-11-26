package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.ISuppliedServicePort;
import com.example.tienda_emazon.domain.model.SuppliedModel;
import com.example.tienda_emazon.domain.spi.ISuppliedPersistencePort;

import java.util.Optional;

public class SuppliedUseCase implements ISuppliedServicePort {


    private final ISuppliedPersistencePort suppliedPersistencePort;

    public SuppliedUseCase(ISuppliedPersistencePort suppliedPersistencePort) {
        this.suppliedPersistencePort = suppliedPersistencePort;
    }


    @Override
    public SuppliedModel addSupplied(SuppliedModel suppliedModel) {

        Optional<SuppliedModel> suppliedAlreadyExists = suppliedPersistencePort.
                obtainSuppliedByName(suppliedModel.getSuppliedName());
        if (suppliedAlreadyExists.isPresent()){
            SuppliedModel existsSupplied = suppliedAlreadyExists.get();
            existsSupplied.setSuppliedAmount(existsSupplied.getSuppliedAmount()
                    + suppliedModel.getSuppliedAmount());
            return suppliedPersistencePort.saveSupplied(existsSupplied);
        }


        return suppliedPersistencePort.saveSupplied(suppliedModel);
    }


}
