/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.application.ports.query;

import com.duberlyguarnizo.productservice.application.ProductApplicationMapper;
import com.duberlyguarnizo.productservice.application.ProductDetailResponse;
import com.duberlyguarnizo.productservice.application.ProductPageResponse;
import com.duberlyguarnizo.productservice.domain.ProductRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductQueryService {
    private final ProductRepositoryInterface repository;
    private final ProductApplicationMapper mapper;

    public Page<ProductPageResponse> getProductPage(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toPageResponse);
    }

    public Optional<ProductDetailResponse> getProductDetail(String id) {
        return repository.findById(id).map(mapper::toDetailResponse);
    }

    public Page<ProductPageResponse> getProductPageByName(String name, Pageable pageable) {
        return repository.findByName(name, pageable)
                .map(mapper::toPageResponse);
    }
}
