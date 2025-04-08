package com.emiliofds.prices.domain.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends DomainException {
    public PriceNotFoundException(Long productId, Long brandId, LocalDateTime date) {
        super(String.format("No price found for product %d, brand %d on date %s",
                productId, brandId, date));
    }
}
