package com.example.clean.architecture.usecase.product;

import com.example.clean.architecture.domain.product.event.ProductCreatedHandler;
import com.example.clean.architecture.domain.product.repository.ProductRepositoryInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

    public static final String PRODUCT_NAME = "Some Product";
    public static final String PRODUCT_DESCRIPTION = "Some Product Description";
    public static final double PRODUCT_PRICE = 19.99;

    @InjectMocks
    private CreateProductUseCase useCase;

    @Mock
    private ProductRepositoryInterface productRepository;

    @Mock
    private ProductCreatedHandler productCreatedHandler;

    @Test
    void shouldCreateProduct() {

        CreateProductInputDTO input = CreateProductInputDTO
                .builder()
                .name(PRODUCT_NAME)
                .description(PRODUCT_DESCRIPTION)
                .price(PRODUCT_PRICE)
                .build();

        CreateProductOutputDTO output = useCase.execute(input);

        assertAll(
                () -> assertNotNull(output.getId()),
                () -> assertNotNull(output.getCreatedAt()),
                () -> assertEquals(PRODUCT_NAME, output.getName()),
                () -> assertEquals(PRODUCT_DESCRIPTION, output.getDescription()),
                () -> assertEquals(PRODUCT_PRICE, output.getPrice()),
                () -> verify(productRepository).save(any()),
                () -> verify(productCreatedHandler).handler(any())
        );
    }

}