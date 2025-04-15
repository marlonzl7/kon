package com.marlonzl7.kon.utils;

import java.util.Map;

public class TranslationHelper {
    private static final Map<String, String> unitTranslations = Map.ofEntries(
            Map.entry("millimiter", "milímetro"),
            Map.entry("centimeter", "centímetro"),
            Map.entry("meter", "metro"),
            Map.entry("kilometer", "quilômetro"),
            Map.entry("gram", "grama"),
            Map.entry("kilogram", "quilograma"),
            Map.entry("ms", "ms"),
            Map.entry("kmh", "kmh"),
            Map.entry("mph", "mph"),
            Map.entry("celsius", "celsius"),
            Map.entry("fahrenheit", "fahrenheit"),
            Map.entry("kelvin", "kelvin"),
            Map.entry("second", "segundo"),
            Map.entry("minute", "minuto"),
            Map.entry("hour", "hora"),
            Map.entry("mililiter", "mililitro"),
            Map.entry("liter", "litro")
    );

    private static final Map<String, String> categoryTranslations = Map.ofEntries(
            Map.entry("length", "comprimento"),
            Map.entry("mass", "massa"),
            Map.entry("speed", "velocidade"),
            Map.entry("temperature", "temperatura"),
            Map.entry("time", "tempo"),
            Map.entry("volume", "volume")
    );

    public static String translateUnit(String unit) {
        return unitTranslations.getOrDefault(unit, unit);
    }

    public static String translateCategory(String category) {
        return categoryTranslations.getOrDefault(category, category);
    }
}
