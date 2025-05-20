package com.emiliofds.prices.domain.model;

import com.emiliofds.prices.domain.model.valueobject.BrandId;
import com.emiliofds.prices.domain.model.valueobject.PriceListId;
import com.emiliofds.prices.domain.model.valueobject.PriceValue;
import com.emiliofds.prices.domain.model.valueobject.ProductId;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Domain model representing a price and its associations with products, brands, and price lists.
 *
 * <p>This class encapsulates the identity and value of a price within the pricing context. It is
 * composed of several value objects that represent its attributes, enforcing domain invariants.
 *
 * <p>The {@code Price} class is immutable and must be instantiated using the factory method {@link
 * #ofPrimitives(Long, Long, Long, BigDecimal)}, which takes primitive values and wraps them into
 * their corresponding value objects.
 */
public class Price {

  private final ProductId productId;

  private final BrandId brandId;

  private final PriceListId priceListId;

  private final PriceValue priceValue;

  /**
   * Constructs a {@code Price} with the given value objects.
   *
   * @param productId the identifier of the product (required)
   * @param brandId the identifier of the brand (required)
   * @param priceListId the identifier of the price list (required)
   * @param priceValue the monetary value of the price (required)
   */
  private Price(
      ProductId productId, BrandId brandId, PriceListId priceListId, PriceValue priceValue) {
    this.productId = productId;
    this.brandId = brandId;
    this.priceListId = priceListId;
    this.priceValue = priceValue;
  }

  /**
   * Factory method that creates a {@code Price} object from primitive values.
   *
   * @param productId the product identifier
   * @param brandId the brand identifier
   * @param priceList the price list identifier
   * @param price the price value
   * @return a new {@code Price} instance
   */
  public static Price ofPrimitives(Long productId, Long brandId, Long priceList, BigDecimal price) {
    return new Price(
        new ProductId(productId),
        new BrandId(brandId),
        new PriceListId(priceList),
        new PriceValue(price));
  }

  public ProductId getProductId() {
    return productId;
  }

  public BrandId getBrandId() {
    return brandId;
  }

  public PriceListId getPriceListId() {
    return priceListId;
  }

  public PriceValue getPriceValue() {
    return priceValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price price1 = (Price) o;
    return productId.equals(price1.productId)
        && brandId.equals(price1.brandId)
        && priceListId.equals(price1.priceListId)
        && priceValue.equals(price1.priceValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, priceListId, priceValue);
  }
}
