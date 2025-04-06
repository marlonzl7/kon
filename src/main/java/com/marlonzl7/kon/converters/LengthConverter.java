package com.marlonzl7.kon.converters;

import java.util.List;
import java.util.Map;

public class LengthConverter implements Converter {
    private static final Map<String, Map<String, Double>> RATES = Map.of(
            "millimeter", Map.of(
                    "centimeter", 0.1,
                    "meter", 0.001,
                    "kilometer", 0.000001
            ),
            "centimeter", Map.of(
                    "millimeter", 10.0,
                    "meter", 0.01,
                    "kilometer", 0.00001
            ),
            "meter", Map.of(
                    "millimeter", 1000.0,
                    "centimeter", 100.0,
                    "kilometer", 0.001
            ),
            "kilometer", Map.of(
                    "millimeter", 1_000_000.0,
                    "centimeter", 100_000.0,
                    "meter", 1000.0
            )
    );

    private static final List<String> SUPPORTED_CONVERSIONS = List.of(
            "millimeter->centimeter",
            "millimeter->meter",
            "millimeter->kilometer",
            "centimeter->millimeter",
            "centimeter->meter",
            "centimeter->kilometer",
            "meter->millimeter",
            "meter->centimeter",
            "meter->kilometer",
            "kilometer->millimeter",
            "kilometer->centimeter",
            "kilometer->meter"
    );

    @Override
    public double convert(String from, String to, double value) {
        if (!RATES.containsKey(from) || !RATES.get(from).containsKey(to)) {
            throw new IllegalArgumentException("Conversion from " + from + " to " + to + " is not supported.");
        }

        return value * RATES.get(from).get(to);
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
