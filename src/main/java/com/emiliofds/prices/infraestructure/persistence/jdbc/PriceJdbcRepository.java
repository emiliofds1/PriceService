package com.emiliofds.prices.infraestructure.persistence.jdbc;

import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceData;
import com.emiliofds.prices.infraestructure.persistence.jdbc.mapper.PriceRowMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * JDBC-based repository for querying price data directly from the database.
 *
 * <p>This class uses a raw SQL query with {@link JdbcTemplate} to retrieve pricing information that
 * matches the specified filtering conditions. It returns raw data as {@link PriceData} for later
 * mapping into the domain model.
 */
@Repository
public class PriceJdbcRepository {

  private static final String SQL_FIND_FILTERED_PRICE =
      """
          SELECT product_id, brand_id, price_list, price
          FROM PRICE
          WHERE ? BETWEEN start_date AND end_date
            AND product_id = ?
            AND brand_id = ?
          ORDER BY priority DESC
          LIMIT 1;
      """;

  private final JdbcTemplate jdbcTemplate;

  /**
   * Constructs a {@code PriceJDBCRepository} with the required {@link JdbcTemplate}.
   *
   * @param jdbcTemplate the Spring JDBC template used for executing SQL queries (required)
   */
  @Autowired
  public PriceJdbcRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Executes a SQL query to find the most relevant price for the given product, brand and date.
   *
   * <p>The result is ordered by priority in descending order and limited to one entry.
   *
   * @param productId the product identifier to filter by
   * @param brandId the brand identifier to filter by
   * @param date the date used to filter prices within their validity period (expected format: ISO
   *     8601)
   * @return an {@link Optional} containing a {@link PriceData} if a match is found; empty otherwise
   */
  public Optional<PriceData> findFilteredPrice(long productId, long brandId, String date) {
    return jdbcTemplate
        .query(SQL_FIND_FILTERED_PRICE, new PriceRowMapper(), date, productId, brandId)
        .stream()
        .findFirst();
  }
}
