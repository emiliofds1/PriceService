package com.emiliofds.prices.application.dto;

import java.math.BigDecimal;

public class PriceResponse {

    private final Long productId;

    private final Long brandId;

    private final Long priceListId;

    private final BigDecimal priceValue;

    public PriceResponse(Long productId, Long brandId, Long priceListId, BigDecimal priceValue) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceListId = priceListId;
        this.priceValue = priceValue;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getPriceListId() {
        return priceListId;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceResponse that = (PriceResponse) o;
        return productId.equals(that.productId) &&
                brandId.equals(that.brandId) &&
                priceListId.equals(that.priceListId) &&
                priceValue.equals(that.priceValue);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(productId, brandId, priceListId, priceValue);
    }
}
