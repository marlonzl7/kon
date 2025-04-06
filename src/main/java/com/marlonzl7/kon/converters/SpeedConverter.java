package com.marlonzl7.kon.converters;

import java.util.List;

public class SpeedConverter implements Converter {
    private final List<String> supportedConversions = List.of(
            "ms->kmh",
            "ms->mph",
            "kmh->ms",
            "kmh->mph",
            "mph->ms",
            "mph->kmh"
    );

    public double convert(String from, String to, double value) {
        return switch (from + "-" + to) {
            case "ms-kmh" -> value * 3.6;
            case "ms-mph" -> value * 2.237;
            case "kmh-ms" -> value / 3.6;
            case "kmh-mph" -> value / 1.609;
            case "mph-ms" -> value / 2.237;
            case "mph-kmh" -> value * 1.609;
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
