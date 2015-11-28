package com.inet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropsTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream in = Files.newInputStream(Paths.get("config.properties"));
        properties.load(in);
        String url = properties.remove("url").toString();
        System.out.println(properties);
        System.out.println("Кирилиця");
    }
}
