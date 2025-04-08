package com.emiliofds.prices.application.service;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.service.mapper.PriceResponseMapper;
import com.emiliofds.prices.domain.exception.MultiplePriceException;
import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.SearchCriteria;
import com.emiliofds.prices.domain.repository.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceSearcherImplTest {

     @Mock
     private PriceRepository repository;

     @Mock
     private PriceResponseMapper mapper;

    @InjectMocks
    private PriceSearcherImpl priceSearcher;

    @Test
    void search_shouldReturnPriceResponse() {
        // Arrange
        Long productId = 1L;
        Long brandId = 2L;
        LocalDateTime date = LocalDateTime.now();
        Long priceList = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(875.54f);
        SearchCriteria expectedSearchCriteria = SearchCriteria.of(productId, brandId, date);
        Price mockPrice = Price.ofPrimitives(productId,brandId, priceList, priceValue);
        PriceResponse mockResponse = new PriceResponse(productId,brandId, priceList, priceValue);

        // Act
        when(repository.search(expectedSearchCriteria)).thenReturn(List.of(mockPrice));
        when(mapper.map(mockPrice)).thenReturn(mockResponse);

        // Assert
        var response = priceSearcher.search(productId, brandId, date);
        Assertions.assertEquals(mockResponse, response);
    }

    @Test
    void search_givenMultiplePricesOnSearch_shouldThrowMultiplePRiceException() {
        // Arrange
        Long productId = 1L;
        Long brandId = 2L;
        LocalDateTime date = LocalDateTime.now();
        Long priceList = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(875.54f);
        SearchCriteria expectedSearchCriteria = SearchCriteria.of(productId, brandId, date);
        Price mockPrice = Price.ofPrimitives(productId,brandId, priceList, priceValue);

        // Act
        when(repository.search(expectedSearchCriteria)).thenReturn(List.of(mockPrice, mockPrice));

        // Assert
        var response = catchThrowable(() -> priceSearcher.search(productId, brandId, date));
        Assertions.assertInstanceOf(MultiplePriceException.class, response);
    }
}
