package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.converters.*;
import com.marlonzl7.kon.utils.TranslationHelper;

import java.util.List;
import java.util.Map;

public class ListCommand implements Command {
    @Override
    public void execute(Map<String, String> arguments) {
        String type = arguments.get("list");

        if (type == null || type.trim().isEmpty()) {
            printAvailableCategories();
            return;
        }

        type = type.trim().toLowerCase();

        switch (type) {
            case "length" -> printSupportedConverions("Length", LengthConverter.getSupportedConversions());
            case "mass" -> printSupportedConverions("Mass", MassConverter.getSupportedConversions());
            case "speed" -> printSupportedConverions("Speed", SpeedConverter.getSupportedConversions());
            case "temperature" -> printSupportedConverions("Temperature", TemperatureConverter.getSupportedConversions());
            case "time" -> printSupportedConverions("Time", TimeConverter.getSupportedConversions());
            case "volume" -> printSupportedConverions("Volume", VolumeConverter.getSupportedConversions());
            default -> throw new IllegalArgumentException("Invalid argument");
        }
    }

    private void printSupportedConverions(String type, List<String> conversions) {
        type = type.trim().toLowerCase();
        System.out.printf("-------- %s --------%n", TranslationHelper.translateCategory(type).toUpperCase());
        for (String conversion : conversions) {
            String[] parts = conversion.split("->");
            if (parts.length == 2) {
                System.out.printf(" - %s -> %s%n", TranslationHelper.translateUnit(parts[0]), TranslationHelper.translateUnit(parts[1]));
            }
        }
    }

    private void printAvailableCategories() {
        System.out.println("Grandezas disponíveis para conversão:");
        System.out.println(" - Comprimento");
        System.out.println(" - Massa");
        System.out.println(" - Velocidade");
        System.out.println(" - Temperatura");
        System.out.println(" - Tempo");
        System.out.println(" - Volume");
    }
}
