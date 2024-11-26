package com.example.tienda_emazon.application.handler;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

public interface ICategoryHandler {

    GenericResponse saveCategory(CategoryRequestDto categoryDto);
    CustomPage<CategoryModel> getCategoriesPaginated(PageRequestDomain pageRequestDomain);
}
