package com.emiliofds.prices.application.service.mapper;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.domain.model.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class PriceResponseMapperTest {

    @InjectMocks
    private PriceResponseMapper mapper;

    @Test
    void map_shouldReturnPriceResponse() {
        // Arrange
        Long productId = 1L;
        Long brandId = 2L;
        Long productListId = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(45258.54f);
        Price price = Price.ofPrimitives(productId, brandId, productListId, priceValue);
        PriceResponse expectedResponse = new PriceResponse(productId, brandId, productListId, priceValue);

        // Assert
        var result = mapper.map(price);
        Assertions.assertEquals(expectedResponse, result);
    }
}
