package com.marlonzl7.kon.commands;

import java.util.Map;

public class CommandFactory {
    public static Command createCommand(String command) {
        return switch (command) {
            case "list" -> new ListCommand();
            case "help" -> new HelpCommand();
            case "length" -> new LengthConvertCommand();
            case "mass" -> new MassConvertCommand();
            case "speed" -> new SpeedConvertCommand();
            case "temperature" -> new TemperatureConvertCommand();
            case "time" -> new TimeConvertCommand();
            case "volume" -> new VolumeConvertCommand();
            default -> throw new IllegalArgumentException("Unknown command.");
        };
    }
}
