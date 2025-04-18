package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.utils.Version;

import java.util.Map;

public class VersionCommand implements Command {

    @Override
    public void execute(Map<String, String> arguments) {
        System.out.println("Kon CLI - Conversor de Unidades");
        System.out.println("Versão: " + Version.getVersion());
    }

}
