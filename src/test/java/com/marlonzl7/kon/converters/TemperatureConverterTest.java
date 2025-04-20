package com.marlonzl7.kon.converters;

import com.marlonzl7.kon.converters.TemperatureConverter;

import java.util.concurrent.ThreadLocalRandom;

public class TemperatureConverterTest {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("----- Valid conversions tests -----");
        for (int i = 0; i < TemperatureConverter.getSupportedConversions().size(); i++) {
            String conversion = TemperatureConverter.getConversionByIndex(i);
            String[] parts = conversion.split("->");
            String from = parts[0];
            String to = parts[1];

            double testValue = ThreadLocalRandom.current().nextDouble(-20.0, 100);

            try {
                double result = converter.convert(from, to, testValue);
                System.out.printf("Conversion: %s -> %s | %.0f %s = %.0f %s%n", from, to, testValue, from, result, to);
            } catch (IllegalArgumentException e) {
                System.out.printf("Error during conversion %s -> %s %s%n", from, to, e.getMessage());
            }
        }

        System.out.println("\n----- Invalid conversion tests -----");

        // Case 1: invalid source unit
        testInvalidConversion(converter, "aaaaaaaa", "celsius", 1.0);

        // Case 2: invalid target unit
        testInvalidConversion(converter, "celsius", "bbbbbbbbbbbb", 1.0);

        // Case 3: unsupported conversion (e.g., "fahrenheit" to "meter" is not defined in the map)
        testInvalidConversion(converter, "fahrenheit", "meter", 1.0);
    }

    private static void testInvalidConversion(TemperatureConverter converter, String from, String to, double value) {
        try {
            converter.convert(from, to, value);
            System.out.printf("ERROR: Espected failure in %s -> %s, but it successed.%n", from, to);
        } catch (IllegalArgumentException e) {
            System.out.printf("Expected invalid conversion: %s -> %s | Message: %s%n", from, to, e.getMessage());
        }
    }
}
