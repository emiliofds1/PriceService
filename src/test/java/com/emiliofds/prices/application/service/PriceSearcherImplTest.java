package com.emiliofds.prices.application.service;

import static org.mockito.Mockito.when;

import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.service.mapper.PriceResponseMapper;
import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.PriceSearchCriteria;
import com.emiliofds.prices.domain.repository.PriceRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceSearcherImplTest {

  @Mock private PriceRepository repository;

  @Mock private PriceResponseMapper mapper;

  @InjectMocks private PriceSearcherImpl priceSearcher;

  @Test
  void search_shouldReturnPriceResponse() {
    // Arrange
    Long productId = 1L;
    Long brandId = 2L;
    LocalDateTime date = LocalDateTime.now();
    Long priceList = 3L;
    BigDecimal priceValue = BigDecimal.valueOf(875.54f);
    PriceSearchCriteria expectedPriceSearchCriteria =
        PriceSearchCriteria.of(productId, brandId, date);
    Price mockPrice = Price.ofPrimitives(productId, brandId, priceList, priceValue);
    PriceResponse mockResponse = new PriceResponse(productId, brandId, priceList, priceValue);

    // Act
    when(repository.search(expectedPriceSearchCriteria)).thenReturn(Optional.of(mockPrice));
    when(mapper.map(mockPrice)).thenReturn(mockResponse);

    // Assert
    var response = priceSearcher.search(productId, brandId, date);
    Assertions.assertEquals(mockResponse, response);
  }
}
