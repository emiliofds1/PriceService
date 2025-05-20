package com.emiliofds.prices.domain.repository;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.PriceSearchCriteria;
import java.util.Optional;

/**
 * Repository interface for accessing and querying price data in the domain layer.
 *
 * <p>This abstraction defines the contract for retrieving prices based on specific search criteria.
 * It decouples the domain logic from the underlying persistence implementation.
 */
public interface PriceRepository {

  /**
   * Searches for a price that matches the given {@link PriceSearchCriteria}.
   *
   * @param criteria the parameters used to filter and locate a matching price (required)
   * @return an {@link Optional} containing the matching {@link Price} if found, or empty otherwise
   */
  Optional<Price> search(PriceSearchCriteria criteria);
}
