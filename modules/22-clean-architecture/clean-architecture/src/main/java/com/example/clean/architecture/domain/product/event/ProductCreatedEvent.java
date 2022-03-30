package com.example.clean.architecture.domain.product.event;

import com.example.clean.architecture.domain.product.entity.Product;

import java.time.LocalDateTime;

public class ProductCreatedEvent {

    private LocalDateTime createdAt;

    private Product product;

    public ProductCreatedEvent(Product product) {
        this.createdAt = LocalDateTime.now();
        this.product = product;
    }
}

