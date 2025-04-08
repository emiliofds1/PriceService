package com.emiliofds.prices.interfaces.rest.controller;


import com.emiliofds.prices.app.openapi.dto.Price;
import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.port.PriceSearcher;
import com.emiliofds.prices.interfaces.rest.mapper.PriceApiMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static com.emiliofds.prices.interfaces.rest.util.PriceApiFactory.buildPrice;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {

    @Mock
    private PriceSearcher priceSearcher;

    @Mock
    private PriceApiMapper priceApiMapper;

    @InjectMocks
    private PriceController priceController;

    @Test
    void getPrice_shouldReturnPrice() {
        // Arrange
        Long productId = 1L;
        Long brandId = 2L;
        String stringDate = "2021-06-14T10:00:00Z";
        LocalDateTime date = OffsetDateTime.parse(stringDate).toLocalDateTime();
        Long priceListId = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(4525.56f);
        PriceResponse mockResponse = new PriceResponse(productId, brandId, priceListId, priceValue);
        Price mockApiPrice = buildPrice(productId, brandId, priceListId, priceValue);
        Price expectedPrice = buildPrice(productId, brandId, priceListId, priceValue);

        // Act
        when(priceSearcher.search(productId, brandId, date)).thenReturn(mockResponse);
        when(priceApiMapper.map(mockResponse)).thenReturn(mockApiPrice);
        var result = priceController.getPrice(productId, brandId, stringDate);

        // Assert
        Assertions.assertEquals(ResponseEntity.ok().body(expectedPrice), result);
    }


}
