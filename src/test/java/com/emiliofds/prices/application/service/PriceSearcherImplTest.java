package com.emiliofds.prices.application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class PriceSearcherImplTest {

    @InjectMocks
    private PriceSearcherImpl priceSearcher;

    @Test
    void search_shouldReturnNull() {
        // Arrange
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.now();

        // Assert
        Assertions.assertNull(priceSearcher.search(productId, brandId, date));
    }
}
