package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;
import com.example.tienda_emazon.infrastructure.out.entity.BrandEntity;
import com.example.tienda_emazon.infrastructure.out.mapper.BrandEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.JpaBrandRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BrandJpaAdapter implements IBrandPersistencePort {
    private final JpaBrandRepository jpaBrandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public BrandModel saveBrand(BrandModel brandModel) {
        BrandEntity brandEntity = brandEntityMapper.modelToEntity(brandModel);
        brandEntity = jpaBrandRepository.save(brandEntity);
        return brandEntityMapper.entityToModel(brandEntity);
    }

    @Override
    public CustomPage<BrandModel> findAllPaginatedBrand(PageRequestDomain pageRequest) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (pageRequest.getSortDirection().equals(Sort.Direction.DESC.name())) {
            direction = Sort.Direction.DESC;
        }

        Sort sort = Sort.by(direction, pageRequest.getSortBy());
        Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), sort);
        Page<BrandEntity> brandEntityPage = jpaBrandRepository.findAll(pageable);
        CustomPage<BrandModel> customPage = new CustomPage<>();
        customPage.setPageNumber(brandEntityPage.getNumber());
        customPage.setPageSize(brandEntityPage.getSize());
        customPage.setTotalPages(brandEntityPage.getTotalPages());
        customPage.setTotalElements(brandEntityPage.getTotalElements());
        customPage.setContent(brandEntityMapper.entityListToModelList(brandEntityPage.getContent()));
        return customPage;
    }

    @Override
    public boolean existsByBrandName(String brandName) {
        return jpaBrandRepository.existsByBrandName(brandName);
    }

    @Override
    public Optional<BrandModel> findByBrandName(String brandName) {
        return jpaBrandRepository.findByBrandName(brandName).map(brandEntityMapper::entityToModel);
    }
}
