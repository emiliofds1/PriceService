package com.emiliofds.prices.interfaces.rest.mapper;

import com.emiliofds.prices.app.openapi.dto.Price;
import com.emiliofds.prices.application.dto.PriceResponse;
import org.springframework.stereotype.Component;

/** Mapper class responsible for converting domain layer responses to API model representations. */
@Component
public class PriceApiMapper {

  /**
   * Converts a {@code PriceResponse} from the domain layer into a {@code Price} API model.
   *
   * @param priceResponse the domain response object to convert (required)
   * @return the corresponding {@code Price} API model
   */
  public Price map(PriceResponse priceResponse) {
    Price price = new Price();

    price.setProductId(priceResponse.productId());
    price.setBrandId(priceResponse.brandId());
    price.setPriceList(priceResponse.priceListId());
    price.setPrice(priceResponse.priceValue());

    return price;
  }
}
