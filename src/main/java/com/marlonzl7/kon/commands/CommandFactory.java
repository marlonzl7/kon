package com.marlonzl7.kon.commands;

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
            case "version" -> new VersionCommand();
            default -> throw new IllegalArgumentException("Comando desconhecido.");
        };
    }
}
