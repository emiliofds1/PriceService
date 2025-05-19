package com.emiliofds.prices.domain.model.valueobject;

/**
 * Value object representing the identifier of a price list.
 *
 * <p>This class extends {@link LongId} to encapsulate the identity of a price list in a type-safe
 * and domain-oriented way, enforcing invariants at the type level.
 */
public class PriceListId extends LongId {

  /**
   * Creates a new {@code PriceListId} with the given value.
   *
   * @param value the numeric identifier of the price list (required)
   */
  public PriceListId(Long value) {
    super(value);
  }
}
