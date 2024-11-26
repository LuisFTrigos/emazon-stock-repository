package com.example.tienda_emazon.domain.spi;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

import java.util.Optional;

public interface ICategoryPersistencePort {

    CategoryModel createCategory(CategoryModel categoryModel);
    Optional<CategoryModel> findByCategoryName(String categoryName);
    boolean existsByCategoryName(String categoryName);
    CustomPage<CategoryModel> getCategoriesPaginated(PageRequestDomain pageRequestDomain);
}
