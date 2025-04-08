package com.emiliofds.prices.domain.repository;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.SearchCriteria;

import java.util.List;

public interface PriceRepository {
    List<Price> search(SearchCriteria criteria);
}
