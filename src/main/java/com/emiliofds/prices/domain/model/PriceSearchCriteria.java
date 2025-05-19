package com.emiliofds.prices.domain.model;

import com.emiliofds.prices.domain.exception.InvalidSearchCriteriaException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents the criteria to search for a price in the domain.
 *
 * <p>Encapsulates the required parameters for querying a price: product ID, brand ID, and the date.
 * Ensures validation to avoid invalid criteria.
 */
public class PriceSearchCriteria {

  private final Long productId;
  private final Long brandId;
  private final LocalDateTime date;

  private PriceSearchCriteria(Long productId, Long brandId, LocalDateTime date) {
    validate(productId, brandId, date);
    this.productId = productId;
    this.brandId = brandId;
    this.date = date;
  }

  /**
   * Factory method to create a new {@code PriceSearchCriteria} instance.
   *
   * @param productId the product identifier (non-null)
   * @param brandId the brand identifier (non-null)
   * @param date the date of the price inquiry (non-null)
   * @return a validated {@code PriceSearchCriteria} instance
   * @throws InvalidSearchCriteriaException if any argument is null
   */
  public static PriceSearchCriteria of(Long productId, Long brandId, LocalDateTime date) {
    return new PriceSearchCriteria(productId, brandId, date);
  }

  private void validate(Long productId, Long brandId, LocalDateTime date) {
    if (productId == null) {
      throw new InvalidSearchCriteriaException("Product ID cannot be null");
    }
    if (brandId == null) {
      throw new InvalidSearchCriteriaException("Brand ID cannot be null");
    }
    if (date == null) {
      throw new InvalidSearchCriteriaException("Date cannot be null");
    }
  }

  public Long getProductId() {
    return productId;
  }

  public Long getBrandId() {
    return brandId;
  }

  public LocalDateTime getDate() {
    return date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceSearchCriteria that = (PriceSearchCriteria) o;
    return productId.equals(that.productId)
        && brandId.equals(that.brandId)
        && date.equals(that.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, date);
  }
}
