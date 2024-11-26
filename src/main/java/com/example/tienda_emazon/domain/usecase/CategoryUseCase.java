package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import com.example.tienda_emazon.domain.util.FieldValidations;

import static com.example.tienda_emazon.domain.util.Constants.CATEGORY_ALREADY_EXIST;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public CategoryModel createCategory(CategoryModel categoryModel){
        FieldValidations.validateFieldName(categoryModel.getCategoryName());
        FieldValidations.validateFieldDescription(categoryModel.getCategoryDescription());
        if(categoryPersistencePort.existsByCategoryName(categoryModel.getCategoryName())) {
            throw new CategoryAlreadyExistsException(CATEGORY_ALREADY_EXIST + categoryModel.getCategoryName());
        }
        return categoryPersistencePort.createCategory(categoryModel);
    }

    @Override
    public CustomPage<CategoryModel> getAllPages(PageRequestDomain pageRequestDomain) {
        return categoryPersistencePort.getCategoriesPaginated(pageRequestDomain);
    }

}
