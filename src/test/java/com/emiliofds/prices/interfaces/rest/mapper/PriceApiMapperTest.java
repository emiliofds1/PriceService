package com.emiliofds.prices.interfaces.rest.mapper;

import com.emiliofds.prices.app.openapi.dto.Price;
import com.emiliofds.prices.application.dto.PriceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static com.emiliofds.prices.interfaces.rest.util.PriceApiFactory.buildPrice;

@ExtendWith(MockitoExtension.class)
public class PriceApiMapperTest {

    @InjectMocks
    private PriceApiMapper priceApiMapper;

    @Test
    void map_shouldReturnNull() {
        // Arrange
        Long productId = 1L;
        Long brandId = 2L;
        Long productListId = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(452.53f);
        PriceResponse response = new PriceResponse(productId, brandId, productListId, priceValue);
        Price expectedPrice = buildPrice(productId, brandId, productListId, priceValue);

        // Assert
        var result = priceApiMapper.map(response);
        Assertions.assertEquals(expectedPrice, result);
    }
}
