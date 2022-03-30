package com.example.clean.architecture.usecase.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CreateProductOutputDTO {


    private String id;

    private String name;

    private String description;

    private Double price;

    private LocalDateTime createdAt;
}
