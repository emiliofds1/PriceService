package com.emiliofds.prices.domain.exception;

/**
 * Base domain exception for business errors in the domain layer.
 *
 * <p>Extends {@link RuntimeException} to represent unchecked exceptions related to domain rules and
 * invariants.
 */
public class DomainException extends RuntimeException {

  /**
   * Creates a new {@code DomainException} with the given message.
   *
   * @param message the detail message for this exception
   */
  public DomainException(String message) {
    super(message);
  }
}
