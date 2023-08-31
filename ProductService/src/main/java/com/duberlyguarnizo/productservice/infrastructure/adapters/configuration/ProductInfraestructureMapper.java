/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.infrastructure.adapters.configuration;

import com.duberlyguarnizo.productservice.domain.model.Price;
import com.duberlyguarnizo.productservice.domain.model.Product;
import com.duberlyguarnizo.productservice.infrastructure.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductInfraestructureMapper {
    public ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice().value())
                .build();
    }

    public Product toDomain(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(Price.of(productEntity.getPrice()))
                .createdAt(productEntity.getCreatedAt())
                .build();
    }
}
