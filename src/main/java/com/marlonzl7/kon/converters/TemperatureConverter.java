package com.marlonzl7.kon.converters;

import java.util.List;

public class TemperatureConverter implements Converter {
    private static final List<String> SUPPORTED_CONVERSIONS = List.of(
            "celsius->fahrenheit",
            "fahrenheit->celsius",
            "celsius->kelvin",
            "kelvin->celsius",
            "fahrenheit->kelvin",
            "kelvin->fahrenheit"
    );

    @Override
    public double convert(String from, String to, double value) {
        return switch (from + "-" + to) {
            case "celsius-fahrenheit" -> value * 9 / 5 + 32;
            case "fahrenheit-celsius" -> (value - 32) * 5 / 9;
            case "celsius-kelvin" -> value + 273.15;
            case "kelvin-celsius" -> value - 273.15;
            case "fahrenheit-kelvin" -> (value - 32) * 5 / 9 + 273.15;
            case "kelvin-fahrenheit" -> (value - 273.15) * 9 / 5 + 32;
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
