package com.emiliofds.prices.interfaces.rest.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/** Utility class for formatting date strings into {@link LocalDateTime} instances. */
public class DateFormatter {

  private DateFormatter() {}

  /**
   * Converts an ISO-8601 formatted date with offset string to a {@code LocalDateTime}.
   *
   * @param stringDate the string date in ISO-8601 with offset
   * @return a {@code LocalDateTime} representing the given date
   * @throws java.time.format.DateTimeParseException if the string cannot be parsed
   */
  public static LocalDateTime format(String stringDate) {
    return OffsetDateTime.parse(stringDate).toLocalDateTime();
  }
}
