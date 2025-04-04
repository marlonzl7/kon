package com.marlonzl7.kon.converters;

import com.marlonzl7.kon.converters.LengthConverter;

public class LengthConverterTest {
    public static void main(String[] args) {
        LengthConverter converter = new LengthConverter();

        double result1 = converter.convert("metro", "centimetro", 2);
        System.out.println("2 metros em cm: " + result1);

        double result2 = converter.convert("quilometro", "metro", 1.5);
        System.out.println("1.5 km em metros: " + result2); // Esperado: 1500.0

        // Teste de erro
        try {
            converter.convert("metro", "grama", 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
