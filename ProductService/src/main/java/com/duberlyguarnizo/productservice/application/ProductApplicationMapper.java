/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.application;

import com.duberlyguarnizo.productservice.domain.model.Price;
import com.duberlyguarnizo.productservice.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductApplicationMapper {
    public Product toDomain(ProductCreateRequest request) {
        log.warn(request.toString());
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(Price.of(request.price()))
                .build();
    }

    public ProductPageResponse toPageResponse(Product product) {
        log.warn(product.toString());
        return new ProductPageResponse(product.getId(),
                product.getName(),
                product.getDescription());
    }

    public ProductDetailResponse toDetailResponse(Product product) {
        log.warn(product.toString());
        return new ProductDetailResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice().value(),
                product.getCreatedAt());
    }
}
