package com.emiliofds.prices.infraestructure.persistence.adapter;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.SearchCriteria;
import com.emiliofds.prices.domain.repository.PriceRepository;
import com.emiliofds.prices.infraestructure.persistence.adapter.mapper.PriceDBMapper;
import com.emiliofds.prices.infraestructure.persistence.jdbc.PriceJDBCRepository;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJDBCRepository jdbcRepository;

    private final PriceDBMapper priceDBMapper;

    @Autowired
    public PriceRepositoryImpl(PriceJDBCRepository jdbcRepository, PriceDBMapper priceDBMapper) {
        this.jdbcRepository = jdbcRepository;
        this.priceDBMapper = priceDBMapper;
    }
    @Override
    public List<Price> search(SearchCriteria criteria) {
        List<PriceDB> prices = jdbcRepository.findFilteredPrice(criteria.getProductId(), criteria.getBrandId(), criteria.getDate().toString());

        return priceDBMapper.map(prices);
    }
}
