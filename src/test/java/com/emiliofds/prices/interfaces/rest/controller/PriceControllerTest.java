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
        LocalDateTime date = LocalDateTime.now();
        Long priceList = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(24.99);
        PriceResponse mockResponse = new PriceResponse();
        Price expectedPrice = buildPrice(productId, brandId, priceList, priceValue);

        // Act
        when(priceSearcher.search(productId, brandId, date)).thenReturn(mockResponse);
        when(priceApiMapper.map(mockResponse)).thenReturn(expectedPrice);
        var result = priceController.getPrice(productId, brandId, date.toString());

        // Assert
        Assertions.assertEquals(ResponseEntity.ok().body(expectedPrice), result);
    }

    private Price buildPrice(Long productId, Long brandId, Long priceList, BigDecimal priceValue) {
        Price price = new Price();

        price.setProductId(productId);
        price.setBrandId(brandId);
        price.setPriceList(priceList);
        price.setPrice(priceValue);

        return price;
    }
}
