package com.emiliofds.prices.application.service;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.port.PriceSearcher;
import com.emiliofds.prices.application.service.mapper.PriceResponseMapper;
import com.emiliofds.prices.domain.exception.PriceNotFoundException;
import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.PriceSearchCriteria;
import com.emiliofds.prices.domain.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Application service that retrieves the applicable price of a product for a brand at a given date.
 *
 * <p>This services is an implementation of the use case (@code PriceSearcher). It interacts with
 * the domain repositories and map the result to the response DTO.
 *
 * @see PriceSearcher
 */
@Service
public class PriceSearcherImpl implements PriceSearcher {

  private final PriceRepository repository;

  private final PriceResponseMapper mapper;

  /**
   * Create a {@code PriceSearchImpl} with the required dependencies.
   *
   * @param repository the price repository
   * @param mapper the domain mapper
   */
  @Autowired
  public PriceSearcherImpl(PriceRepository repository, PriceResponseMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  /**
   * Searches the applicable price of a product for a brand at the given date.
   *
   * <p>This method constructs an {@link PriceSearchCriteria} with the provided productId, brandId
   * and date.
   *
   * @param productId product identifier (required)
   * @param brandId brand identifier (required)
   * @param date date of the price inquiry (required)
   * @return the requested price
   * @throws PriceNotFoundException if no valid price is found for the given inputs
   */
  @Override
  public PriceResponse search(Long productId, Long brandId, LocalDateTime date) {
    PriceSearchCriteria criteria = PriceSearchCriteria.of(productId, brandId, date);
    Optional<Price> price = repository.search(criteria);

    if (price.isEmpty()) {
      throw new PriceNotFoundException(productId, brandId, date);
    }

    return mapper.map(price.get());
  }
}
