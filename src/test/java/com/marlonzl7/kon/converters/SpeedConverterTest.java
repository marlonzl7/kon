package com.marlonzl7.kon.converters;

import com.marlonzl7.kon.converters.SpeedConverter;
import java.util.concurrent.ThreadLocalRandom;

public class SpeedConverterTest {
    public static void main(String[] args) {
        SpeedConverter converter = new SpeedConverter();

        System.out.println("----- Valid conversions tests -----");
        for (int i = 0; i < converter.getSupportedConversions().size(); i++) {
            String conversion = converter.getConversionByIndex(i);
            String[] parts = conversion.split("->");
            String from = parts[0];
            String to = parts[1];

            double testValue = ThreadLocalRandom.current().nextDouble(0, 10000);

            try {
                double result = converter.convert(from, to, testValue);
                System.out.printf("Conversion: %s -> %s | %.2f %s = %.2f %s%n", from, to, testValue, from, result, to);
            } catch (IllegalArgumentException e) {
                System.out.printf("Error during conversion %s -> %s %s%n", from, to, e.getMessage());
            }
        }

        System.out.println("\n----- Invalid conversion tests -----");

        // Case 1: invalid source unit
        testInvalidConversion(converter, "msahpaos", "mph", 1.0);

        // Case 2: invalid target unit
        testInvalidConversion(converter, "mph", "fdsaosaddf", 1.0);

        // Case 3: unsupported conversion
        testInvalidConversion(converter, "ms", "meter", 1.0);
    }

    private static void testInvalidConversion(SpeedConverter converter, String from, String to, double value) {
        try {
            converter.convert(from, to, value);
            System.out.printf("ERROR: Espected failure in %s -> %s, but it successed.%n", from, to);
        } catch (IllegalArgumentException e) {
            System.out.printf("Expected invalid conversion: %s -> %s | Message: %s%n", from, to, e.getMessage());
        }
    }
}
