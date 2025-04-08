package com.emiliofds.prices.application.port;

import com.emiliofds.prices.application.dto.PriceResponse;

import java.time.LocalDateTime;

public interface PriceSearcher {
    PriceResponse search(Long productId, Long brandId, LocalDateTime date);
}
