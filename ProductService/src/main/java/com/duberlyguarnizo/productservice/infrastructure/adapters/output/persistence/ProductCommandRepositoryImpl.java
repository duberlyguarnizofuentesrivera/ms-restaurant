/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.infrastructure.adapters.output.persistence;

import com.duberlyguarnizo.productservice.domain.ProductRepositoryInterface;
import com.duberlyguarnizo.productservice.domain.model.Product;
import com.duberlyguarnizo.productservice.infrastructure.adapters.configuration.ProductInfraestructureMapper;
import com.duberlyguarnizo.productservice.interfaces.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductCommandRepositoryImpl implements ProductRepositoryInterface {
    private final ProductJpaRepository repository;
    private final ProductInfraestructureMapper mapper;

    @Override
    public Product save(Product product) {
        var productEntity = mapper.toEntity(product);
        var savedProduct = repository.save(productEntity);
        return mapper.toDomain(savedProduct);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }


    @Override
    public Optional<Product> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(name, pageable).map(mapper::toDomain);
    }
}
