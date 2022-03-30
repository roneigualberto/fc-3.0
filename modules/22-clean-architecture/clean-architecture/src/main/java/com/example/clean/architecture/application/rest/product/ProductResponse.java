package com.example.clean.architecture.application.rest.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductResponse {

    private String id;

    private LocalDateTime createdAt;

    private String name;

    private String description;

    private Double price;
}
