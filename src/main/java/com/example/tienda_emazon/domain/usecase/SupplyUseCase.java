package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.exception.CategoryDuplicatedException;
import com.example.tienda_emazon.domain.exception.SupplyAlreadyExistsException;
import com.example.tienda_emazon.domain.model.CategoryInfo;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.SuppliedModel;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
import com.example.tienda_emazon.domain.util.Constants;
import com.example.tienda_emazon.domain.util.FieldValidations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SupplyUseCase implements ISupplyServicePort {
    private final ISupplyPersistencePort iSupplyPersistencePort;
    private final ICategoryPersistencePort iCategoryPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort iSupplyPersistencePort, ICategoryPersistencePort iCategoryPersistencePort) {
        this.iSupplyPersistencePort = iSupplyPersistencePort;
        this.iCategoryPersistencePort = iCategoryPersistencePort;
    }

    @Override
    public SupplyModel createSupply(SupplyModel supplyModel){
        FieldValidations.validateCategoryAssociated(supplyModel);
        if (iSupplyPersistencePort.existsBySupplyName(supplyModel.getSupplyName())){
            throw new SupplyAlreadyExistsException(Constants.SUPPLY_ALREADY_EXIST  + " " + supplyModel.getSupplyName());
        }
        List<CategoryModel> categoryModels = new ArrayList<>();
        for (CategoryInfo categoryInfo : supplyModel.getAssociatedCategories()){
            CategoryModel categoryModel = iCategoryPersistencePort.findByCategoryName(categoryInfo.getCategoryName())
                    .orElseThrow(() -> new RuntimeException(Constants.CATEGORY_NOT_FOUND));
            if (categoryModels.contains(categoryModel)){
                throw new CategoryDuplicatedException(Constants.CATEGORY_DUPLICATED);
            }
            categoryModels.add(categoryModel);
        }
        supplyModel.setAssociatedCategories(categoryModels.stream()
                .map(categoryModel -> new CategoryInfo(categoryModel.getId(), categoryModel.getCategoryName()))
                .collect(Collectors.toList()));
        return iSupplyPersistencePort.saveSupply(supplyModel);
    }

    @Override
    public SupplyModel addSupplied(SuppliedModel suppliedModel) {

        Optional<SupplyModel> supplyDB = iSupplyPersistencePort.
                findBySupplyName(suppliedModel.getSuppliedName());
        if (supplyDB.isEmpty()){
            throw new RuntimeException("Item doesn't exists, if you can create one");
        }
        supplyDB.get().setSupplyAmount(supplyDB.get().getSupplyAmount() + suppliedModel.getSuppliedAmount());

        return iSupplyPersistencePort.saveSupply(supplyDB.get());
    }

    @Override
    public CustomPage<SupplyModel> getSuppliesPaginated(PageRequestDomain pageRequest) {
        return iSupplyPersistencePort.findAllPaginated(pageRequest);
    }
}
