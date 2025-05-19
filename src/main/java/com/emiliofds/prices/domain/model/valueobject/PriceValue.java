package com.emiliofds.prices.domain.model.valueobject;

import com.emiliofds.prices.domain.exception.InvalidPriceValueException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Value object representing the price amount.
 *
 * <p>Ensures that the price value is never negative, enforcing domain invariants.
 */
public class PriceValue {

  private final BigDecimal value;

  /**
   * Constructs a {@code PriceValue} and validates its priceValue.
   *
   * @throws InvalidPriceValueException if the price is negative or null
   */
  public PriceValue(BigDecimal priceValue) {
    this.value = priceValue;
    checkRules();
  }

  private void checkRules() {
    if (value == null) {
      throw new InvalidPriceValueException("price cannot be null");
    }
    if (value.compareTo(BigDecimal.ZERO) < 0) {
      throw new InvalidPriceValueException("price cannot be a negative number");
    }
  }

  public BigDecimal getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceValue that = (PriceValue) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "PriceValue{" + "priceValue=" + value + '}';
  }
}
