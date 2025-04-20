package com.marlonzl7.kon.converters;

import com.marlonzl7.kon.converters.MassConverter;
import java.util.concurrent.ThreadLocalRandom;

public class MassConverterTest {
    public static void main(String[] args) {
        MassConverter converter = new MassConverter();

        System.out.println("----- Valid conversions tests -----");
        for (int i = 0; i < MassConverter.getSupportedConversions().size(); i++) {
            String conversion = MassConverter.getConversionByIndex(i);
            String[] parts = conversion.split("->");
            String from = parts[0];
            String to = parts[1];

            double testValue = ThreadLocalRandom.current().nextDouble(0.1, 1000.0);

            try {
                double result = converter.convert(from, to, testValue);
                System.out.printf("Conversion: %s -> %s | %.2f %s = %.2f %s%n", from, to, testValue, from, result, to);
            } catch (IllegalArgumentException e) {
                System.out.printf("Error during conversion %s -> %s %s%n", from, to, e.getMessage());
            }
        }

        System.out.println("\n----- Invalid conversion tests -----");

        // Case 1: invalid source unit
        testInvalidConversion(converter, "ujasdo", "mililiter", 1.0);

        // Case 2: invalid target unit
        testInvalidConversion(converter, "liter", "sdadfas", 1.0);

        // Case 3: unsupported conversion
        testInvalidConversion(converter, "liter", "hadhdf", 1.0);
    }

    private static void testInvalidConversion(MassConverter converter, String from, String to, double value) {
        try {
            converter.convert(from, to, value);
            System.out.printf("ERROR: Espected failure in %s -> %s, but it successed.%n", from, to);
        } catch (IllegalArgumentException e) {
            System.out.printf("Expected invalid conversion: %s -> %s | Message: %s%n", from, to, e.getMessage());
        }
    }
}
