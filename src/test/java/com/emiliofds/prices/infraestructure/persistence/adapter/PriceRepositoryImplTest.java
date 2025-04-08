package com.emiliofds.prices.infraestructure.persistence.adapter;

import com.emiliofds.prices.domain.model.Price;
import com.emiliofds.prices.domain.model.SearchCriteria;
import com.emiliofds.prices.infraestructure.persistence.adapter.mapper.PriceDBMapper;
import com.emiliofds.prices.infraestructure.persistence.jdbc.PriceJDBCRepository;
import com.emiliofds.prices.infraestructure.persistence.jdbc.dto.PriceDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceRepositoryImplTest {

    @InjectMocks
    private PriceRepositoryImpl repository;

    @Mock
    private PriceJDBCRepository jdbcRepository;

    @Mock
    private PriceDBMapper dbMapper;

    @Test
    void search_shouldReturnPriceList() {
        // Arrange
        long productId = 1L;
        long brandId = 2L;
        LocalDateTime date = LocalDateTime.now();
        long priceList = 3L;
        BigDecimal priceValue = BigDecimal.valueOf(453.86f);
        SearchCriteria searchCriteria = SearchCriteria.of(productId, brandId, date);
        List<PriceDB> mockPriceDBList = List.of(new PriceDB(productId, brandId, priceList, priceValue));
        List<Price> mockPriceList = List.of(Price.ofPrimitives(productId, brandId, priceList, priceValue));

        // Act
        when(jdbcRepository.findFilteredPrice(productId, brandId, date.toString())).thenReturn(mockPriceDBList);
        when(dbMapper.map(mockPriceDBList)).thenReturn(mockPriceList);

        // Assert
        var result = repository.search(searchCriteria);
        Assertions.assertEquals(mockPriceList, result);
    }
}
