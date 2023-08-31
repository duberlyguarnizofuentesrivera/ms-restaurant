/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.application;

import java.math.BigDecimal;
import java.time.Instant;

public record ProductDetailResponse(String id, String name, String description, BigDecimal price, Instant createdTime) {
}
