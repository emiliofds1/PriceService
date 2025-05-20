package com.emiliofds.prices.application.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO representing a price response from the domain layer.
 *
 * @param productId the product identifier (required)
 * @param brandId the brand identifier (required)
 * @param priceListId the price list identifier (required)
 * @param priceValue the value of the price (required)
 */
public record PriceResponse(Long productId, Long brandId, Long priceListId, BigDecimal priceValue) {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceResponse that = (PriceResponse) o;
    return productId.equals(that.productId)
        && brandId.equals(that.brandId)
        && priceListId.equals(that.priceListId)
        && priceValue.equals(that.priceValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, priceListId, priceValue);
  }
}
