package com.emiliofds.prices.interfaces.rest.mapper;

import com.emiliofds.prices.application.dto.PriceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PriceApiMapperTest {

    @InjectMocks
    private PriceApiMapper priceApiMapper;

    @Test
    void map_shouldReturnNull() {
        // Arrange
        PriceResponse response = new PriceResponse();

        // Assert
        var result = priceApiMapper.map(response);
        Assertions.assertNull(result);
    }
}
