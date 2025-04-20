package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.converters.Converter;
import com.marlonzl7.kon.converters.TimeConverter;
import com.marlonzl7.kon.utils.TranslationHelper;

import java.util.Map;

public class TimeConvertCommand implements Command {
    @Override
    public void execute(Map<String, String> arguments) {
        String from = arguments.get("from");
        String to = arguments.get("to");
        double value = Double.parseDouble(arguments.get("value"));

        Converter converter = new TimeConverter();
        double result = converter.convert(from, to, value);

        System.out.printf("Resultado: %.2f %s -> %.2f %s%n", value, TranslationHelper.translateUnit(from), result, TranslationHelper.translateUnit(to));
    }
}
