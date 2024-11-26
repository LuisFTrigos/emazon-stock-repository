package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import com.example.tienda_emazon.infrastructure.out.mapper.CategoryEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.JpaCategoryRepository;
import com.example.tienda_emazon.infrastructure.out.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CategoryJpaAdapter implements ICategoryPersistencePort {
    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public boolean existsByCategoryName(String categoryName) {
        return jpaCategoryRepository.existsByCategoryName(categoryName);
    }

    @Override
    public CustomPage<CategoryModel> getCategoriesPaginated(PageRequestDomain pageRequestDomain) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (pageRequestDomain.getSortDirection().equals(Sort.Direction.DESC.name())) {
            direction = Sort.Direction.DESC;
        }

        Sort sort = Sort.by(direction, pageRequestDomain.getSortBy());
        Pageable pageable = PageRequest.of(pageRequestDomain.getPage(), pageRequestDomain.getSize(), sort);
        Page<CategoryEntity> categoryEntityPage = jpaCategoryRepository.findAll(pageable);
        CustomPage<CategoryModel> customPage = new CustomPage<>();
        customPage.setPageNumber(categoryEntityPage.getNumber());
        customPage.setPageSize(categoryEntityPage.getSize());
        customPage.setTotalPages(categoryEntityPage.getTotalPages());
        customPage.setTotalElements(categoryEntityPage.getTotalElements());
        customPage.setContent(categoryEntityMapper.toCategoryList(categoryEntityPage.getContent()));
        return customPage;
    }

    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        CategoryEntity categoryEntity = categoryEntityMapper.modelToEntity(categoryModel);
        categoryEntity = jpaCategoryRepository.save(categoryEntity);
        return categoryEntityMapper.entityToModel(categoryEntity);
    }

    @Override
    public Optional<CategoryModel> findByCategoryName(String categoryName) {
        return jpaCategoryRepository.findByCategoryName(categoryName).map(categoryEntityMapper::entityToModel);
    }
}
