package com.emiliofds.prices.interfaces.rest.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class DateFormatter {

    public static LocalDateTime format(String stringDate) {
        return OffsetDateTime.parse(stringDate).toLocalDateTime();
    }
}
