package com.emiliofds.prices.domain.exceptions;

import java.time.LocalDate;

public class PriceNotFoundException extends DomainException {
    public PriceNotFoundException(Long productId, Long brandId, LocalDate date) {
        super(String.format("No price found for product %d, brand %d on date %s",
                productId, brandId, date));
    }
}
