package com.example.clean.architecture.infrastructure.handlers;

import com.example.clean.architecture.domain.product.event.ProductCreatedEvent;
import com.example.clean.architecture.domain.product.event.ProductCreatedHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedEventPublisher implements ProductCreatedHandler {

    @Override
    public void handler(ProductCreatedEvent event) {

        System.out.println("Send email");
    }
}
