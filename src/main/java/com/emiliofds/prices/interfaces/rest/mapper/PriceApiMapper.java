package com.emiliofds.prices.interfaces.rest.mapper;

import com.emiliofds.prices.app.openapi.dto.Price;
import com.emiliofds.prices.application.dto.PriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceApiMapper {
    public Price map(PriceResponse priceResponse) {
        Price price = new Price();

        price.setProductId(priceResponse.getProductId());
        price.setBrandId(priceResponse.getBrandId());
        price.setPriceList(priceResponse.getPriceListId());
        price.setPrice(priceResponse.getPriceValue());

        return price;
    }
}
