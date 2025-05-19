package com.emiliofds.prices.infraestructure.persistence.adapter.mapper;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceData;
import org.springframework.stereotype.Component;

/**
 * Mapper component responsible for converting {@link PriceData} DTOs into {@link Price} domain
 * models.
 *
 * <p>This class encapsulates the mapping logic required by the persistence layer to transform raw
 * database records into rich domain objects used by the application.
 */
@Component
public class PriceDataMapper {

  /**
   * Maps a {@link PriceData} instance to a {@link Price} domain object.
   *
   * @param priceData the raw data retrieved from the database (must not be null)
   * @return a {@code Price} domain object with wrapped value objects
   */
  public Price map(PriceData priceData) {
    return Price.ofPrimitives(
        priceData.productId(), priceData.brandId(), priceData.priceList(), priceData.price());
  }
}
