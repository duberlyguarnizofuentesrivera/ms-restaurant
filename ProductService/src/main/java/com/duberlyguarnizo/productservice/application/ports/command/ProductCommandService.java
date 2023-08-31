/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.application.ports.command;

import com.duberlyguarnizo.productservice.application.ProductApplicationMapper;
import com.duberlyguarnizo.productservice.application.ProductCreateRequest;
import com.duberlyguarnizo.productservice.domain.ProductRepositoryInterface;
import com.duberlyguarnizo.productservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandService {
    private final ProductRepositoryInterface repository;
    private final ProductApplicationMapper mapper;

    public void persistProduct(ProductCreateRequest request) {
        Product productEntity = mapper.toDomain(request);
        repository.save(productEntity);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
