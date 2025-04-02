package com.emiliofds.prices.interfaces.rest.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static LocalDateTime format(String stringDate) {
        return LocalDateTime.parse(stringDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
