package com.example.clean.architecture.domain.product.shared.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<T, ID extends Serializable> {

    void save(T entity);

    void update(T entity);

    Optional<T> findById();

    List<T> findAll();
}
