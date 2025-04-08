package com.emiliofds.prices.domain.model.valueObject;

import com.emiliofds.prices.domain.exception.InvalidPriceValueException;

import java.math.BigDecimal;

public record PriceValue(BigDecimal value) {

    public PriceValue(BigDecimal value) {
        this.value = value;
        checkRules();
    }

    private void checkRules() {
        if (value.compareTo(BigDecimal.ZERO) < 0)
            throw new InvalidPriceValueException("price cannot be a negative number");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceValue that = (PriceValue) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
