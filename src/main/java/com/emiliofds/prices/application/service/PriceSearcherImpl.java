package com.emiliofds.prices.application.service;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.port.PriceSearcher;
import com.emiliofds.prices.application.service.mapper.PriceResponseMapper;
import com.emiliofds.prices.domain.exception.MultiplePriceException;
import com.emiliofds.prices.domain.exception.PriceNotFoundException;
import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.SearchCriteria;
import com.emiliofds.prices.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceSearcherImpl implements PriceSearcher {

    private final PriceRepository repository;

    private final PriceResponseMapper mapper;

    @Autowired
    public PriceSearcherImpl(PriceRepository repository, PriceResponseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public PriceResponse search(Long productId, Long brandId, LocalDateTime date) {
        SearchCriteria criteria = SearchCriteria.of(productId, brandId, date);
        List<Price> prices = repository.search(criteria);

        if(prices.isEmpty())
            throw new PriceNotFoundException(productId, brandId, date);

        if(prices.size() > 1)
            throw new MultiplePriceException(productId, brandId, date);

        return mapper.map(prices.get(0));
    }
}
