package com.example.tienda_emazon.domain.spi;

import com.example.tienda_emazon.domain.model.SuppliedModel;

import java.util.Optional;

public interface ISuppliedPersistencePort {

    SuppliedModel saveSupplied(SuppliedModel suppliedModel);

    Optional<SuppliedModel> obtainSuppliedByName(String suppliedName);
}
