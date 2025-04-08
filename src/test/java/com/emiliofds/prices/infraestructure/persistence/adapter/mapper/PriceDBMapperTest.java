package com.emiliofds.prices.infraestructure.persistence.adapter.mapper;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PriceDBMapperTest {

    @InjectMocks
    private PriceDBMapper dbMapper;

    @Test
    void map_shouldReturnPrice() {
        // Arrange
        long productId = 1L;
        long brandId = 2L;
        long priceListId = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(45.58);
        PriceDB priceDB = new PriceDB(productId, brandId, priceListId, priceValue);
        Price expected = Price.ofPrimitives(productId, brandId, priceListId, priceValue);

        // Assert
        var result = dbMapper.map(priceDB);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void mapList_shouldReturnPrice() {
        // Arrange
        long productId = 1L;
        long brandId = 2L;
        long priceListId = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(45.58f);
        List<PriceDB> priceDBList = List.of(new PriceDB(productId, brandId, priceListId, priceValue));
        List<Price> expectedList = List.of(Price.ofPrimitives(productId, brandId, priceListId, priceValue));

        // Assert
        var result = dbMapper.map(priceDBList);
        Assertions.assertEquals(expectedList, result);
    }
}
