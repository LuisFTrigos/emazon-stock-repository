package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.exception.BrandAlreadyExistsException;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;
import com.example.tienda_emazon.domain.util.Constants;
import com.example.tienda_emazon.domain.util.FieldValidations;



public class BrandUseCase implements IBrandServicePort {
    private final IBrandPersistencePort iBrandPersistencePort;

    public BrandUseCase(IBrandPersistencePort iBrandPersistencePort) {
        this.iBrandPersistencePort = iBrandPersistencePort;
    }

    @Override
    public BrandModel createBrand(BrandModel brandModel){
        FieldValidations.validateFieldName(brandModel.getBrandName());
        FieldValidations.validateFieldDescription(brandModel.getBrandDescription());
        if(iBrandPersistencePort.existsByBrandName(brandModel.getBrandName())) {
            throw new BrandAlreadyExistsException(Constants.BRAND_ALREADY_EXIST + brandModel.getBrandName());
        }
        return iBrandPersistencePort.saveBrand(brandModel);
    }

    @Override
    public CustomPage<BrandModel> findAllPaginatedBrand(PageRequestDomain pageRequest) {
        return iBrandPersistencePort.findAllPaginatedBrand(pageRequest);
    }
}
