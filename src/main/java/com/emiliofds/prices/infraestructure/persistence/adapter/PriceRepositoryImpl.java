package com.emiliofds.prices.infraestructure.persistence.adapter;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.PriceSearchCriteria;
import com.emiliofds.prices.domain.repository.PriceRepository;
import com.emiliofds.prices.infraestructure.persistence.adapter.mapper.PriceDataMapper;
import com.emiliofds.prices.infraestructure.persistence.jdbc.PriceJdbcRepository;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceData;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Default implementation of the {@link PriceRepository} interface.
 *
 * <p>This class acts as an adapter between the domain repository abstraction and the JDBC-based
 * persistence layer. It uses {@link PriceJdbcRepository} to fetch data and {@link PriceDataMapper}
 * to convert persistence DTOs into domain models.
 */
@Component
public class PriceRepositoryImpl implements PriceRepository {

  private final PriceJdbcRepository jdbcRepository;

  private final PriceDataMapper priceDataMapper;

  /**
   * Constructs a {@code PriceRepositoryImpl} with the given dependencies.
   *
   * @param jdbcRepository the JDBC repository handling database queries
   * @param priceDataMapper the mapper to convert database DTOs to domain objects
   */
  @Autowired
  public PriceRepositoryImpl(PriceJdbcRepository jdbcRepository, PriceDataMapper priceDataMapper) {
    this.jdbcRepository = jdbcRepository;
    this.priceDataMapper = priceDataMapper;
  }

  /**
   * Searches for a price matching the given criteria.
   *
   * @param criteria the domain search criteria
   * @return an {@link Optional} containing the matching {@link Price}, or empty if none found
   */
  @Override
  public Optional<Price> search(PriceSearchCriteria criteria) {
    Optional<PriceData> priceData =
        jdbcRepository.findFilteredPrice(
            criteria.getProductId(), criteria.getBrandId(), criteria.getDate().toString());

    return priceData.map(priceDataMapper::map);
  }
}
