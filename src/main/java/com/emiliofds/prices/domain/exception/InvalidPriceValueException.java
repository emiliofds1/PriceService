package com.emiliofds.prices.domain.exception;

/** Exception thrown when a price value is considered invalid according to the business rules. */
public class InvalidPriceValueException extends DomainException {

  /**
   * Creates a InvalidPriceValueException with a message.
   *
   * @param message the exception message
   */
  public InvalidPriceValueException(String message) {
    super(message);
  }
}
