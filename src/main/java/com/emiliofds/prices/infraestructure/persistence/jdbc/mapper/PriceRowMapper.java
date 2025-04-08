package com.emiliofds.prices.infraestructure.persistence.jdbc.mapper;


import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceDB;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class PriceRowMapper {

    public List<PriceDB> map(List<Map<String, Object>> rows) {
        return rows.stream().map(this::map).toList();
    }

    public PriceDB map(Map<String, Object> row) {
        int productIdResult = (int) row.get("product_id");
        int brandIdResult = (int) row.get("brand_id");
        int priceList = (int) row.get("price_list");
        BigDecimal price = (BigDecimal) row.get("price");

        return new PriceDB(productIdResult, brandIdResult, priceList, price);
    }
}

