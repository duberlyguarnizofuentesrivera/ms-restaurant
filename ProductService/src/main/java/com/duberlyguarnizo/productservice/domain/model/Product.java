/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.domain.model;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class Product {
    private String id;
    private String name;
    private String description;
    private Price price;
    private Instant createdAt;
}
