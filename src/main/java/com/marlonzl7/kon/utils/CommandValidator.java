package com.marlonzl7.kon.utils;

import java.util.Map;

public class CommandValidator {

    public static void validate(Map<String, String> args) {
        if (args.containsKey("help")) {
            return;
        }

        if (args.containsKey("list")) {
            String category = args.get("list");

            if (category == null || category.isEmpty()) {
                throw new IllegalArgumentException("Você deve informar uma categoria para listar as conversões");
            }

            return;
        }

        if (args.containsKey("convert")) {
            String category = args.get("convert");

            if (category == null || category.isEmpty()) {
                throw new IllegalArgumentException("Você deve informar a categoria para conversão.");
            }

            if (!args.containsKey("from")) {
                throw new IllegalArgumentException("Você deve informar a unidade de origem com a flag --from, -f, --de ou -d.");
            }

            if (!args.containsKey("to")) {
                throw new IllegalArgumentException("Você deve informar a unidade de destino com a flag --to, -t, --para ou -p.");
            }

            if (!args.containsKey("value")) {
                throw new IllegalArgumentException("Você deve informar o valor a ser convertido com a flag --value, --valor ou -v.");
            }
        }

        if (!args.containsKey("help") &&
            !args.containsKey("list") &&
            !args.containsKey("convert")) {
            throw new IllegalArgumentException("Nenhum comando conhecido foi informado.");
        }
    }

}
