package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.converters.Converter;
import com.marlonzl7.kon.converters.SpeedConverter;

import java.util.Map;

public class SpeedConvertCommand implements Command {
    @Override
    public void execute(Map<String, String> arguments) {
        String from = arguments.get("from");
        String to = arguments.get("to");
        double value = Double.parseDouble(arguments.get("value"));

        Converter converter = new SpeedConverter();
        double result = converter.convert(from, to, value);

        System.out.printf("Resultado: %.2f %s -> %.2f %s%n", value, from, result, to);
    }
}
