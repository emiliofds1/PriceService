package com.emiliofds.prices.infraestructure.persistence.adapter.mapper;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceDB;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceDBMapper {

    public List<Price> map(List<PriceDB> prices) {
        return prices.stream().map(this::map).toList();
    }
    public Price map(PriceDB priceDB) {
        return Price.ofPrimitives(priceDB.getProductId(), priceDB.getBrandId(), priceDB.getPriceList(), priceDB.getPrice());
    }
}
