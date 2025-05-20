package com.emiliofds.prices.domain.model.valueobject;

/**
 * Abstract base class representing a primitive value object for identifiers based on {@link Long}.
 *
 * <p>This class is intended to be extended by other ID classes to ensure strong typing and
 * encapsulation of identifiers throughout the domain model.
 *
 * <p>Implements {@code equals} and {@code hashCode} base on the identifier value to maintain
 * semantic.
 */
public abstract class LongId {

  protected final Long value;

  /**
   * Protected constructor for a LongId.
   *
   * @param value the value of the id
   */
  protected LongId(Long value) {
    this.value = value;
  }

  /**
   * Retrieves the value of the identifier.
   *
   * @return the identifier value
   */
  public Long getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LongId longId = (LongId) o;
    return value.equals(longId.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }
}
