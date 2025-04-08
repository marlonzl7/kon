package com.marlonzl7.kon.utils;

import java.util.HashMap;
import java.util.Map;

public class ArgumentNormalizer {
    private static final Map<String, String> aliasMap = new HashMap<>();

    static {
        aliasMap.put("-h", "help");
        aliasMap.put("--help", "help");

        aliasMap.put("-l", "list");
        aliasMap.put("--list", "list");

        aliasMap.put("-c", "convert");
        aliasMap.put("--convert", "convert");

        aliasMap.put("-f", "from");
        aliasMap.put("--from", "from");

        aliasMap.put("-t", "to");
        aliasMap.put("--to", "to");

        aliasMap.put("-v", "value");
        aliasMap.put("--value", "value");
    }

    public static Map<String, String> normalize(Map<String, String> rawArgs) {
        Map<String, String> normalized = new HashMap<>();

        for (Map.Entry<String, String> entry : rawArgs.entrySet()) {
            String key = aliasMap.getOrDefault(entry.getKey(), entry.getKey());
            normalized.put(key, entry.getValue());
        }

        return normalized;
    }
}
