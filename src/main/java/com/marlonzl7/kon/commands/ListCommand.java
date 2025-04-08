package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.converters.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListCommand implements Command {
    @Override
    public void execute(Map<String, String> arguments) {
        String type = arguments.get("list");

        if (type == null || type.isBlank()) {
            System.err.println("Error: no conversion type specified.");
            System.err.println("Use -l or --list followed by a value");
            System.err.println("Example: kon --list speed");
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
        System.out.println("--- " + type.toUpperCase() + " CONVERSIONS ---");
        for (String conversion : conversions) {
            String[] parts = conversion.split("->");
            if (parts.length == 2) {
                System.out.printf(" - %s to %s%n", parts[0], parts[1]);
            }
        }
    }
}
