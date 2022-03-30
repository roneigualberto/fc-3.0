package com.example.clean.architecture.usecase.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductInputDTO {

    private String name;

    private String description;

    private Double price;
}
