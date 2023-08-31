/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    @MongoId
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    @CreatedDate
    private Instant createdAt;
}
