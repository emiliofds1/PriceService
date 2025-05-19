package com.emiliofds.prices.infraestructure.persistence.adapter;

import static org.mockito.Mockito.when;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.PriceSearchCriteria;
import com.emiliofds.prices.infraestructure.persistence.adapter.mapper.PriceDataMapper;
import com.emiliofds.prices.infraestructure.persistence.jdbc.PriceJdbcRepository;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceData;
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
class PriceRepositoryImplTest {

  @InjectMocks private PriceRepositoryImpl repository;

  @Mock private PriceJdbcRepository jdbcRepository;

  @Mock private PriceDataMapper dbMapper;

  @Test
  void search_shouldReturnPriceList() {
    // Arrange
    long productId = 1L;
    long brandId = 2L;
    LocalDateTime date = LocalDateTime.now();
    long priceList = 3L;
    BigDecimal priceValue = BigDecimal.valueOf(453.86f);
    PriceSearchCriteria priceSearchCriteria = PriceSearchCriteria.of(productId, brandId, date);
    PriceData mockPriceData = new PriceData(productId, brandId, priceList, priceValue);
    Price mockPrice = Price.ofPrimitives(productId, brandId, priceList, priceValue);
    Optional<Price> mockOptionalPrice = Optional.of(mockPrice);

    // Act
    when(jdbcRepository.findFilteredPrice(productId, brandId, date.toString()))
        .thenReturn(Optional.of(mockPriceData));
    when(dbMapper.map(mockPriceData)).thenReturn(mockPrice);

    // Assert
    var result = repository.search(priceSearchCriteria);
    Assertions.assertEquals(mockOptionalPrice, result);
  }
}
