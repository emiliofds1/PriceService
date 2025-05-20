package com.emiliofds.prices.interfaces.rest.controller;

import com.emiliofds.prices.app.openapi.controller.PriceApi;
import com.emiliofds.prices.app.openapi.dto.Price;
import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.port.PriceSearcher;
import com.emiliofds.prices.interfaces.rest.mapper.PriceApiMapper;
import com.emiliofds.prices.interfaces.rest.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that handles HTTP requests related to pricing.
 *
 * <p>This controller acts as an adapter between the generated REST API interface and the
 * application layer. It receives HTTP request, delegates the processing to the application layer
 * and return the response in the appropriate API format.
 *
 * @see PriceApi
 */
@RestController
public class PriceController implements PriceApi {

  private final PriceSearcher priceSearcher;

  private final PriceApiMapper priceApiMapper;

  /**
   * Creates a {@code PriceController} with the required dependencies.
   *
   * @param priceSearcher the application port for searching the applicable price (required)
   * @param priceApiMapper the mapper that converts between API model and domain model (required)
   */
  @Autowired
  public PriceController(PriceSearcher priceSearcher, PriceApiMapper priceApiMapper) {
    this.priceSearcher = priceSearcher;
    this.priceApiMapper = priceApiMapper;
  }

  /**
   * Retrieves the applicable price of a product for brand at the given date.
   *
   * <p>This method is invoked when a GET request is made to the price endpoint. It delegates the
   * search logic to {@link PriceSearcher} application service.
   *
   * @param productId product identifier (required)
   * @param brandId brand identifier (required)
   * @param date date of the price inquiry in ISO 8601 with offset (required)
   * @return a {@code ResponseEntity} containing the requested price
   */
  @Override
  public ResponseEntity<Price> getPrice(Long productId, Long brandId, String date) {
    PriceResponse response = priceSearcher.search(productId, brandId, DateFormatter.format(date));

    return ResponseEntity.ok().body(priceApiMapper.map(response));
  }
}
