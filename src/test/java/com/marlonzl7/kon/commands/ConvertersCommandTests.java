package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.commands.*;

import java.util.HashMap;
import java.util.Map;

public class ConvertersCommandTests {
    public static void main(String[] args) {
        testLengthConvertCommand();
        testMassConvertCommand();
        testSpeedConvertCommand();
        testTemperatureConvertCommand();
        testTimeConvertCommand();
        testVolumeConvertCommand();
    }

    private static void testLengthConvertCommand() {
        System.out.println("== LengthConvertCommand ==");
        Map<String, String> args = new HashMap<>();
        args.put("from", "meter");
        args.put("to", "kilometer");
        args.put("value", "1500");

        new LengthConvertCommand().execute(args);
    }

    private static void testMassConvertCommand() {
        System.out.println("== MassConvertCommand ==");
        Map<String, String> args = new HashMap<>();
        args.put("from", "kilogram");
        args.put("to", "gram");
        args.put("value", "2.5");

        new MassConvertCommand().execute(args);
    }

    private static void testSpeedConvertCommand() {
        System.out.println("== SpeedConvertCommand ==");
        Map<String, String> args = new HashMap<>();
        args.put("from", "kmh");
        args.put("to", "ms");
        args.put("value", "72");

        new SpeedConvertCommand().execute(args);
    }

    private static void testTemperatureConvertCommand() {
        System.out.println("== TemperatureConvertCommand ==");
        Map<String, String> args = new HashMap<>();
        args.put("from", "celsius");
        args.put("to", "fahrenheit");
        args.put("value", "100");

        new TemperatureConvertCommand().execute(args);
    }

    private static void testTimeConvertCommand() {
        System.out.println("== TimeConvertCommand ==");
        Map<String, String> args = new HashMap<>();
        args.put("from", "hour");
        args.put("to", "minute");
        args.put("value", "1.5");

        new TimeConvertCommand().execute(args);
    }

    private static void testVolumeConvertCommand() {
        System.out.println("== VolumeConvertCommand ==");
        Map<String, String> args = new HashMap<>();
        args.put("from", "liter");
        args.put("to", "mililiter");
        args.put("value", "3");

        new VolumeConvertCommand().execute(args);
    }
}
