package com.emiliofds.prices.app.rest.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PriceController.class)
public class PriceControllerTest {

    @Autowired
    private PriceController priceController;

    @Test
    void getPrice_shouldReturnNull() {
        // Arrange

        Long productId = 1L;
        Long brandId = 1L;
        LocalDate date = LocalDate.now();

        // Act

        var result = priceController.getPrice(productId, brandId, date);

        // Assert

        Assertions.assertNull(result);
    }
}
