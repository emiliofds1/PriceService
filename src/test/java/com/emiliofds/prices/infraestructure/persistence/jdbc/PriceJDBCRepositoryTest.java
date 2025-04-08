package com.emiliofds.prices.infraestructure.persistence.jdbc;

import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceDB;
import com.emiliofds.prices.infraestructure.persistence.jdbc.mapper.PriceRowMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@JdbcTest
@Import({PriceJDBCRepository.class, PriceRowMapper.class})
@ActiveProfiles("test")
class PriceJDBCRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PriceJDBCRepository repository;

    @Test
    void findFilteredPrice_shouldReturnHighestPriorityPrice() {
        // Arrange
        String date = "2024-04-07 12:00:00";
        List<PriceDB> results = repository.findFilteredPrice(1L, 1L, date);

        // Assert
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(BigDecimal.valueOf(150.75f), results.get(0).getPrice());
        Assertions.assertEquals(2L, results.get(0).getPriceList());
    }

    @Test
    void findFilteredPrice_shouldReturnEmptyList_ifNoMatchingRows() {
        // Arrange
        String date = "2030-01-01 00:00:00";
        List<PriceDB> results = repository.findFilteredPrice(1L, 1L, date);

        // Assert
        Assertions.assertTrue(results.isEmpty());
    }
}
