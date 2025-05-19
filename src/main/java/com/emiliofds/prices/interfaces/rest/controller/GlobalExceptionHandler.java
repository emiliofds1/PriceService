package com.emiliofds.prices.interfaces.rest.controller;

import com.emiliofds.prices.app.openapi.dto.Error;
import com.emiliofds.prices.domain.exception.InvalidPriceValueException;
import com.emiliofds.prices.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** Compiling class with all exception handlers for all HTTP controllers. */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * retrieves 404 response with the exception message on {@link PriceNotFoundException}.
   *
   * @param ex the domain exception
   * @return the error response
   */
  @ExceptionHandler(PriceNotFoundException.class)
  public ResponseEntity<Error> handle(PriceNotFoundException ex) {
    return createResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  /**
   * retrieves 500 response with the exception message on {@link InvalidPriceValueException}.
   *
   * @param ex the domain exception
   * @return the error response
   */
  @ExceptionHandler(InvalidPriceValueException.class)
  public ResponseEntity<Error> handle(InvalidPriceValueException ex) {
    return createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
  }

  private ResponseEntity<Error> createResponseEntity(HttpStatus status, String message) {
    Error error = new Error();
    error.setCode(status.value());
    error.setMessage(message);

    return ResponseEntity.status(status).body(error);
  }
}
