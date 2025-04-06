package com.marlonzl7.kon.converters;

import java.util.List;
import java.util.Map;

public class VolumeConverter implements Converter {
    private static final Map<String, Map<String, Double>> RATES = Map.of(
            "mililiter", Map.of(
                    "liter", 0.001
            ),
            "liter", Map.of(
                    "mililiter", 1000.0
            )
    );

    private static final List<String> SUPPORTED_CONVERSIONS = List.of(
            "mililiter->liter",
            "liter->mililiter"
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
