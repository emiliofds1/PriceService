package com.emiliofds.prices.infraestructure.persistence.jdbc;

import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceDB;
import com.emiliofds.prices.infraestructure.persistence.jdbc.mapper.PriceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PriceJDBCRepository {

    private static final String SQL_FIND_FILTERED_PRICE = """
        SELECT p.product_id, p.brand_id, p.price_list, p.price
        FROM PRICE p
        JOIN (
            SELECT MAX(priority) AS max_priority
            FROM PRICE
            WHERE ? BETWEEN start_date AND end_date
              AND product_id = ?
              AND brand_id = ?
        ) sub ON sub.max_priority = p.priority
        WHERE ? BETWEEN p.start_date AND p.end_date
          AND p.product_id = ?
          AND p.brand_id = ?
    """;

    private final JdbcTemplate jdbcTemplate;

    private final PriceRowMapper mapper;

    @Autowired
    public PriceJDBCRepository(JdbcTemplate jdbcTemplate, PriceRowMapper mapper) {
        this.mapper = mapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PriceDB> findFilteredPrice(long productId, long brandId, String date) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_FILTERED_PRICE, date, productId, brandId, date, productId, brandId);

        return mapper.map(rows);
    }
}