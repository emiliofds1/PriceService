package com.emiliofds.prices.domain.exception;

import java.time.LocalDateTime;

/**
 * Exception thrown when no price is found for the given product, brand, and date.
 *
 * <p>Extends {@link DomainException}, indicating a domain-level error.
 */
public class PriceNotFoundException extends DomainException {

  /**
   * Creates a PriceNotFoundException with details about the missing price search.
   *
   * @param productId the product identifier
   * @param brandId the brand identifier
   * @param date the date used for the price query
   */
  public PriceNotFoundException(Long productId, Long brandId, LocalDateTime date) {
    super(
        String.format(
            "No price found for product %d, brand %d on date %s", productId, brandId, date));
  }
}
