package com.example.tienda_emazon.infrastructure.configuration;

import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.api.ISuppliedServicePort;
import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import com.example.tienda_emazon.domain.spi.ISuppliedPersistencePort;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
import com.example.tienda_emazon.domain.usecase.BrandUseCase;
import com.example.tienda_emazon.domain.usecase.CategoryUseCase;
import com.example.tienda_emazon.domain.usecase.SuppliedUseCase;
import com.example.tienda_emazon.domain.usecase.SupplyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    private final ICategoryPersistencePort categoryPersistencePort;
    private final IBrandPersistencePort brandPersistencePort;
    private final ISupplyPersistencePort supplyPersistencePort;
    private final ISuppliedPersistencePort suppliedPersistencePort;

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort);
    }

    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort);
    }

    @Bean
    public ISupplyServicePort supplyServicePort(){
        return new SupplyUseCase(supplyPersistencePort, categoryPersistencePort);
    }

    @Bean
    public ISuppliedServicePort suppliedServicePort(){
        return new SuppliedUseCase(suppliedPersistencePort);
    }

}
