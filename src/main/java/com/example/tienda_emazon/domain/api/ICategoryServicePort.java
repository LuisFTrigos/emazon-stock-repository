package com.example.tienda_emazon.domain.api;

import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

public interface ICategoryServicePort {

    CategoryModel createCategory(CategoryModel categoryModel);
    CustomPage<CategoryModel> getAllPages(PageRequestDomain pageRequestDomain);

}
