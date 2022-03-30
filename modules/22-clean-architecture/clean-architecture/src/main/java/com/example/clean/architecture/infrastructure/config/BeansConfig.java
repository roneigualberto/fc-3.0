package com.example.clean.architecture.infrastructure.config;

import com.example.clean.architecture.domain.product.event.ProductCreatedHandler;
import com.example.clean.architecture.domain.product.repository.ProductRepositoryInterface;
import com.example.clean.architecture.usecase.product.CreateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {


    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepositoryInterface productRepository, ProductCreatedHandler productCreatedHandler) {
        return new CreateProductUseCase(productRepository, productCreatedHandler);
    }
}
