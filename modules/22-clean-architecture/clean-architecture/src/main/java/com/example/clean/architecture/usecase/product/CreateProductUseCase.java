package com.example.clean.architecture.usecase.product;


import com.example.clean.architecture.domain.product.entity.Product;
import com.example.clean.architecture.domain.product.event.ProductCreatedEvent;
import com.example.clean.architecture.domain.product.event.ProductCreatedHandler;
import com.example.clean.architecture.domain.product.repository.ProductRepositoryInterface;
import com.example.clean.architecture.usecase.UseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class CreateProductUseCase implements UseCase<CreateProductInputDTO, CreateProductOutputDTO> {

    private final ProductRepositoryInterface productRepository;

    private final ProductCreatedHandler productCreatedHandler;

    @Override
    public CreateProductOutputDTO execute(CreateProductInputDTO input) {

        Product product = Product
                .builder()
                .id(UUID.randomUUID().toString())
                .name(input.getName())
                .createdAt(LocalDateTime.now())
                .description(input.getDescription())
                .price(input.getPrice())
                .build();

        productRepository.save(product);
        productCreatedHandler.handler(new ProductCreatedEvent(product));

        return CreateProductOutputDTO.builder()
                .id(product.getId())
                .createdAt(product.getCreatedAt())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
