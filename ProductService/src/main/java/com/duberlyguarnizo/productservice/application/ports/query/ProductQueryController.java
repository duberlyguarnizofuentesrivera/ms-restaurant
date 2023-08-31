/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.application.ports.query;

import com.duberlyguarnizo.productservice.application.ProductDetailResponse;
import com.duberlyguarnizo.productservice.application.ProductPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductQueryController {
    private final ProductQueryService productQueryService;

    @GetMapping
    public Page<ProductPageResponse> getProductPage(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return productQueryService.getProductPage(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDetailResponse getProductDetail(@PathVariable String id) {
        return productQueryService.getProductDetail(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public Page<ProductPageResponse> getProductPageByName(@PathVariable String name,
                                                          @PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                          Pageable pageable) {
        return productQueryService.getProductPageByName(name, pageable);
    }
}
