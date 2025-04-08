package com.emiliofds.prices.application.service.mapper;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.domain.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceResponseMapper {

    public PriceResponse map(Price price) {
        return new PriceResponse(price.getProductId().getValue(),
                price.getBrandId().getValue(),
                price.getPriceListId().getValue(),
                price.getPriceValue().value());
    }
}
