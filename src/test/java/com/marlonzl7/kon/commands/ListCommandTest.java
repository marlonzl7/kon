package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.commands.ListCommand;

import java.util.HashMap;
import java.util.Map;

public class ListCommandTest {
    public static void main(String[] args) {
        ListCommand listCommand = new ListCommand();

        System.out.println("----- Test1: test with valid argument (-l) -----");
        Map<String, String> arguments1 = new HashMap<>();
        arguments1.put("-l", "volume");
        listCommand.execute(arguments1);

        System.out.println("----- Test2: test with valid argument (--list) -----");
        Map<String, String> arguments2 = new HashMap<>();
        arguments2.put("--list", "mass");
        listCommand.execute(arguments2);

        System.out.println("----- Test3: test with invalid argument -----");
        Map<String, String> arguments3 = new HashMap<>();
        arguments3.put("--list", "jslakçdf");
        try {
            listCommand.execute(arguments3);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("----- Test4: test no argument -----");
        Map<String, String> arguments4 = new HashMap<>();
        try {
            listCommand.execute(arguments4);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("----- Test5: test no argument -----");
        Map<String, String> arguments5 = new HashMap<>();
        arguments5.put("--list", "   ");
        try {
            listCommand.execute(arguments5);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
