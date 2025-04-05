package com.marlonzl7.kon.converters;

import java.util.List;

public class TemperatureConverter implements Converter {
    private final List<String> supportedConversions = List.of(
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

    public List<String> getSupportedConversions() {
        return supportedConversions;
    }

    public String getConversionByIndex(int index) {
        if (index < 0 || index >= supportedConversions.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return supportedConversions.get(index);
    }
}
