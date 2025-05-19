package com.emiliofds.prices.application.port;

import com.emiliofds.prices.application.dto.PriceResponse;
import java.time.LocalDateTime;

/**
 * Application port for the use case of searching the applicable price for a product and brand.
 *
 * <p>This interface define the contract for the service responsible for retrieving the price of a
 * product of a specific brand at a given date.
 */
public interface PriceSearcher {

  /**
   * Searches the applicable price of a product for brand at the given date.
   *
   * @param productId product identifier (required)
   * @param brandId brand identifier (required)
   * @param date date of the price inquiry, formatted as a {@code LocalDateTime} (required)
   * @return the requested price
   */
  PriceResponse search(Long productId, Long brandId, LocalDateTime date);
}
