package com.marlonzl7.kon.converters;

import java.util.List;

public class TimeConverter implements Converter {
    private static final List<String> SUPPORTED_CONVERSIONS = List.of(
            "second->minute",
            "second->hour",
            "minute->second",
            "minute->hour",
            "hour->second",
            "hour->minute"
    );

    @Override
    public double convert(String from, String to, double value) {
        return switch (from + "-" + to) {
            case "second-minute" -> value / 60;
            case "second-hour" -> value / 3600;
            case "minute-second" -> value * 60;
            case "minute-hour" -> value / 60;
            case "hour-second" -> value * 3600;
            case "hour-minute" -> value * 60;
            default -> throw new IllegalArgumentException("Conversions from " + from + " to " + to + " is not supported.");
        };
    }

    public static List<String> getSupportedConversions() {
        return SUPPORTED_CONVERSIONS;
    }

    public static String getConversionByIndex(int index) {
        if (index < 0 || index >= SUPPORTED_CONVERSIONS.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return SUPPORTED_CONVERSIONS.get(index);
    }
}
