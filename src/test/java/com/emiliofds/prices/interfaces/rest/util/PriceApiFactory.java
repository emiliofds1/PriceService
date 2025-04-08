package com.emiliofds.prices.interfaces.rest.util;

import com.emiliofds.prices.app.openapi.dto.Price;

import java.math.BigDecimal;

public class PriceApiFactory {

    public static Price buildPrice(Long productId, Long brandId, Long priceList, BigDecimal priceValue) {
        Price price = new Price();

        price.setProductId(productId);
        price.setBrandId(brandId);
        price.setPriceList(priceList);
        price.setPrice(priceValue);

        return price;
    }
}
