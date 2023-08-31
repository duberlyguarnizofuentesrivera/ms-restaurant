/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.domain;

import com.duberlyguarnizo.productservice.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductRepositoryInterface {
    public Product save(Product product);

    public void deleteById(String id);

    public Optional<Product> findById(String id);

    public Page<Product> findAll(Pageable pageable);

    public Page<Product> findByName(String name, Pageable pageable);
}
