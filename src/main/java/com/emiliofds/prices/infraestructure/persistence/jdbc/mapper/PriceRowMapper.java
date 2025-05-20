package com.emiliofds.prices.infraestructure.persistence.jdbc.mapper;

import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceData;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Maps a JDBC {@link ResultSet} row to a {@link PriceData} DTO.
 *
 * <p>This implementation extracts the price-related columns from the result set and constructs a
 * {@code PriceData} object representing the database row.
 */
public class PriceRowMapper implements RowMapper<PriceData> {

  /**
   * Maps the current row of the given {@link ResultSet} to a {@link PriceData} instance.
   *
   * @param rs the result set to map (pre-initialized for the current row)
   * @param rowNum the number of the current row
   * @return the mapped {@code PriceData} object
   * @throws SQLException if an SQL error occurs while accessing the result set
   */
  @Override
  public PriceData mapRow(ResultSet rs, int rowNum) throws SQLException {
    int productIdResult = rs.getInt("product_id");
    int brandIdResult = rs.getInt("brand_id");
    int priceList = rs.getInt("price_list");
    BigDecimal price = rs.getBigDecimal("price");

    return new PriceData(productIdResult, brandIdResult, priceList, price);
  }
}
