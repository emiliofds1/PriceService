package com.emiliofds.prices.app.rest.controller;


import com.emiliofds.prices.app.openapi.controller.PriceApi;
import com.emiliofds.prices.app.openapi.dto.Price;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class PriceController implements PriceApi {
    @Override
    public ResponseEntity<Price> getPrice(Long productId, Long brandId, LocalDate date) {
        return null;
    }
}
