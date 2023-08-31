/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.application;

import java.math.BigDecimal;

public record ProductCreateRequest(String name, String description, BigDecimal price) {
}
