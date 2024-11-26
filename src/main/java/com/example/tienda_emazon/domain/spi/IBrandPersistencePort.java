package com.example.tienda_emazon.domain.spi;

import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

import java.util.Optional;

public interface IBrandPersistencePort {

    BrandModel saveBrand(BrandModel brandModel);
    CustomPage<BrandModel> findAllPaginatedBrand(PageRequestDomain pageRequest);
    boolean existsByBrandName(String brandName);
    Optional<BrandModel> findByBrandName(String brandName);


}
