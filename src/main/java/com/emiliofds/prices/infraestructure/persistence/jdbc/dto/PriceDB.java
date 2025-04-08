package com.emiliofds.prices.infraestructure.persistence.jdbc.dto;

import java.math.BigDecimal;

public class PriceDB {
    private final long productId;
    private final long brandId;
    private final BigDecimal price;
    private final long priceList;

    public PriceDB(long productId, long brandId, long priceList, BigDecimal price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public long getBrandId() {
        return brandId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getPriceList() {
        return priceList;
    }
}
