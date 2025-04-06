package com.marlonzl7.kon.converters;

import java.util.List;

public class TimeConverter implements Converter {
    private static final List<String> SUPPORTED_CONVERSIONS = List.of(
            "seconds->minutes",
            "seconds->hours",
            "minutes->seconds",
            "minutes->hours",
            "hours->seconds",
            "hours->minutes"
    );

    @Override
    public double convert(String from, String to, double value) {
        return switch (from + "-" + to) {
            case "seconds-minutes" -> value / 60;
            case "seconds-hours" -> value / 3600;
            case "minutes-seconds" -> value * 60;
            case "minutes-hours" -> value / 60;
            case "hours-seconds" -> value * 3600;
            case "hours-minutes" -> value * 60;
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
