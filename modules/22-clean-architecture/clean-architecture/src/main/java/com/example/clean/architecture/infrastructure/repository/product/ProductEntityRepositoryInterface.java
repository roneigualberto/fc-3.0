package com.example.clean.architecture.infrastructure.repository.product;

import com.example.clean.architecture.domain.product.entity.Product;
import com.example.clean.architecture.domain.product.repository.ProductRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductEntityRepositoryInterface implements ProductRepositoryInterface {

    private final ProductEntityRepository productEntityRepository;

    @Override
    public void save(Product product) {

        ProductEntity productEntity = ProductEntity.builder()
                .id(UUID.fromString(product.getId()))
                .createAt(product.getCreatedAt())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

        productEntityRepository.save(productEntity);
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public Optional<Product> findById() {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
