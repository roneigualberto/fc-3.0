package com.example.clean.architecture.domain.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class Product {

    private String id;

    private String name;

    private String description;

    private Double price;

    private LocalDateTime createdAt;
}
