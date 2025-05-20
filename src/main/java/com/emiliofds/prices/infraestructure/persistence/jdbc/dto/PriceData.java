package com.emiliofds.prices.infraestructure.persistence.jdbc.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) that represents a row in the pricing table from the database.
 *
 * <p>This record is used by the JDBC persistence layer to transfer raw pricing data retrieved from
 * the database before mapping it into the domain model.
 *
 * @param productId the identifier of the product
 * @param brandId the identifier of the brand
 * @param priceList the identifier of the price list
 * @param price the monetary value of the price
 */
public record PriceData(long productId, long brandId, long priceList, BigDecimal price) {}
