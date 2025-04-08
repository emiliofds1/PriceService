package com.emiliofds.prices.interfaces.rest.controller;

import com.emiliofds.prices.app.openapi.dto.Error;
import com.emiliofds.prices.domain.exception.InvalidPriceValueException;
import com.emiliofds.prices.domain.exception.MultiplePriceException;
import com.emiliofds.prices.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Error> handle(PriceNotFoundException ex) {
        return createResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(InvalidPriceValueException.class)
    public ResponseEntity<Error> handle(InvalidPriceValueException ex) {
        return createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MultiplePriceException.class)
    public ResponseEntity<Error> handle(MultiplePriceException ex) {
        return createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ResponseEntity<Error> createResponseEntity(HttpStatus status, String message) {
        Error error = new Error();
        error.setCode(status.value());
        error.setMessage(message);

        return ResponseEntity.status(status).body(error);
    }
}
