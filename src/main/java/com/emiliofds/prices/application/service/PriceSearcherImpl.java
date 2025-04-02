package com.emiliofds.prices.application.service;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.port.PriceSearcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceSearcherImpl implements PriceSearcher {
    @Override
    public PriceResponse search(Long productId, Long brandId, LocalDateTime date) {
        return null;
    }
}
