package com.emiliofds.prices.application.service.mapper;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.domain.model.Price;
import org.springframework.stereotype.Component;

/**
 * Mapper that converts domain {@link Price} objects into use case {@link PriceResponse} DTOs.
 *
 * <p>This class acts as a translator between the domain model and the application layer response
 * format.
 */
@Component
public class PriceResponseMapper {

  /**
   * Maps a {@link Price} domain object to a {@link PriceResponse} DTO.
   *
   * @param price the domain price to map
   * @return a {@code PriceResponse} representing the price data
   */
  public PriceResponse map(Price price) {
    return new PriceResponse(
        price.getProductId().getValue(),
        price.getBrandId().getValue(),
        price.getPriceListId().getValue(),
        price.getPriceValue().getValue());
  }
}
