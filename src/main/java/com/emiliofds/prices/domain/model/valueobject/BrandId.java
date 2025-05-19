package com.emiliofds.prices.domain.model.valueobject;

/** Brand identifier value Object. extends {@link LongId} */
public class BrandId extends LongId {

  /**
   * Create a BrandId.
   *
   * @param value the identifier value (required)
   */
  public BrandId(Long value) {
    super(value);
  }
}
