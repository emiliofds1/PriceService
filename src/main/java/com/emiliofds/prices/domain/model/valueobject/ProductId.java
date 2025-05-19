package com.emiliofds.prices.domain.model.valueobject;

/**
 * Value object representing the unique identifier of a product.
 *
 * <p>Extends the generic {@link LongId} to enforce type safety for product IDs.
 */
public class ProductId extends LongId {

  /**
   * Creates a new {@code ProductId} with the given long value.
   *
   * @param value the raw product identifier value
   */
  public ProductId(Long value) {
    super(value);
  }
}
