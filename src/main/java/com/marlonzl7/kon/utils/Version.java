package com.marlonzl7.kon.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Version {

    private static final String VERSION_FILE = "version.properties";
    private static final Properties properties = new Properties();
    private static boolean loaded = false;

    private static void loadProperties() {
        if (loaded) return;

        try (InputStream input = Version.class.getClassLoader().getResourceAsStream(VERSION_FILE)) {
            if (input != null) {
                properties.load(input);
                loaded = true;
            } else {
                System.err.println("Arquivo version.properties não encontrado");
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar version.properties: " + e.getMessage());
        }
    }

    public static String getVersion() {
        loadProperties();
        return properties.getProperty("version", "Versão desconhecida");
    }

}
