package com.example.clean.architecture.application.rest.product;

import com.example.clean.architecture.usecase.product.CreateProductInputDTO;
import com.example.clean.architecture.usecase.product.CreateProductOutputDTO;
import com.example.clean.architecture.usecase.product.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;


    @Transactional
    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest productRequest,
                                                  UriComponentsBuilder uriBuilder) {


        //Create Input from Use Case
        CreateProductInputDTO input = CreateProductInputDTO.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();

        // Execute Use Case
        CreateProductOutputDTO output = createProductUseCase.execute(input);

        //Build Response
        URI location = uriBuilder.buildAndExpand(output.getId()).toUri();
        ProductResponse response = ProductResponse.builder()
                .id(output.getId())
                .createdAt(output.getCreatedAt())
                .name(output.getName())
                .price(output.getPrice())
                .description(output.getDescription())
                .build();

        return ResponseEntity.created(location).body(response);


    }


}
