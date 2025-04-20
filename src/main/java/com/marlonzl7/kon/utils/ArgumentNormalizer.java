package com.marlonzl7.kon.utils;

import java.util.HashMap;
import java.util.Map;

public class ArgumentNormalizer {
    private static final Map<String, String> flagAliasMap = new HashMap<>();
    private static final Map<String, String> categoryAliasMap = new HashMap<>();
    private static final Map<String, Map<String, String>> unitAliasMap = new HashMap<>();

    static {
        // --- FLAGS ---
        flagAliasMap.put("-h", "help");
        flagAliasMap.put("--help", "help");

        flagAliasMap.put("-l", "list");
        flagAliasMap.put("--list", "list");
        flagAliasMap.put("--listar", "list");

        flagAliasMap.put("-c", "convert");
        flagAliasMap.put("--convert", "convert");
        flagAliasMap.put("--converter", "convert");

        flagAliasMap.put("-f", "from");
        flagAliasMap.put("--from", "from");
        flagAliasMap.put("-d", "from");
        flagAliasMap.put("--de", "from");

        flagAliasMap.put("-t", "to");
        flagAliasMap.put("--to", "to");
        flagAliasMap.put("-p", "to");
        flagAliasMap.put("--para", "to");

        flagAliasMap.put("-v", "value");
        flagAliasMap.put("--value", "value");
        flagAliasMap.put("--valor", "value");

        flagAliasMap.put("--version", "version");
        flagAliasMap.put("-version", "version");

        // --- CATEGORIES
        categoryAliasMap.put("len", "length");
        categoryAliasMap.put("length", "length");
        categoryAliasMap.put("comprimento", "length");

        categoryAliasMap.put("mass", "mass");
        categoryAliasMap.put("massa", "mass");

        categoryAliasMap.put("speed", "speed");
        categoryAliasMap.put("velocidade", "speed");

        categoryAliasMap.put("temp", "temperature");
        categoryAliasMap.put("temperature", "temperature");
        categoryAliasMap.put("temperatura", "temperature");

        categoryAliasMap.put("time", "time");
        categoryAliasMap.put("tempo", "time");

        categoryAliasMap.put("vol", "volume");
        categoryAliasMap.put("volume", "volume");

        // --- UNITS BY CATEGORY ---
        unitAliasMap.put("length", Map.ofEntries(
                Map.entry("millimeter", "millimeter"),
                Map.entry("mm", "millimeter"),
                Map.entry("milímetro", "millimeter"),
                Map.entry("centimeter", "centimeter"),
                Map.entry("cm", "centimeter"),
                Map.entry("centimetro", "centimeter"),
                Map.entry("meter", "meter"),
                Map.entry("m", "meter"),
                Map.entry("metro", "meter"),
                Map.entry("kilometer", "kilometer"),
                Map.entry("km", "kilometer"),
                Map.entry("quilometro", "kilometer")
        ));

        unitAliasMap.put("mass", Map.ofEntries(
                Map.entry("gram", "gram"),
                Map.entry("g", "gram"),
                Map.entry("grama", "gram"),
                Map.entry("kilogram", "kilogram"),
                Map.entry("kg", "kilogram"),
                Map.entry("quilograma", "kilogram")
        ));

        unitAliasMap.put("speed", Map.ofEntries(
                Map.entry("ms", "ms"),
                Map.entry("kmh", "kmh"),
                Map.entry("mph", "mph")
        ));

        unitAliasMap.put("temperature", Map.ofEntries(
                Map.entry("celsius", "celsius"),
                Map.entry("C", "celsius"),
                Map.entry("c", "celsius"),
                Map.entry("fahrenheit", "fahrenheit"),
                Map.entry("F", "fahrenheit"),
                Map.entry("f", "fahrenheit"),
                Map.entry("kelvin", "kelvin"),
                Map.entry("K", "kelvin"),
                Map.entry("k", "kelvin")
        ));

        unitAliasMap.put("time", Map.ofEntries(
                Map.entry("second", "second"),
                Map.entry("s", "second"),
                Map.entry("minute", "minute"),
                Map.entry("min", "minute"),
                Map.entry("m", "minute"),
                Map.entry("hour", "hour"),
                Map.entry("h", "hour")
        ));

        unitAliasMap.put("volume", Map.ofEntries(
                Map.entry("mililiter", "mililiter"),
                Map.entry("mililitro", "mililiter"),
                Map.entry("ml", "mililiter"),
                Map.entry("liter", "liter"),
                Map.entry("litro", "liter"),
                Map.entry("l", "liter")
        ));
    }

    public static Map<String, String> normalize(Map<String, String> rawArgs) {
        Map<String, String> normalized = new HashMap<>();

        for (Map.Entry<String, String> entry : rawArgs.entrySet()) {
            String rawKey = entry.getKey();
            String rawValue = entry.getValue();

            String key = flagAliasMap.getOrDefault(rawKey, rawKey);

            if (rawValue.isEmpty()) {
                normalized.put(key, "");
                continue;
            }

            String value = rawValue;

            if (key.equals("list") || key.equals("convert")) {
                value = categoryAliasMap.getOrDefault(rawValue, rawValue);
            }

            normalized.put(key, value);
        }

        String category = normalized.get("convert");

        if (category != null && unitAliasMap.containsKey(category)) {
            Map<String, String> unitMap = unitAliasMap.get(category);

            if (normalized.containsKey("from")) {
                String fromRaw = normalized.get("from").toLowerCase();
                String normalizedFrom = unitMap.getOrDefault(fromRaw, fromRaw);
                normalized.put("from", normalizedFrom);
            }

            if (normalized.containsKey("to")) {
                String toRaw = normalized.get("to").toLowerCase();
                String normalizedTo = unitMap.getOrDefault(toRaw, toRaw);
                normalized.put("to", normalizedTo);
            }
        }

        return normalized;
    }
}
