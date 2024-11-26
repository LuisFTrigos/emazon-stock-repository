package com.example.tienda_emazon.domain.api;

import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

public interface IBrandServicePort {

    BrandModel createBrand(BrandModel brandModel);
    CustomPage<BrandModel> findAllPaginatedBrand(PageRequestDomain pageRequest);

}
