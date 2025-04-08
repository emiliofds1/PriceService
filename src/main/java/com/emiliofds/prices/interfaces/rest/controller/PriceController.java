package com.emiliofds.prices.interfaces.rest.controller;


import com.emiliofds.prices.app.openapi.controller.PriceApi;
import com.emiliofds.prices.app.openapi.dto.Price;
import com.emiliofds.prices.application.dto.PriceResponse;
import com.emiliofds.prices.application.port.PriceSearcher;
import com.emiliofds.prices.interfaces.rest.mapper.PriceApiMapper;
import com.emiliofds.prices.interfaces.rest.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController implements PriceApi {

    private final PriceSearcher priceSearcher;

    private final PriceApiMapper priceApiMapper;

    @Autowired
    public PriceController(PriceSearcher priceSearcher, PriceApiMapper priceApiMapper) {
        this.priceSearcher = priceSearcher;
        this.priceApiMapper = priceApiMapper;
    }
    @Override
    public ResponseEntity<Price> getPrice(Long productId, Long brandId, String date) {
        PriceResponse response = priceSearcher.search(productId,brandId, DateFormatter.format(date));

        return ResponseEntity.ok().body(priceApiMapper.map(response));
    }
}
