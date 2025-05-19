package com.emiliofds.prices.domain.exception;

/**
 * Exception thrown when the parameters for search request are considered invalid according to the
 * business rules.
 */
public class InvalidSearchCriteriaException extends DomainException {

  /**
   * Creates a InvalidSearchCriteriaException with a message.
   *
   * @param message the exception message
   */
  public InvalidSearchCriteriaException(String message) {
    super(message);
  }
}
