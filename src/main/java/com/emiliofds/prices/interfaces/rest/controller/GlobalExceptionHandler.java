package com.emiliofds.prices.interfaces.rest.controller;

import com.emiliofds.prices.app.openapi.dto.PriceNotFoundError;
import com.emiliofds.prices.domain.exceptions.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<PriceNotFoundError> handle(PriceNotFoundException ex) {
        PriceNotFoundError body = new PriceNotFoundError();
        body.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
