package com.marlonzl7.kon.converters;

import com.marlonzl7.kon.converters.LengthConverter;

import java.util.concurrent.ThreadLocalRandom;

public class LengthConverterTest {
    public static void main(String[] args) {
        LengthConverter converter = new LengthConverter();

        System.out.println("----- Valid conversions tests -----");
        for (int i = 0; i < converter.getSupportedConversions().size(); i++) {
            String conversion = converter.getConversionByIndex(i);
            String[] parts = conversion.split("->");
            String from = parts[0];
            String to = parts[1];

            double testValue = ThreadLocalRandom.current().nextDouble(0.1, 1000.0);

            try {
                double result = converter.convert(from, to, testValue);
                System.out.printf("Conversion: %s -> %s | %f %s = %f %s%n", from, to, testValue, from, result, to);
            } catch(IllegalArgumentException e) {
                System.out.printf("Error during conversion %s -> %s %s%n", from, to, e.getMessage());
            }
        }

        System.out.println("\n----- Invalid conversion tests -----");

        // Caso 1: invalid source unit
        testInvalidConversion(converter, "banana", "meter", 1.0);

        // Caso 2: invalid target unit
        testInvalidConversion(converter, "meter", "abacate", 1.0);

        // Caso 3: unsupported conversion (e.g., "meter" to "gram" is not defined in the map)
        testInvalidConversion(converter, "meter", "gram", 1.0);
    }

    private static void testInvalidConversion(LengthConverter converter, String from, String to, double value) {
        try {
            converter.convert(from, to, value);
            System.out.printf("ERROR: Espected failure in %s -> %s, but it successed.%n", from, to);
        } catch (IllegalArgumentException e) {
            System.out.printf("Expected invalid conversion: %s -> %s | Message: %s%n", from, to, e.getMessage());
        }
    }
}
