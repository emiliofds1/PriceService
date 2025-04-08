package com.emiliofds.prices.domain.model;

import com.emiliofds.prices.domain.model.valueObject.BrandId;
import com.emiliofds.prices.domain.model.valueObject.PriceListId;
import com.emiliofds.prices.domain.model.valueObject.PriceValue;
import com.emiliofds.prices.domain.model.valueObject.ProductId;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {

    private final ProductId productId;

    private final BrandId brandId;

    private final PriceListId priceListId;

    private final PriceValue price;

    private Price(ProductId productId, BrandId brandId, PriceListId priceListId, PriceValue price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceListId = priceListId;
        this.price = price;
    }

    public static Price ofPrimitives(Long productId, Long brandId, Long priceList, BigDecimal price) {
        return new Price(new ProductId(productId), new BrandId(brandId), new PriceListId(priceList), new PriceValue(price));
    }

    public ProductId getProductId() {
        return productId;
    }

    public BrandId getBrandId() {
        return brandId;
    }

    public PriceListId getPriceListId() {
        return priceListId;
    }

    public PriceValue getPriceValue() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return productId.equals(price1.productId) &&
                brandId.equals(price1.brandId) &&
                priceListId.equals(price1.priceListId) &&
                price.equals(price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, priceListId, price);
    }
}
