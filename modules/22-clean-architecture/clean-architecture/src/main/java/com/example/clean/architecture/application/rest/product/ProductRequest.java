package com.example.clean.architecture.application.rest.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductRequest {

    @NonNull
    private String name;

    private String description;

    @NotNull
    private Double price;
}
