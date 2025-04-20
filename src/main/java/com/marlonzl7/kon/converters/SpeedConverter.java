package com.marlonzl7.kon.converters;

import com.marlonzl7.kon.utils.TranslationHelper;

import java.util.List;

public class SpeedConverter implements Converter {
    private static final List<String> SUPPORTED_CONVERSIONS = List.of(
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
            default -> throw new IllegalArgumentException(String.format("Conversão de %s para %s não é suportada", TranslationHelper.translateUnit(from), TranslationHelper.translateUnit(to)));
        };
    }

    public static List<String> getSupportedConversions() {
        return SUPPORTED_CONVERSIONS;
    }

    public static String getConversionByIndex(int index) {
        if (index < 0 || index >= SUPPORTED_CONVERSIONS.size()) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }

        return SUPPORTED_CONVERSIONS.get(index);
    }
}
