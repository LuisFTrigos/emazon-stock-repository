package com.example.tienda_emazon.domain.spi;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import java.util.Optional;

public interface ISupplyPersistencePort {

    SupplyModel saveSupply(SupplyModel supplyModel);
    CustomPage<SupplyModel> findAllPaginated(PageRequestDomain pageRequest);
    Optional<SupplyModel> findBySupplyName(String supplyName);
    boolean existsBySupplyName(String supplyName);
    Optional<SupplyModel> findBySupplyId(Long supplyId);
}
