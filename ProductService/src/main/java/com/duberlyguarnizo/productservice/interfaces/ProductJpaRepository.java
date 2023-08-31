/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.interfaces;

import com.duberlyguarnizo.productservice.infrastructure.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends MongoRepository<ProductEntity, String> {
    Page<ProductEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
