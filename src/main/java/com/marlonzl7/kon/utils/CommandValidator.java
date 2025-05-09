package com.marlonzl7.kon.utils;

import java.util.Map;

public class CommandValidator {

    public static void validate(Map<String, String> args) {
        if (args.containsKey("help")) {
            return;
        }

        if (args.containsKey("list")) {
            return;
        }

        if (args.containsKey("convert")) {
            String category = args.get("convert");

            if (category == null || category.isEmpty()) {
                throw new IllegalArgumentException("Você deve informar a grandeza para conversão.");
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

        if (args.containsKey("version")) {
            return;
        }

        if (!args.containsKey("help") &&
            !args.containsKey("list") &&
            !args.containsKey("convert") &&
            !args.containsKey("version")) {
            throw new IllegalArgumentException("Nenhum comando conhecido foi informado.");
        }
    }

}
