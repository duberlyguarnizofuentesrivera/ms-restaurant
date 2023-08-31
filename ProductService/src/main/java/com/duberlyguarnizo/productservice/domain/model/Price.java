/*
 * Copyright (c) 2023.
 * Code by Duberly Guarnizo <duberlygfr@gmail.com>
 * Code under the MIT public licence. Visit https://mit-license.org for more information.
 */

package com.duberlyguarnizo.productservice.domain.model;

import java.math.BigDecimal;

public record Price(BigDecimal value) {
    public static Price of(BigDecimal value) {
        return new Price(value);
    }

    public BigDecimal getValue() {
        if (this.value == null)
            return BigDecimal.ZERO;
        else if (this.value.compareTo(BigDecimal.ZERO) < 0)
            return BigDecimal.ZERO;
        else if (this.value.compareTo(BigDecimal.ZERO) > 0)
            return value;
        else
            return BigDecimal.ZERO;
    }

    public Price add(Price price) {
        return new Price(this.getValue().add(price.getValue()));
    }

    public Price subtract(Price price) {
        if (this.getValue().compareTo(price.getValue()) < 0)
            return new Price(BigDecimal.ZERO);
        else if (this.getValue().compareTo(price.getValue()) > 0)
            return new Price(this.getValue().subtract(price.getValue()));
        else
            return new Price(BigDecimal.ZERO);
    }

}
