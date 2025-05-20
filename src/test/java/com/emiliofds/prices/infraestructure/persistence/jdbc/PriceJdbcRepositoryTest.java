package com.emiliofds.prices.infraestructure.persistence.jdbc;

import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceData;
import com.emiliofds.prices.infraestructure.persistence.jdbc.mapper.PriceRowMapper;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

@JdbcTest
@Import({PriceJdbcRepository.class, PriceRowMapper.class})
@ActiveProfiles("test")
class PriceJdbcRepositoryTest {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private PriceJdbcRepository repository;

  @Test
  void findFilteredPrice_shouldReturnHighestPriorityPrice() {
    // Arrange
    String date = "2024-04-07 12:00:00";

    // Act
    Optional<PriceData> result = repository.findFilteredPrice(1L, 1L, date);

    // Assert
    Assertions.assertTrue(result.isPresent());
    Assertions.assertEquals(BigDecimal.valueOf(150.75f), result.get().price());
    Assertions.assertEquals(2L, result.get().priceList());
  }

  @Test
  void findFilteredPrice_shouldReturnEmpty_ifNoMatchingRows() {
    // Arrange
    String date = "2030-01-01 00:00:00";

    // Act
    Optional<PriceData> result = repository.findFilteredPrice(1L, 1L, date);

    // Assert
    Assertions.assertTrue(result.isEmpty());
  }
}
