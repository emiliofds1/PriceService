package com.emiliofds.prices.infraestructure.persistence.adapter.mapper;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceData;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceDataMapperTest {

  @InjectMocks private PriceDataMapper dbMapper;

  @Test
  void map_shouldReturnPrice() {
    // Arrange
    long productId = 1L;
    long brandId = 2L;
    long priceListId = 3L;
    BigDecimal priceValue = BigDecimal.valueOf(45.58);
    PriceData priceData = new PriceData(productId, brandId, priceListId, priceValue);
    Price expected = Price.ofPrimitives(productId, brandId, priceListId, priceValue);

    // Assert
    var result = dbMapper.map(priceData);
    Assertions.assertEquals(expected, result);
  }
}
