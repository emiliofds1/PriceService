package com.emiliofds.prices.domain.exception;

import java.time.LocalDateTime;

public class MultiplePriceException extends DomainException {

    public MultiplePriceException(Long productId, Long brandId, LocalDateTime date) {
        super(String.format("Multiple prices found for productId: %d, brandId: %d, at date: %s", productId, brandId, date));
    }
}
