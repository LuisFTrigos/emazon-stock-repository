package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
import com.example.tienda_emazon.infrastructure.out.mapper.SupplyEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.JpaSupplyRepository;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SupplyJpaAdapter implements ISupplyPersistencePort {
    private final JpaSupplyRepository jpaSupplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public SupplyModel saveSupply(SupplyModel supplyModel){
        SupplyEntity supplyEntity = supplyEntityMapper.modelToEntity(supplyModel);
        System.out.println(supplyEntity.toString());
        supplyEntity = jpaSupplyRepository.save(supplyEntity);
        return supplyEntityMapper.entityToModel(supplyEntity);
    }

    @Override
    public CustomPage<SupplyModel> findAllPaginated(PageRequestDomain pageRequest) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (pageRequest.getSortDirection().equals(Sort.Direction.DESC.name())) {
            direction = Sort.Direction.DESC;
        }

        Sort sort = Sort.by(direction, pageRequest.getSortBy());
        Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), sort);
        Page<SupplyEntity> supplyEntityPage = jpaSupplyRepository.findAll(pageable);
        CustomPage<SupplyModel> customPage = new CustomPage<>();
        customPage.setPageNumber(supplyEntityPage.getNumber());
        customPage.setPageSize(supplyEntityPage.getSize());
        customPage.setTotalPages(supplyEntityPage.getTotalPages());
        customPage.setTotalElements(supplyEntityPage.getTotalElements());
        customPage.setContent(supplyEntityMapper.entityListModelList(supplyEntityPage.getContent()));
        return customPage;
    }

    @Override
    public Optional<SupplyModel> findBySupplyName(String supplyName) {
        return jpaSupplyRepository.findBySupplyName(supplyName).map(supplyEntityMapper::entityToModel);
    }

    @Override
    public boolean existsBySupplyName(String supplyName) {
        return jpaSupplyRepository.existsBySupplyName(supplyName);
    }

    @Override
    public Optional<SupplyModel> findBySupplyId(Long supplyId) {
        return Optional.empty();
    }

}
