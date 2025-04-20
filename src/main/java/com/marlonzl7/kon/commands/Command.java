package com.marlonzl7.kon.commands;

import java.util.Map;

public interface Command {
    public void execute(Map<String, String> arguments);
}
