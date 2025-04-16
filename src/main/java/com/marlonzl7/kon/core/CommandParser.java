package com.marlonzl7.kon.core;

import com.marlonzl7.kon.commands.Command;
import com.marlonzl7.kon.commands.CommandFactory;
import com.marlonzl7.kon.utils.ArgumentNormalizer;
import com.marlonzl7.kon.utils.CommandValidator;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    public static void main(String[] args) {
        if (args.length == 0) {
            Command command = CommandFactory.createCommand("help");
            command.execute(null);
            return;
        }

        Map<String, String> rawArgs = parseArgsToMap(args);
        Map<String, String> arguments = ArgumentNormalizer.normalize(rawArgs);
        CommandValidator.validate(arguments);

        if (arguments.containsKey("help")) {
            Command command = CommandFactory.createCommand("help");
            command.execute(arguments);
            return;
        }

        if (arguments.containsKey("list")) {
            Command command = CommandFactory.createCommand("list");
            command.execute(arguments);
            return;
        }

        if (arguments.containsKey("convert")) {
            String type = arguments.get("convert");

            if (type != null) {
                Command command = CommandFactory.createCommand(type);
                command.execute(arguments);
                return;
            }

            throw new IllegalArgumentException("The value of greatness cannot be null.");
        }
    }

    private static Map<String, String> parseArgsToMap(String[] args) {
        Map<String, String> arguments = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (i + 1 < args.length && isValue(args[i + 1])) {
                    arguments.put(args[i], args[i + 1]);
                    i++;
                } else {
                    arguments.put(args[i], "");
                }
            }
        }

        return arguments;
    }

    private static boolean isValue(String arg) {
        return !(arg.startsWith("--") || arg.matches("^-[a-zA-Z]+$"));
    }
}
